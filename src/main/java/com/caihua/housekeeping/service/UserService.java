package com.caihua.housekeeping.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.caihua.housekeeping.entity.User;
import com.caihua.housekeeping.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

}
