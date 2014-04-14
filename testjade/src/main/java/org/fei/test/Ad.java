package org.fei.test;


import org.fei.dao.DictDao;
import org.fei.model.Dict;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Ad implements query{
    @Autowired
    private DictDao dao;

    public List<Dict> query() {
        return dao.fetchAll();
    }
}
