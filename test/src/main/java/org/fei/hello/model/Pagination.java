package org.fei.hello.model;


public class Pagination {

    private String orderBy;

    public static final String ASC = "asc";
    public static final String DESC = "desc";
    private String ascDesc = ASC;

    private int countEachPage = 20;

    private int pageNum = 0;

    private int startIndex = 0;

    private int endIndex = 3;

    private long totalPage;

    private long totalNum;

    private int currentNum;
    private String reqUrl;
    public Pagination(){

    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getAscDesc() {
        return ascDesc;
    }

    public void setAscDesc(String ascDesc) {
        this.ascDesc = ascDesc;
    }

    public int getCountEachPage() {
        return countEachPage;
    }

    public void setCountEachPage(int countEachPage) {
        this.countEachPage = countEachPage;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long long1) {
        if(long1>0)
        {
            totalPage = long1/countEachPage;
            if(long1%countEachPage!=0)totalPage++;

            currentNum = countEachPage;
            if((pageNum+1)==totalPage)
            {
                currentNum = (int) (long1 -pageNum*countEachPage);
            }
        }else{
            totalPage = 1;
            currentNum = 0;
        }

        this.totalNum = long1;
    }

    public void packParam(){
        startIndex = pageNum*countEachPage;
    }

    public int getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(int currentNum) {
        this.currentNum = currentNum;
    }

    public static String getAsc() {
        return ASC;
    }

    public static String getDesc() {
        return DESC;
    }

}
