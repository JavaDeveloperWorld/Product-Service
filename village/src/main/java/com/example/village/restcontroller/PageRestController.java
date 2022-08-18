package com.example.village.restcontroller;

import com.example.village.model.Page;
import com.example.village.service.page.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PageRestController {
    @Autowired
    PageService pageService;

    @GetMapping("/myMainPageDetails")
    public List<Page> getAllList(){
        return pageService.getAllInformation();
    }
}
