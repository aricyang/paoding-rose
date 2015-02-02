package org.fei.hello.controllers;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import org.apache.commons.lang.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Path("")
@Controller
public class MainController {

    @Autowired
    Query query;

    @Get("")
    public String main() {
        System.out.println("xxxxxxxxxxxxxxxxxxx");

        //query.haha();

        //query.testReport();

        StopWatch s = new StopWatch();
        s.start();
        //query.getDealNextCSRateList();
        query.haha3();

        s.stop();
        System.out.println("query time: " + s.getTime()/1000.0);



        return "index";
        //return "redirect:/world";
    }
}
