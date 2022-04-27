package com.skinnovation.bizservice.service.common;

import com.skinnovation.bizservice.service.common.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userVo = userMapper.findById(username);
        if (userVo == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        return userVo;
    }
}
