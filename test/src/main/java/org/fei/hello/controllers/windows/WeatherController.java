package org.fei.hello.controllers.windows;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Path("weather")
public class WeatherController {
    // 这个方法处理"/windows/weather"，它只是返回一串中文，而非jsp、vm等页面
    @Get
    public String xxx(Invocation inv) {
        return "@今天天气真好，花儿都开料!";
    }
}
