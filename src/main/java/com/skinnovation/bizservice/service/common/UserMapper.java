package com.skinnovation.bizservice.service.common;

import com.skinnovation.bizservice.service.common.vo.LoginVo;
import com.skinnovation.bizservice.service.common.vo.UserReqVo;
import com.skinnovation.bizservice.service.common.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserVo findById(String userId);
    int saveUser(UserReqVo vo);
}
