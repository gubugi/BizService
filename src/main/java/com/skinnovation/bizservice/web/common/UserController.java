package com.skinnovation.bizservice.web.common;

import com.skinnovation.bizservice.config.JwtTokenProvider;
import com.skinnovation.bizservice.service.common.UserMapper;
import com.skinnovation.bizservice.service.common.UserService;
import com.skinnovation.bizservice.service.common.vo.LoginVo;
import com.skinnovation.bizservice.service.common.vo.UserReqVo;
import com.skinnovation.bizservice.service.common.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/user/v1")
@RestController
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    // 회원가입
    @PostMapping("/join")
    public ResponseEntity<Integer> join(@RequestBody UserReqVo userReqVo) {
        userReqVo.setUserCryptoPw(passwordEncoder.encode(userReqVo.getUserPw()));
        int inRow = userService.saveUser(userReqVo);

        return ResponseEntity.ok(inRow);
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginVo loginVo) {
        UserVo member = userService.findById(loginVo.getUserId());
        if (member == null) {
            throw new IllegalArgumentException("가입되지 않은 E-MAIL 입니다.");
        }
        log.debug("user info : {}", member);
        if (!passwordEncoder.matches(loginVo.getUserPw(), member.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        return ResponseEntity.ok(jwtTokenProvider.createToken(member.getUsername(), member.getRoles()));
    }
}
