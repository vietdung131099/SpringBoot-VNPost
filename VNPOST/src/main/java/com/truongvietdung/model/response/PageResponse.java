package com.truongvietdung.model.response;


import java.util.List;

public class PageResponse<T> {
    private long totalItem;
    private List<T> data;
    private int page;
    private int size;

    private PageResponse(final long totalItem,final List<T> data,final int page,final int size){
        this.totalItem = totalItem;
        this.data = data;
        this.page = page;
        this.size = size;
    }

    public static <T> PageResponse<T> of(final long totalItem, final List<T> data,final int page,final int size){
        return new PageResponse<>(totalItem, data, page, size);
    }

    public long getTotalItem() {
        return totalItem;
    }

    public List<T> getData() {
        return data;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }
}
