package com.skinnovation.bizservice.web.sample;

import com.skinnovation.bizservice.service.sample.SampleService;
import com.skinnovation.bizservice.service.sample.vo.SampleAddVo;
import com.skinnovation.bizservice.service.sample.vo.SampleReqVo;
import com.skinnovation.bizservice.service.sample.vo.SampleRespVo;
import com.skinnovation.bizservice.service.sample.vo.SampleSearchReqVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = {"샘플 API"})
@RequestMapping(value = "/v1/sample")
@RestController
public class SampleController {
    private static final Logger logger = LogManager.getLogger(SampleController.class);

    @Value("${jasypt.encryptor.password}")
    private String PASSWORD;

    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @Operation(summary = "Test hello", description = "hello api example")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK !!"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
    })
    @GetMapping("/hello")
    public ResponseEntity<String> hello(@Parameter(description = "이름", required = true, example = "Park") @RequestParam String name) {
        logger.debug("## debug > {}", name);
        logger.info("!! info > {}", name);
        logger.warn("$$ warn > {}", name);
        return ResponseEntity.ok("hello " + name);
    }

    @Operation(summary = "index", description = "index api")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK !!"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!")
    })
    @GetMapping("/index")
    public ResponseEntity<String> index(SampleReqVo vo) {
        log.debug("SampleReqVo : {}", vo);
        log.info("SampleReqVo : {}", vo);
        return ResponseEntity.ok("hello ok");
    }

    @GetMapping("/info")
    @Operation(summary = "User 조회", description = "사용자 정보를 조회한다.")
    public ResponseEntity<SampleRespVo> userInfo(@Validated SampleSearchReqVo vo) {
        log.debug("SampleReqVo : {}", vo);

        return ResponseEntity.ok(sampleService.findUser(vo));
    }

    @PostMapping("/add")
    @Operation(summary = "User 등록", description = "사용자를 등록한다.")
    public ResponseEntity<Integer> insertUser(@RequestBody SampleAddVo vo) {
        log.debug("SampleReqVo : {}", vo);
        int changRow = sampleService.insertUser(vo);
        return ResponseEntity.ok(Integer.valueOf(changRow));
    }

    @GetMapping("/encrypt")
    public ResponseEntity<String> encrypt(@RequestParam String str) {
        log.debug("## String : {}", str);
        log.debug("PASSWORD : {}", PASSWORD);
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(PASSWORD);

        String enc = pbeEnc.encrypt(str);
        log.debug("enc = {}", enc);

        return ResponseEntity.ok(enc);
    }

    @GetMapping("/decrypt")
    public ResponseEntity<String> decrypt(@RequestParam String str) {
        log.debug("## String : {}", str);
        log.debug("PASSWORD : {}", PASSWORD);

        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword(PASSWORD);

        String des = pbeEnc.decrypt(str);
        log.debug("des = {}", des);

        return ResponseEntity.ok(des);
    }
}
