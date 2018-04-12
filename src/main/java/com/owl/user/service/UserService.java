package com.owl.user.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.owl.user.api.request.ListUserRequest;
import com.owl.user.api.request.SaveOrUpdateUserRequest;
import com.owl.user.entity.User;

public interface UserService extends IService<User> {
    Page<User> selectPage(final ListUserRequest listUserRequest);

    User save(final SaveOrUpdateUserRequest saveOrUpdateUserRequest);

    User edit(final Long id, final SaveOrUpdateUserRequest saveOrUpdateUserRequest);

    void delete(final Long id);
}
