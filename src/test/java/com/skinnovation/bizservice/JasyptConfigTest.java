package com.skinnovation.bizservice;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;

@Slf4j
public class JasyptConfigTest {
    @Test
    void jasypt(){
        String url = "jdbc:log4jdbc:sqlserver://127.0.0.1:1433;DatabaseName=SKI_LCA_WEB";
        String username = "sa";
        String password = "qwer1234!$";

        String encryptUrl = jasyptEncrypt(url);
        String encryptUsername = jasyptEncrypt(username);
        String encryptPassword = jasyptEncrypt(password);

        log.debug("## encryptUrl: {}", encryptUrl);
        log.debug("## encryptUsername: {}", encryptUsername);
        log.debug("## encryptPassword: {}", encryptPassword);

        Assertions.assertThat(url).isEqualTo(jasyptDecryt(encryptUrl));
    }

    private String jasyptEncrypt(String input) {
        String key = "ski-lca-life";
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setAlgorithm("PBEWithMD5AndDES");
        encryptor.setPassword(key);

        return encryptor.encrypt(input);
    }

    private String jasyptDecryt(String input){
        String key = "ski-lca-life";
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setAlgorithm("PBEWithMD5AndDES");
        encryptor.setPassword(key);

        return encryptor.decrypt(input);
    }
}
