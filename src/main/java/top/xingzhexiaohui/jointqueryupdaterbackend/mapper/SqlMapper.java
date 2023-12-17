package top.xingzhexiaohui.jointqueryupdaterbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SqlMapper {
    @Select("${sql}") // 忽视这个报错，这是 IDE 的问题
    List<Map<String, Object>> executeSql(String sql);
}
