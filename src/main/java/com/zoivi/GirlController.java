package com.zoivi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2017/3/26 0026.
 */
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRespository;

    @GetMapping(value="/girls")
    public List<Girl> girlList () {
        return girlRespository.findAll();
    }

    /**
     * 添加一个girl
     * @param cupSize
     * @param age
     * @return
     */
    @PostMapping(value="/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRespository.save(girl);
    }

    @GetMapping(value="/girls/{id}")
    public Girl girlFindOne (@PathVariable("id") Integer id) {
        return girlRespository.findOne(id);
    }

    @PutMapping(value="/girls/{id}")
    public void girlUpdate (@PathVariable("id") Integer id,
                            @RequestParam("cupSize") String cupSize,
                            @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setId(id);
        girlRespository.save(girl);
    }
}
