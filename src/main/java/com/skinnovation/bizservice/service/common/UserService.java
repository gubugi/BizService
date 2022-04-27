package com.skinnovation.bizservice.service.common;

import com.skinnovation.bizservice.service.common.vo.UserReqVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int saveUser(UserReqVo vo) {
        log.info("user service : {}", vo);
        return userMapper.saveUser(vo);
    }


}