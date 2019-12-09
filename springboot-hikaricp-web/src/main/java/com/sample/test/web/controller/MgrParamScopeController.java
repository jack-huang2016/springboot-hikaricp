package com.sample.test.web.controller;

import com.github.pagehelper.PageHelper;
import com.sample.test.common.entity.MgrParamScope;
import com.sample.test.dao.MgrParamScopeMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/mgr")
public class MgrParamScopeController {

    @Resource
    private MgrParamScopeMapper mgrParamScopeMapper;

    @RequestMapping("/search")
    public List<MgrParamScope> select(){
        PageHelper.startPage(1, 5); //分页，第一页的5条数据，下标从1开始，不是从0开始
        return mgrParamScopeMapper.selectByParams(null);
    }
}
