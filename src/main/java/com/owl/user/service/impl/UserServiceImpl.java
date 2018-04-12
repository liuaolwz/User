package com.owl.user.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.owl.user.api.request.ListUserRequest;
import com.owl.user.api.request.SaveOrUpdateUserRequest;
import com.owl.user.entity.User;
import com.owl.user.enums.AppError;
import com.owl.user.exception.NotFoundException;
import com.owl.user.repository.UserRepository;
import com.owl.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserRepository, User> implements UserService {
    @Override
    public Page<User> selectPage(final ListUserRequest listUserRequest) {
        Page<User> page = new Page<>(listUserRequest.getPageNum(), listUserRequest.getPageSize());
//        baseMapper.selectByPage(page,listUserRequest);
        EntityWrapper<User> wrapper = initPageWrapper(listUserRequest);
        return page.setRecords(baseMapper.selectPage(page, wrapper));
    }

    /**
     * 构建查询wrapper，不建议使用，复杂的查询条件最好写到mapper.xml中
     */
    private EntityWrapper<User> initPageWrapper(ListUserRequest listUserRequest) {
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        if (StringUtils.isNoneBlank(listUserRequest.getName())) {
            //构建like条件
            wrapper.like("name", listUserRequest.getName());
        }
        if (listUserRequest.getAgeStart() != null) {
            //构建>=条件
            wrapper.ge("age", listUserRequest.getAgeStart());
        }
        if (listUserRequest.getAgeEnd() != null) {
            //构建<=条件
            wrapper.le("age", listUserRequest.getAgeEnd());
        }
        //以entity非空字段作为条件
        User user = User.builder().gender(listUserRequest.getGender()).build();
        wrapper.setEntity(user);
        return wrapper;
    }

    @Override
    public User save(final SaveOrUpdateUserRequest saveOrUpdateUserRequest) {
        User user = new User();
        BeanUtils.copyProperties(saveOrUpdateUserRequest, user);
        baseMapper.insert(user);
        return user;
    }

    @Override
    public User edit(final Long id, final SaveOrUpdateUserRequest saveOrUpdateUserRequest) {
        User user = baseMapper.selectById(id);
//        Assert.notNull(user,"ID=" + id + "用户不存在");
        if (user == null) {
            log.error("用户[id={}]不存在", id);
            throw new NotFoundException(AppError.ERROR_USER_NOT_EXIST, "ID=" + id + "用户不存在");
        }
        BeanUtils.copyProperties(saveOrUpdateUserRequest, user);
        baseMapper.updateById(user);
        return user;
    }

    @Override
    public void delete(Long id) {
        User user = baseMapper.selectById(id);
        if (user == null) {
            log.error("用户[id={}]不存在", id);
            throw new NotFoundException(AppError.ERROR_USER_NOT_EXIST, "ID=" + id + "用户不存在");
        }
        baseMapper.deleteById(id);
    }
}
