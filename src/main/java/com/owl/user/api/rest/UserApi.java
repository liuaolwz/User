package com.owl.user.api.rest;

import com.baomidou.mybatisplus.plugins.Page;
import com.owl.user.api.request.ListUserRequest;
import com.owl.user.api.request.SaveOrUpdateUserRequest;
import com.owl.user.entity.User;
import com.owl.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "api/owl/v1/users")
public class UserApi {
    private final UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ApiOperation(value = "新增用户")
    public User save(@Valid @RequestBody final SaveOrUpdateUserRequest saveOrUpdateUserRequest) {
        return userService.save(saveOrUpdateUserRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "删除用户")
    public void delete(final Long id) {
        userService.delete(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "修改用户")
    public User edit(@PathVariable("id") final Long id, @RequestBody final SaveOrUpdateUserRequest saveOrUpdateUserRequest) {
        return userService.edit(id, saveOrUpdateUserRequest);
    }

    @GetMapping
    @ApiOperation(value = "分页获取用户列表")
    public Page<User> list(@Valid @ModelAttribute ListUserRequest listUserRequest) {
        return userService.selectPage(listUserRequest);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "查看用户详情")
    public User detail(final Long id) {
        return userService.selectById(id);
    }
}
