package top.xingzhexiaohui.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateKey {
    private String table;
    private int id;
}
