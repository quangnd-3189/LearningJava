package com.sun.training_java.sdj.demo.common;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse<T> {
    private List<T> list;
    private int curPage;
    private int curPageSize;
    private long totalItems;
    private int totalPages;
}
