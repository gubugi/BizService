package com.skinnovation.bizservice.service.common.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVo implements UserDetails {
    @Schema(description = "사용자번호", defaultValue = "0")
    private Long userNo;

    @Schema(description = "사용자아이디")
    private String userId;

    @Schema(description = "사용자암호")
    private String userPw;

    @Schema(description = "사용자이름")
    private String userNm;

    @Schema(description = "사용자이메일")
    private String userEmail;

    @Schema(description = "사용자권한")
    private String userRole;

    @Builder.Default
    private List<String> roles = new ArrayList<>();

    public void setRoles() {
        if (userRole != null && !userRole.equals("")) {
            roles.add(userRole);
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return userPw;
    }

    @Override
    public String getUsername() {
        return userId;
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
}
