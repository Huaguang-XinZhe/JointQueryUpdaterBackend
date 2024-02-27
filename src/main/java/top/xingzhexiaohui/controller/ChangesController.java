package top.xingzhexiaohui.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xingzhexiaohui.dto.Result;
import top.xingzhexiaohui.dto.UpdateObj;
import top.xingzhexiaohui.service.ChangesService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/changes")
public class ChangesController {
    @Autowired
    ChangesService changesService;

    @PostMapping("/update")
    public Result update(@RequestBody List<UpdateObj> updateObjs) {
        log.error("updateObjs = " + updateObjs);
        String errorMessage = changesService.updateDB(updateObjs);

        if (errorMessage == null) {
            return Result.success();
        } else {
            return Result.error(errorMessage);
        }
    }
}
