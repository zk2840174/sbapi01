package org.zerock.sbapi01.util;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;


@SpringBootTest
@Log4j2
public class JWTUtilTests {

    @Autowired
    private JWTUtil jwtUtil;

    @Test
    public void testGenerate() {

        Map<String, Object> claimMap = Map.of("email", "test@aaaa.com");

        String jwtStr = jwtUtil.generateToken(claimMap, 10);

        log.info(jwtStr);
    }

    @Test
    public void testValidate() {

        //유효시간이 지난 토큰
        String jwtStr = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6InRlc3RAYWFhYS5jb20iLCJpYXQiOjE2Nzc3MjI1MjQsImV4cCI6MTY3NzcyMzEyNH0.UOQ6dlYjVFWYVuBnsADL3Etl40uTdJY1Gy3X0lXFvzU";
        Map<String, Object> claim = jwtUtil.validateToken(jwtStr);

        log.info(claim);

    }
}