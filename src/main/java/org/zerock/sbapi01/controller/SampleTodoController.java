package org.zerock.sbapi01.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/api1")
public class SampleTodoController {


    @GetMapping("/getArr")
    public String[] getArr() {

        return new String[] {"AAA","BBB","CCC"};

    }


}
