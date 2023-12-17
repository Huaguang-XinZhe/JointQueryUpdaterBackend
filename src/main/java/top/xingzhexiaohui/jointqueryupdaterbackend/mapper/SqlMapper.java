package top.xingzhexiaohui.jointqueryupdaterbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface SqlMapper {
    @Select("${sql}")
    List<LinkedHashMap<String, Object>> executeSql(String sql);
}

