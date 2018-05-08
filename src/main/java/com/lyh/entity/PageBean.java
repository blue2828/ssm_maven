package com.lyh.entity;

public class PageBean {
    private int page;
    private int limit;

    public PageBean() {
    }

    public PageBean(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
    public int getStart(){
        return (this.page-1)*this.limit;
    }
}
