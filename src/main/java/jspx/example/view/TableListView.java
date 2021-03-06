/*
 * Copyright © 2004-2014 chenYuan. All rights reserved.
 * @Website:wwww.jspx.net
 * @Mail:39793751@qq.com
 * @author: chenYuan , 陈原
 * @License: Jspx.net Framework Code is open source (LGPL)，Jspx.net Framework 使用LGPL 开源授权协议发布。
 * @jvm:jdk1.6+  x86/amd64
 *
 */
package jspx.example.view;


import com.github.jspxnet.txweb.annotation.HttpMethod;
import com.github.jspxnet.txweb.annotation.Operate;
import com.github.jspxnet.txweb.annotation.Param;
import com.github.jspxnet.txweb.result.RocResponse;
import com.github.jspxnet.txweb.support.ActionSupport;
import com.github.jspxnet.utils.StringUtil;
import jspx.example.table.Employee;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA.
 * User: chenYuan
 * Date: 2009-8-11
 * Time: 11:05:36
 * jspx.example.action.TableListAction
 */

public class TableListView extends ActionSupport
{
    final private static String sessionSave = "sessionSave";


    //演示数据，实际使用的时候是数据库
    private static List<Employee> list = new LinkedList<Employee>();

    static
    {
        Employee ep = new Employee();
        ep.setName("xiaoMing");
        ep.setSex("男");
        ep.setOld(23);
        list.add(ep);

        ep = new Employee();
        ep.setName("xiaoHong");
        ep.setSex("女");
        ep.setOld(21);
        list.add(ep);

        for (int i = 0; i < 30; i++)
        {
            ep = new Employee();
            ep.setName("name-" + i);
            ep.setSex("女");
            ep.setOld(20 + i);
            list.add(ep);
        }

    }

    //-------------------
    /**
     * 返回建议统一是用 RocResponse 对象封装
     * @return 数据列表,可以翻页
     */
    @Operate(caption = "列表",method = "list")
    public RocResponse<List<Employee>> getList()
    {
        return RocResponse.success(list).setCurrentPage(1).setTotalCount(list.size());
    }

    @Operate(caption = "翻页列表",method = "list/page")
    public RocResponse<List<Employee>> getListPage( @Param(caption = "行数") int count,
                                                    @Param(caption = "当前页数") int currentPage)
    {
        return RocResponse.success(list).setCurrentPage(1).setCurrentPage(currentPage).setTotalCount(list.size());
    }


}