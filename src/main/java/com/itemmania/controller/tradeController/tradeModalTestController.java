package com.itemmania.controller.tradeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tradeModalTest")
public class tradeModalTestController {

    @GetMapping
    public String tradeModal(){
        return "tradeTest/tradeModalTest";
    }

}
