package com.skinnovation.bizservice.service.common;

import com.skinnovation.bizservice.service.common.vo.UserInfoVo;
import com.skinnovation.bizservice.service.common.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfoVo userInfo = userMapper.findById(username);
        if (userInfo == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

        List<String> roles = new ArrayList<>();
        if (!userInfo.getUserRole().trim().equals("")) {
            roles.add(userInfo.getUserRole().trim());
        }
        UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return roles.stream()
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
            }

            @Override
            public String getPassword() {
                return userInfo.getUserPw();
            }

            @Override
            public String getUsername() {
                return userInfo.getUserId();
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };

        return userDetails;
    }
}
