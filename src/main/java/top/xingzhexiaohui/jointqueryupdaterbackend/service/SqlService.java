package top.xingzhexiaohui.jointqueryupdaterbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.xingzhexiaohui.jointqueryupdaterbackend.mapper.SqlMapper;

import java.util.List;
import java.util.Map;

@Service
public class SqlService {
    @Autowired
    private SqlMapper sqlMapper;

    @Transactional
    public List<Map<String, Object>> executeSql(String sql) {
        //todo: 这里应该添加对 SQL 的验证和清理，以防止 SQL 注入
        return sqlMapper.executeSql(sql);
    }
}
