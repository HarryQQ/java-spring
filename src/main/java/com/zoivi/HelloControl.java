package com.zoivi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/3/26 0026.
 */


@RestController
@RequestMapping("/hello")
public class HelloControl {

    // 将配置中的变量引进class
    @Autowired
    private GirlProperties girlProperties;
    // 路径直接带参
    @RequestMapping(value = {"/say/{id}", "/hi"}, method = RequestMethod.GET)
    public String say (@PathVariable("id") Integer id) {
        return "id" + id;
    }

    // 路径问号再带参数
    @RequestMapping(value = {"/move", "/hi"}, method = RequestMethod.GET)
    public String move (@RequestParam(value="id", required = false,defaultValue = "234234") Integer id) {
        return "id" + id;
    }

    // requestMapping的简写模式
    @GetMapping(value={"/getList"})
    public String getList () {
        return "这是一个简写的get请求";
    }
}
