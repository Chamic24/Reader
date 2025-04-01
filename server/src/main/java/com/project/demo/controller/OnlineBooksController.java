package com.project.demo.controller;

import com.project.demo.entity.OnlineBooks;
import com.project.demo.service.OnlineBooksService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;

/**
 * 线上图书：(OnlineBooks)表控制层
 *
 */
@RestController
@RequestMapping("/online_books")
public class OnlineBooksController extends BaseController<OnlineBooks, OnlineBooksService> {

    /**
     * 线上图书对象
     */
    @Autowired
    public OnlineBooksController(OnlineBooksService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
