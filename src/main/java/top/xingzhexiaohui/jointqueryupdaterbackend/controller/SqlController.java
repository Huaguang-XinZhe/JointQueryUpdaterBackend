package top.xingzhexiaohui.jointqueryupdaterbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xingzhexiaohui.jointqueryupdaterbackend.dto.Result;
import top.xingzhexiaohui.jointqueryupdaterbackend.service.SqlService;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("api/sql")
public class SqlController {
    @Autowired
    private SqlService sqlService;

    @PostMapping("/execute")
    public Result executeSql(@RequestBody String sql) {
        try {
            List<LinkedHashMap<String, Object>> result = sqlService.executeSql(sql);
            System.out.println("result = " + result);
            return Result.success(result);
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
}
