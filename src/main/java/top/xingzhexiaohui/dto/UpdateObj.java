package top.xingzhexiaohui.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 接收前端传来的更新数据。
 * <p>
 * 可以只接收部分数据，但层次结构一定要匹配；
 * 也可以改名，但是要用 @JsonProperty 注解。
 */
@Data
public class UpdateObj {
//    String originalValue;
    @JsonProperty("changedValue")
    String value;
    @JsonProperty("fieldName")
    String column;
    @JsonProperty("rowId")
    int id;
    @JsonProperty("tableName")
    String table;
}