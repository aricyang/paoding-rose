package org.fei.hello.controllers;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import org.springframework.beans.factory.annotation.Autowired;

@Path("")
public class MainController {

    @Autowired
    Query query;

    @Get("")
    public String main() {
        System.out.println("xxxxxxxxxxxxxxxxxxx");

        query.haha();

        return "index";
        //return "redirect:/world";
    }
}
