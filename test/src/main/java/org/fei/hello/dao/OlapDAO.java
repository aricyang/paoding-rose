package org.fei.hello.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;
import org.fei.hello.model.FactRptDayDealExt;
import org.fei.hello.model.Pagination;

import java.util.List;

@DAO(catalog = "nuomi_niux_olap_read")
public interface OlapDAO {


    @SQL(" SELECT count(1) " +
            " FROM ("
            +   " SELECT sale_name,sale_id "
            +   " FROM dw_v_saler stat   "
            +   " WHERE 1=1 "
            +       " #if(:userList!=null){ AND stat.sale_id in (:userList) } "
            +       " #if(:saleName){ AND stat.sale_name=:saleName }  "
            +       " #if(:parentId!=-1){ AND stat.parent_id=:parentId } "
            +       " #if(:cityList != null){ AND stat.area_id in (:cityList) } "
            +       " #if(:areaId!=-1){ AND stat.area_id=:areaId } "
            +   " GROUP BY stat.sale_id,stat.sale_name "
            +" ) u ")
    // TODO： 总数应该从新表中取
    public Long getSaleReportCount(@SQLParam("parentId") long parentId,
                                   @SQLParam("areaId") long areaId,
                                   @SQLParam("saleName") String saleName,
                                   @SQLParam("cityList") List<Long> cityList,
                                   @SQLParam("userList") List<Long> userList);



    @SQL("  SELECT  main.sale_id sale_id,main.sale_name sale_name, " +
            "IFNULL(m.sale_deal_count,0) sale_deal_count, " +
            "IFNULL(n.order_count,0) as order_count," +
            "IFNULL(n.buy_count,0) as buy_count," +
            "IFNULL(n.total_money_string,0) DIV 1000 as total_money_string," +
            "IFNULL(n.gross_profit_string,0) DIV 1000 as gross_profit_string," +
            "IFNULL(n.gross_profit_adjust,0) DIV 1000 as gross_profit_adjust_string, " +
            "IFNULL(n.gross_profit_perf,0) DIV 1000 as gross_profit_perf," +
            "IFNULL(n.total_money_perf,0) DIV 1000 as total_money_perf," +
            "IFNULL(n.refund_money,0) DIV 1000 as refund_money, " +
            "IFNULL(g.online_deal_count,0) as online_deal_count," +
            "IFNULL(g.online_custom_count,0) as online_custom_count," +
            "IFNULL(n.ad_rate,0) div 1000 as ad_rate,ifnull(m.is_all_new,0) AS isAllNew, " +
            "IFNULL(m.canyin_sale_deal_count,0) as canyin_sale_deal_count, " +
            "IFNULL(g.canyin_online_deal_count,0) as canyin_online_deal_count, " +
            "IFNULL(m.canyin_is_all_new,0) as canyin_is_all_new, " +
            "IFNULL(f.firm_count,0) firm_count," +
            "IFNULL(f.canyin_firm_count,0) canyin_firm_count, " +
            "IFNULL(f.movie_firm_count,0) movie_firm_count, " +
            "IFNULL(f.ktv_firm_count,0) ktv_firm_count, " +
            "IFNULL(f.firm_count_only,0) firm_count_only, " +
            "IFNULL(f.canyin_firm_count_only,0) canyin_firm_count_only, " +
            "IFNULL(f.movie_firm_count_only,0) movie_firm_count_only, " +
            "IFNULL(f.ktv_firm_count_only,0) ktv_firm_count_only " +
            "FROM ( " +
            "SELECT sale_id, sale_name " +
            "FROM dw_v_saler " +
            "WHERE 1=1 " +
            "#if(:userList!=null){ AND sale_id in (:userList) } " +
            "#if(:parentId!=-1){ AND parent_id=:parentId} " +
            "#if(:cityList != null){ AND area_id in (:cityList)} " +
            "#if(:areaId!=-1){ AND area_id=:areaId} " +
            "#if(:saleName){ AND sale_name=:saleName}" +
            ") main " +
            "LEFT JOIN (" +
            "SELECT stat.sale_id, " +
            "IFNULL(SUM(deal.order_count), 0) order_count, " +
            "IFNULL(SUM(deal.buy_count),0) buy_count, " +
            "IFNULL(SUM(deal.total_money),0) total_money_string, " +
            "IFNULL(SUM(deal.gross_profit),0) gross_profit_string, " +
            "IFNULL(SUM(deal.gross_profit_adjust),0) gross_profit_adjust, " +
            "IFNULL(SUM(deal.total_money - deal.refund_money - deal.refund_fare_fee),0) total_money_perf, " +
            "IFNULL(sum(deal.gross_profit_adjust - deal.refund_gross_profit),0) gross_profit_perf, " +
            "IFNULL(sum(deal.refund_money + deal.refund_fare_fee),0) refund_money, " +
            "IFNULL(sum(deal.ad_rate),0) ad_rate " +
            "FROM rpt_day_deal deal " +
            "LEFT JOIN time_by_day tbd ON deal.time_id = tbd.time_id " +
            "LEFT JOIN rpt_stat_all_deal stat ON stat.deal_id = deal.deal_id " +
            "LEFT JOIN view_acl_entity area ON deal.area_id = area.area_id " +
            "WHERE 1=1 " +
            "#if(:userList!=null){ AND stat.sale_id in (:userList) } "  +
            "AND stat.sale_id is not null " +
            "#if(:saleName){ AND stat.sale_name=:saleName} " +
            "#if(:local==1){ AND stat.is_local=1 } " +
            "#if(:flag == 0){ " +
            "#if(:mulCity == 0){ " +
            "#if(:parentId!=-1){ AND area.parent_id=:parentId AND stat.parent_id=:parentId} "  +
            "#if(:cityList != null){ AND deal.area_id in (:cityList) AND stat.area_id in (:cityList) } " +
            "#if(:areaId!=-1){ AND deal.area_id=:areaId AND stat.area_id=:areaId } " +
            "} " +
            "#if(:mulCity == 1){ " +
            "#if(:parentId!=-1){ and stat.parent_id=:parentId} " +
            "#if(:cityList != null){ and stat.area_id in (:cityList) } " +
            "#if(:areaId!=-1){ and stat.area_id=:areaId} " +
            "} " +
            "} " +
            "#if(:flag == 1){ " +
            "#if(:parentId!=-1){ AND stat.parent_id=:parentId } " +
            "#if(:cityList != null){ AND stat.area_id in (:cityList) } " +
            "#if(:areaId!=-1){ AND stat.area_id=:areaId} " +
            "}  " +
            "#if(:start != 0){ and tbd.day_of_month >=:start } " +
            "#if(:end != 0){ and tbd.day_of_month <=:end } " +
            "GROUP BY stat.sale_id " +
            ") n  on main.sale_id =n.sale_id " +
            "LEFT JOIN ( " +
            "SELECT sale_id, " +
            "COUNT(DISTINCT rsad.deal_id) sale_deal_count, " +
            "SUM(rsad.is_all_new) AS is_all_new, " +
            "SUM(rsad.is_canyin) canyin_sale_deal_count, " +
            "SUM( CASE WHEN is_all_new = 1 THEN rsad.is_canyin ELSE 0 END) AS canyin_is_all_new " +
            "FROM rpt_stat_all_deal rsad " +
            "LEFT JOIN time_by_day tbd on rsad.pst_time_id = tbd.time_id " +
            "WHERE 1=1 " +
            "AND status =1 " +
            "#if(:userList!=null){ and sale_id in (:userList) } " +
            "#if(:parentId!=-1){ and parent_id=:parentId } " +
            "#if( :cityList != null){ and area_id in (:cityList)} " +
            "#if(:areaId!=-1){ and area_id=:areaId } " +
            "#if(:local==1){ and is_local=1 } " +
            "AND sale_id is not null " +
            "AND sale_name is not null " +
            "#if(:saleName) { AND sale_name=:saleName } " +
            "#if(:start != 0){ AND tbd.day_of_month >=:start } " +
            "#if(:end != 0){ AND tbd.day_of_month <=:end } " +
            "GROUP BY sale_id " +
            ") m on m.sale_id =main.sale_id " +
            "LEFT JOIN ( " +
            "SELECT sale_id, " +
            "COUNT(DISTINCT rsad.deal_id) online_deal_count, " +
            "COUNT(DISTINCT rsad.custom_id) online_custom_count, " +
            "SUM(rsad.is_canyin) canyin_online_deal_count " +
            "FROM rpt_stat_all_deal rsad " +
            "LEFT JOIN time_by_day tbd1 on rsad.pst_time_id = tbd1.time_id " +
            "LEFT JOIN time_by_day tbd2 on rsad.pet_time_id = tbd2.time_id " +
            "WHERE 1=1 " +
            "AND status =1 " +
            "#if(:userList!=null){ AND sale_id in (:userList) } " +
            "#if(:parentId!=-1){ AND parent_id=:parentId} " +
            "#if(:cityList != null){ AND area_id in (:cityList)} " +
            "#if(:areaId!=-1){ AND area_id=:areaId} " +
            "#if(:local==1){ AND is_local=1 } " +
            "AND sale_id is not null " +
            "AND sale_name is not null " +
            "#if(:saleName) { AND sale_name=:saleName } " +
            "#if(:start != 0){ AND tbd2.day_of_month >=:start }" +
            "#if(:end != 0){ AND tbd1.day_of_month <=:end } " +
            "GROUP BY sale_id " +
            ") g on g.sale_id =main.sale_id " +
            "LEFT JOIN ( " +
            "SELECT t.`sale_id`, COUNT(1) AS firm_count, "  +
            "SUM(t.`is_canyin`) AS canyin_firm_count, " +
            "SUM(t.is_movie) AS movie_firm_count, " +
            "SUM(t.`is_ktv`) AS ktv_firm_count, " +
            "SUM(IF(t.is_not_only=0, 1, 0)) AS firm_count_only, " +
            "SUM(IF(t.is_not_only=0, t.`is_canyin`, 0)) AS canyin_firm_count_only,"  +
            "SUM(IF(t.is_not_only=0, t.is_movie, 0)) AS movie_firm_count_only," +
            "SUM(IF(t.is_not_only=0, t.`is_ktv`, 0)) AS ktv_firm_count_only " +
            "FROM ( " +
            "SELECT rsad.`sale_id`, t.firm_id, " +
            "SUM(DISTINCT t.`is_canyin`) AS is_canyin, " +
            "SUM(DISTINCT t.is_movie) AS is_movie," +
            "SUM(DISTINCT t.`is_ktv`) AS is_ktv, " +
            "SUM(DISTINCT t.`is_not_only`) AS is_not_only  " +
            "FROM rpt_day_online_firm t " +
            "LEFT JOIN rpt_stat_all_deal rsad on t.deal_id=rsad.deal_id " +
            "LEFT JOIN time_by_day tbd on t.time_id = tbd.time_id " +
            "WHERE " + "t.`site_id`=0 " +
            "#if(:local==1){ and rsad.is_local=1 } " +
            "#if(:start != 0){ and tbd.day_of_month >=:start } " +
            "#if(:end != 0){ and tbd.day_of_month <=:end } " +
            "GROUP BY rsad.`sale_id`,t.`firm_id` " +
            ") t " +
            "GROUP BY t.sale_id " +
            ") f on main.sale_id = f.sale_id " +
            "#if(:page.orderBy){ ORDER BY ##(:page.orderBy) ##(:page.ascDesc) }  " +
            "LIMIT :page.startIndex , :page.countEachPage "
    )
    public List<FactRptDayDealExt> getSaleReport(
            @SQLParam("page") Pagination page,
            @SQLParam("parentId") long parentId,
            @SQLParam("areaId") long areaId,
            @SQLParam("saleName") String saleName,
            @SQLParam("start") int start,
            @SQLParam("end") int end,
            @SQLParam("local") int local,
            @SQLParam("cityList") List<Long> cityList,
            @SQLParam("userList") List<Long> userList,
            @SQLParam("flag") int flag,
            @SQLParam("mulCity") int mulCity);


}
