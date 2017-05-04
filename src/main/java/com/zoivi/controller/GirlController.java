package com.zoivi.controller;

import com.zoivi.domain.Girl;
import com.zoivi.domain.Result;
import com.zoivi.repository.GirlRepository;
import com.zoivi.service.GirlService;
import com.zoivi.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/26 0026.
 */
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRespository;
    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/girls")
    public Result<ArrayList<Girl>> girlList() {
        return ResultUtil.success(girlRespository.findAll());
    }

    /**
     * 添加一个girl
     *
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return ResultUtil.success(girlRespository.save(girl));
    }

    // 另一种添加方法，并且包含标准返回格式
    @PostMapping(value = "/girls/otheradd")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) { // 第二个参数是验证结果
        if (bindingResult.hasErrors()) { // 当有验证错误时
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());// 提示信息设置为在对象字段已经定义好的错误信息
        }
        girl.setAge(girl.getAge());
        girl.setCupSize(girl.getCupSize());
        return ResultUtil.success(girlRespository.save(girl));
    }

    //    根据年龄查找
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlFindByAge(@PathVariable("age") Integer age) {
        return girlRespository.findByAge(age);
    }

    // 查找
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRespository.findOne(id);
    }

    // 加了判断的查询
    @GetMapping(value = "/girls/getAge/{id}")
    public Result<Girl> getAge(@PathVariable("id") Integer id) throws Exception {
        return ResultUtil.success(girlService.getAgeMessage(id));
    }

    // 更新
    @PutMapping(value = "/girls/{id}")
    public Result girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setId(id);
        girlRespository.save(girl);
        return ResultUtil.success();
    }

    // 删除
    @DeleteMapping(value = "/girls/{id}")
    public Result girlDelete(@PathVariable("id") Integer id) {
        girlRespository.delete(id);
        return ResultUtil.success();
    }

    // 增加两个
    @PostMapping(value = "girls/two")
    public Result girlTwo() {
        girlService.insertTwo();
        return ResultUtil.success();
    }
}
