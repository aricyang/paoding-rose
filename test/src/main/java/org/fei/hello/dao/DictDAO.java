package org.fei.hello.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import org.fei.hello.model.Dict;

import java.util.List;

@DAO(catalog = "test")
public interface DictDAO {

    @SQL("SELECT * from dict ")
    public List<Dict> fetchAll();
}
