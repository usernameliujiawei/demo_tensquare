package com.tensquare.recruit.base.controller;

import com.tensquare.recruit.base.pojo.Label;
import com.tensquare.recruit.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签 控制层
 */

@RestController
@CrossOrigin
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    @RequestMapping(method = RequestMethod.GET)
    public Result findAll(){
        return new Result(true, StatusCode.OK, "查询成功", labelService.findAll());
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.GET)
    public Result findById(@PathVariable("labelId") String labelId){
        int i = 1/0;
        return new Result(true, StatusCode.OK, "查询成功", labelService.findById(labelId));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result save(@RequestBody Label label){
        labelService.save(label);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.PUT)
    public Result update(@PathVariable String labelId, @RequestBody Label label){
        label.setId(labelId);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "更新成功");
    }

    @RequestMapping(value = "/{labelId}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String labelId){
        labelService.deleteById(labelId);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 多条件查询（标签名+状态）
     * @param label
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@PathVariable Label label){
        List<Label> list = labelService.findSearch(label);
        return new Result(true, StatusCode.OK, "查询成功",list);
    }

    /**
     * 多条件分页查询（标签名+状态）
     * @param label
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result pageQuery(@PathVariable Label label,@PathVariable int page,@PathVariable int size){
        Page<Label> pageDate = labelService.pageQuery(label,page,size);
        //pageDate.getTotalElements()-->总记录数
        //pageDate.getContent()-->list集合（当前页内容）
        return new Result(true, StatusCode.OK, "查询成功",new PageResult<Label>(pageDate.getTotalElements(),pageDate.getContent()));
    }






}
