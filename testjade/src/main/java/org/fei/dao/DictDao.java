package org.fei.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import org.fei.model.Dict;

import java.util.List;

@DAO(catalog = "test")
public interface DictDao {

    @SQL("SELECT * from dict ")
    public List<Dict> fetchAll();
}
