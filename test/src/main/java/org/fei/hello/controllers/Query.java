package org.fei.hello.controllers;


import org.fei.hello.dao.DictDAO;
import org.fei.hello.dao.OlapDAO;
import org.fei.hello.dao.ReportDAO;
import org.fei.hello.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Query {

    @Autowired
    private DictDAO dictDao;

    @Autowired
    private ReportDAO reportDAO;

    @Autowired
    private OlapDAO olapDAO;

    public void haha() {
        for (Dict d : dictDao.fetchAll()) {
            System.out.println(d);
        }
        System.out.println("hahahahah");
    }

    public void testReport() {
        for (City c : reportDAO.fetchCitis()) {
            System.out.println(c);
        }
        System.out.println("hahahahah");
    }

    public void getDealNextCSRateList() {

        DealCsRate dcr = new DealCsRate();
        //dcr.setDealId();

        Pagination p = new Pagination();
        p.setStartIndex(100);
        p.setCountEachPage(11);
        for(DealCsRate d : reportDAO.getDealCSRateList(dcr, p)) {
            System.out.println(d);
        }
    }

    public void haha2() {
        System.out.println(olapDAO.getSaleReportCount(-1, -1, null, null, null));
    }

    /**
     * startDate=20141221 &
     * endDate=20141221 &
     * radioTime=0 &
     * parentName= &
     * export=false &
     * saleName= &
     * local=1 &
     * localHidden=1 &
     * mulCity=1 &
     * mulCityHidden=1 &
     *
     * page.pageNum=0 &
     * page.orderBy=total_money_string &
     * page.ascDesc=desc &
     * page.countEachPage=20
     */
    public void haha3() {
        Pagination p = new Pagination();
        p.setPageNum(0);
        //p.setOrderBy("total_money_string");
        p.setAscDesc("desc");
        p.setCountEachPage(20);
        List<FactRptDayDealExt> factRptDayDealExts = olapDAO.getSaleReport(
                p,
                -1,
                -1,
                null,
                20141221,
                20141221,
                1,
                null,
                null,
                1,
                1
        );
        for (FactRptDayDealExt f : factRptDayDealExts)
            System.out.println(f);
    }
}
