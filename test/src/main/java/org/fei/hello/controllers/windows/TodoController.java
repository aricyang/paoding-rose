package org.fei.hello.controllers.windows;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.portal.Window;

import java.util.ArrayList;
import java.util.List;

@Path("todo")
public class TodoController {
    // 在控制器使用全局变量并不好，在此仅是一个演示而已
    private int count;

    // 方法名是什么不要紧，关进是@Get代表了这个方法用于处理对/todo的GET请求
    @Get
    public String xxx(Invocation inv, Window window) {
        List<String> list = new ArrayList<String>();
        list.add("吃饭");
        list.add("睡觉");
        list.add(String.valueOf(count++));
        inv.addModel("todolist", list);
        // 返回页面，rose将从这个模块对应的/views/windows下找名字以todo开始的页面
        return "todo";
    }
}

