package org.fei.hello.dao;


import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;
import org.fei.hello.model.City;
import org.fei.hello.model.DealCsRate;
import org.fei.hello.model.Dict;
import org.fei.hello.model.Pagination;

import java.util.List;

@DAO(catalog = "nuomi_niux_report")
public interface ReportDAO {

    @SQL("SELECT * from city limit 10")
    public List<City> fetchCitis();


    @SQL("SELECT    r.deal_id, type_all.level2, type_all.name2, SUM(r.cs_rate)/100 AS cs_rate," +
                    "CASE WHEN" +
                        " type_all.level3 IN (40101,40102,40103,30101,802,30102) " +
                    "OR" +
                        " type_all.level2 IN (40101,40102,40103,30101,802,30102) " +
                    "THEN '是' ELSE '否' END" + " AS LEVEL, " +
                    "(  SELECT    COUNT(c.id) " +
                        "FROM t_cs_ticket_new c " +
                        "LEFT JOIN ( " +
                            "SELECT tmp.*, t1.id AS level1, t1.name AS name1, t2.id AS level2," +
                                    "t2.name AS name2, t3.id AS level3, t3.name AS name3 " +
                            "FROM (" +
                                "SELECT t.*, SUBSTRING_INDEX(CONCAT(t.code,'...'), '.', 1) AS lv1_code," +
                                        "SUBSTRING_INDEX(CONCAT(t.code,'...'),'.',2) AS lv2_code," +
                                        "SUBSTRING_INDEX(CONCAT(t.code,'...'),'.',3) AS lv3_code  " +
                                "FROM t_cs_ticket_type t " +
                            ") tmp " +
                            "LEFT JOIN t_cs_ticket_type t1 ON tmp.lv1_code=t1.code " +
                            "LEFT JOIN t_cs_ticket_type t2 ON tmp.lv2_code=t2.code " +
                            "LEFT JOIN t_cs_ticket_type t3 ON tmp.lv3_code=t3.code " +
                        ") type_all_sub  ON c.type = type_all_sub.id " +
                        "WHERE r.deal_id = c.deal_id AND type_all_sub.level2 = type_all.level2" +
                    ") AS argue_num " +
         "FROM rpt_deal_cs r " +
         "LEFT JOIN t_cs_ticket_type ty on r.type=ty.id " +
         "LEFT JOIN ( " +
            "SELECT tmp.*, t1.id AS level1, t1.name AS name1, t2.id AS level2, t2.name AS name2, t3.id AS level3, t3.name AS name3 " +
            "FROM ( " +
                "SELECT t.*, SUBSTRING_INDEX(CONCAT(t.code,'...'),'.',1) AS lv1_code, " +
                        "SUBSTRING_INDEX(CONCAT(t.code,'...'),'.',2) AS lv2_code, " +
                        "SUBSTRING_INDEX(CONCAT(t.code,'...'),'.',3) AS lv3_code " +
                "FROM t_cs_ticket_type t " +
            ") tmp " +
            "LEFT JOIN t_cs_ticket_type t1 ON tmp.lv1_code=t1.code " +
            "LEFT JOIN t_cs_ticket_type t2 ON tmp.lv2_code=t2.code " +
            "LEFT JOIN t_cs_ticket_type t3 ON tmp.lv3_code=t3.code " +
         ") type_all ON r.type = type_all.id " +
         "WHERE  r.deal_id > 0 #if(:obj.dealId != null) { and r.deal_id = :obj.dealId} " +
         "AND ty.is_complain=1 "+
         "GROUP BY r.deal_id,type_all.level2 " +
         "#if(:page.orderBy){ order by ##(:page.orderBy) ##(:page.ascDesc) } " +
         "LIMIT :page.startIndex , :page.countEachPage ")
    public List<DealCsRate> getDealCSRateList(@SQLParam("obj") DealCsRate deCsRate,
                                              @SQLParam("page") Pagination page);
}
