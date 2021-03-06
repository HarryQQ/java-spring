package com.zoivi.controller;

import com.zoivi.domain.Result;
import com.zoivi.domain.User;
import com.zoivi.repository.UserRepository;
import com.zoivi.service.UserService;
import com.zoivi.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by qhr on 2017/5/17.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    // 另一种添加方法，并且包含标准返回格式
    @PostMapping(value = "/user/register") // 注册
    public Result<User> register(@Valid User user, BindingResult bindingResult) { // 第二个参数是验证结果
        if (bindingResult.hasErrors()) { // 当有验证错误时
            // 提示信息设置为在对象字段已经定义好的错误信息
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        user.setUsername(user.getUsername());
        user.setPassword(user.getPassword());
        return ResultUtil.success(userRepository.save(user));
    }

    @PostMapping(value = "/user/login")
    public Result<User> login(@NotNull(message = "用户名不能为空") @RequestParam("username") String username,
                              @NotNull(message = "密码不能为空") @RequestParam("password") String password
                              ) throws Exception {
        return ResultUtil.success(userService.findByUsername(username));
    }
}
