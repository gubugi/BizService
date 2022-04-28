package com.skinnovation.bizservice.web.common;

import com.skinnovation.bizservice.config.JwtTokenProvider;
import com.skinnovation.bizservice.service.common.UserService;
import com.skinnovation.bizservice.service.common.vo.*;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Api(tags = {"User API"})
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
    public ResponseEntity<TokenVo> login(@RequestBody LoginVo loginVo) {
        if (loginVo == null) {
            throw new IllegalArgumentException("가입되지 않은 사용자 입니다.");
        }
        log.debug("> Login Id : {}", loginVo.getUserId());
        log.debug("> Login pw : {}", loginVo.getUserPw());
        UserInfoVo member = userService.findById(loginVo.getUserId());
        if (member == null) {
            throw new IllegalArgumentException("가입되지 않은 사용자 입니다.");
        }
        log.debug("user info : {}", member);
        if (!passwordEncoder.matches(loginVo.getUserPw(), member.getUserPw())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
        List<String> roles = new ArrayList<>();
        if (!member.getUserRole().trim().equals("")) {
            roles.add(member.getUserRole().trim());
        }
        Date now = new Date();
        TokenVo tokenVo = new TokenVo();
        tokenVo.setUserId(loginVo.getUserId());
        tokenVo.setUserToken(jwtTokenProvider.createToken(member.getUserNm(), roles));
        tokenVo.setIssuedAt(now);

        return ResponseEntity.ok(tokenVo);
    }

    // 암호찾기
    @GetMapping("/make/password")
    public ResponseEntity<String> login(@RequestParam String str) {
        log.debug("> input string : {}", str);
        return ResponseEntity.ok(passwordEncoder.encode(str));
    }
}
