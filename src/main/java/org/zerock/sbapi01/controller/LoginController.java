package org.zerock.sbapi01.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.sbapi01.service.SocialLoginService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Log4j2
public class LoginController {


    private final SocialLoginService kakaoLoginService;

    @GetMapping("/kakao/login/")
    public Map<String, String> getKakaoUserEmail(String authCode){

        String email = kakaoLoginService.getKakaoEmail(authCode);

        log.info("-------------------------------");
        log.info(email);

        return Map.of("email", email);
    }

}
