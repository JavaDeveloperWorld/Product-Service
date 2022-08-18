package com.example.village.service.page;

import com.example.village.dao.page.PageRepository;
import com.example.village.model.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    PageRepository pageRepository;

    public List<Page> getAllInformation(){
        return pageRepository.getAllInformation();
    }
}
