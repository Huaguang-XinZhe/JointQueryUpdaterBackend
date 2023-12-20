package top.xingzhexiaohui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.xingzhexiaohui.dto.UpdateKey;
import top.xingzhexiaohui.dto.UpdateObj;
import top.xingzhexiaohui.mapper.ChangesMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChangesService {
    @Autowired
    private ChangesMapper changesMapper;

    @Transactional
    public String updateDB(List<UpdateObj> updateObjs) {
        // 同一张表同一行的不同列，放在一起更新
        // 对 updateObjs 进行分组
        Map<UpdateKey, Map<String, Object>> groupedUpdates = new HashMap<>();

        for (UpdateObj updateObj : updateObjs) {
            UpdateKey key = new UpdateKey(updateObj.getTable(), updateObj.getId());
            // computeIfAbsent() 方法的作用是：如果 key 不存在，则创建一个新的 value，否则返回已存在的 value
            groupedUpdates.computeIfAbsent(key, k -> new HashMap<>())
                    .put(updateObj.getColumn(), updateObj.getValue());
        }
        System.out.println("groupedUpdates = " + groupedUpdates);

        try {
            // 调用MyBatis映射器执行更新
            for (Map.Entry<UpdateKey, Map<String, Object>> entry : groupedUpdates.entrySet()) {
                UpdateKey key = entry.getKey();
                // 一次更新一行
                changesMapper.updateTable(key.getTable(), key.getId(), entry.getValue());
            }
        } catch (Exception e) {
            return e.getMessage();
        }

        return null;
//        updateObjs.forEach(updateObj -> {
//            String sql = String.format("update %s set %s = '%s' where id = '%s'",
//                    updateObj.getTable(), updateObj.getColumn(), updateObj.getValue(), updateObj.getId());
//            changesMapper.update(sql);
//        });
    }
}
