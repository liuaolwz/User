package com.owl.user.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.owl.user.api.request.ListUserRequest;
import com.owl.user.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseMapper<User> {
    Page<User> selectByPage(Pagination page, @Param("userRequest") ListUserRequest userRequest);
}
