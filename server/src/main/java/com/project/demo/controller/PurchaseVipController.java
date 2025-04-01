package com.project.demo.controller;

import com.project.demo.entity.PurchaseVip;
import com.project.demo.service.PurchaseVipService;
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
 * 购买VIP：(PurchaseVip)表控制层
 *
 */
@RestController
@RequestMapping("/purchase_vip")
public class PurchaseVipController extends BaseController<PurchaseVip, PurchaseVipService> {

    /**
     * 购买VIP对象
     */
    @Autowired
    public PurchaseVipController(PurchaseVipService service) {
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
