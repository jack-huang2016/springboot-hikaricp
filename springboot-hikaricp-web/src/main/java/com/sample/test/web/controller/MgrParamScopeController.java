package com.sample.test.web.controller;

import com.github.pagehelper.PageHelper;
import com.sample.test.common.entity.MgrParamScope;
import com.sample.test.dao.MgrParamScopeMapper;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/mgr")
public class MgrParamScopeController {

    @Autowired
    private HikariDataSource dataSource;

    @Resource
    private MgrParamScopeMapper mgrParamScopeMapper;

    @RequestMapping("/search")
    public List<MgrParamScope> select(){
        logDS(dataSource); // 验证是否从yml成功注入属性到HikariDataSource数据源了，正常开发不需要这个
        PageHelper.startPage(1, 5); //分页，第一页的5条数据，下标从1开始，不是从0开始
        return mgrParamScopeMapper.selectByParams(null);
    }

    /**
     *@描述 显示数据库连接池信息
     *@参数  [dataSource]
     *@返回值  void
     *@创建人  huang.yj
     *@创建时间  2019/12/11
     */
    private void logDS(DataSource dataSource) {
        HikariDataSource hds = (HikariDataSource) dataSource;
        String info = "\n\n\tHikariCP连接池配置\n\t连接池名称：" +
                hds.getPoolName() +
                "\n\t最小空闲连接数：" +
                hds.getMinimumIdle() +
                "\n\t最大连接数：" +
                hds.getMaximumPoolSize() +
                "\n\t连接超时时间：" +
                hds.getConnectionTimeout() +
                "ms\n\t空闲连接超时时间：" +
                hds.getIdleTimeout() +
                "ms\n\t连接最长生命周期：" +
                hds.getMaxLifetime() +
                "ms\n";
        log.info(info);
    }
}
