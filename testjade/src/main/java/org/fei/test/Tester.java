package org.fei.test;


import net.paoding.rose.scanning.context.RoseAppContext;
import org.fei.model.Dict;

import java.util.List;

public class Tester {


    public static void main(String[] args) {

        RoseAppContext r = new RoseAppContext();

        Ad adapter = r.getBean(Ad.class);

        List<Dict> l = adapter.query();
        System.out.println("xxxxxxxxx");
    }
}
