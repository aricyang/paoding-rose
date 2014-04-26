package org.fei.hello.controllers;


import org.fei.hello.dao.DictDAO;
import org.fei.hello.model.Dict;
import org.springframework.beans.factory.annotation.Autowired;

public class Query {

    @Autowired
    DictDAO dictDao;

    public void haha() {
        for (Dict d : dictDao.fetchAll()) {
            System.out.println(d);
        }
        System.out.println("hahahahah");
    }
}
