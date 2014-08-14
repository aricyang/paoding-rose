package org.fei.hello.controllers;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.portal.Portal;

@Path("portal")
public class PortalController {
    // 标注@Get,表示这个方法要处理的是对/portal的GET请求
    // 在主控控制方法上声明Portal参数即表示这个页面是portal，就这样!
    @Get
    public String home(Portal portal) throws Exception {

        System.out.println("==========================");

        // 使用addWindow向这个portal页面加入各种子信息(我们成为窗口)
        portal.addWindow("weather", "/windows/weather");

        // 第一个参数是用于标识该窗口，使得portal页面中可以引用到这个窗口的html
        // 第二个参数表示这个窗口的地址(可以包含参数)，这个地址等价于forward的地址(也就是这里只要能forward的地址都可以，无论是否是rose框架的，甚至可以是一个jsp页面)
        // 因此，地址没有说一定要以"/windows"开始
        portal.addWindow("todo", "/windows/todo?name=value");

        return "portal-home";
    }
}
