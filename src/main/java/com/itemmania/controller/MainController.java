package com.itemmania.controller;

import com.itemmania.service.IndexMainService;
import com.itemmania.service.boardService.Search.BoardGameSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private IndexMainService indexMainService;


    @Autowired
    private BoardGameSearch boardGameSearch;
    @GetMapping("/")
    public String getIndexMain(
            Model model
    ){
        model.addAttribute("gameServer",indexMainService.getGameServer());


        // 전체 게임리스트 (메인 검색창 리스트 출력)
        model.addAttribute("searchGame", boardGameSearch.getGameService());
        // 전체 서버리스트
        model.addAttribute("searchServer", boardGameSearch.getServerService());

        return "index";
    }
}
