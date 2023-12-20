package top.xingzhexiaohui.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.xingzhexiaohui.mapper.SqlMapper;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;


@Service
public class SqlService {

    @Autowired
    private SqlMapper sqlMapper;

    public List<LinkedHashMap<String, Object>> executeSql(String sql) {
        List<LinkedHashMap<String, Object>> mapList = sqlMapper.executeSql(sql);

        if (mapList.isEmpty()) {
            return mapList;
        }

        // 获取所有的列名
        Set<String> allColumns = new HashSet<>();
        mapList.forEach(map -> allColumns.addAll(map.keySet()));

        // 为每个 map 补充缺失的列
        mapList.forEach(map -> {
            allColumns.forEach(column -> map.putIfAbsent(column, null));
        });

        return mapList;
    }
}


