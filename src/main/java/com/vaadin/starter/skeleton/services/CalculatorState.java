package com.vaadin.starter.skeleton.services;

import java.util.ArrayList;
import java.util.List;

public class CalculatorState {
    private List<Integer> completePages;
    private Integer currentPageIndex;

    public CalculatorState() {
        completePages = new ArrayList<>();
        currentPageIndex = 0;
    }

    public Integer getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(Integer currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public Integer getCompletePagesIndex(Integer index){
        return completePages.get(index);
    }

    public void addComplePage(Integer page){
        completePages.add(page);
    }

    public void updateState(){

    }
}
