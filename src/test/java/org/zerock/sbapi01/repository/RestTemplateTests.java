package org.zerock.sbapi01.repository;

import lombok.extern.log4j.Log4j2;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

@Log4j2
public class RestTemplateTests {

    @Test
    public void testKakao() {

        String code ="ohAj12puKEDnGy8Qwfhp8S-HlxONVoH4_yoPgtp0rpOWqEc6kkQDU2QG6sC53ZUSFFUNuAo9dZsAAAGGle0yyA";

        String url = "https://kauth.kakao.com/oauth/token";

        String clientId = "d0b91c8f74628913ad370e23da5426e9";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type","application/x-www-form-urlencoded");
        HttpEntity<String> entity = new HttpEntity<>(headers);


        UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("grant_type", "authorization_code")
                .queryParam("client_id", clientId)
                .queryParam("redirect_uri","http://localhost:3000/oauth/kakao")
                .queryParam("code", code)
                .build(true);

        ResponseEntity<LinkedHashMap> response = restTemplate.exchange(uriBuilder.toString(), HttpMethod.POST, entity, LinkedHashMap.class);

        log.info(response);

        LinkedHashMap<String, String> bodyMap = response.getBody();

        log.info(bodyMap.get("access_token"));
    }

}
