package com.vaadin.starter.skeleton.services;

import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.starter.skeleton.components.BreadcrumbConstants;

import java.util.ArrayList;
import java.util.List;

public class CalculatorState {
    private List<Integer> visitedPages;
    private Integer currentIndex;

    public CalculatorState() {
        visitedPages = new ArrayList<>();
        currentIndex = 0;
    }

    public Integer getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(Integer currentIndex) {
        this.currentIndex = currentIndex;
    }

    public void plusOneCurrentIndex() {
        this.currentIndex ++;
    }

    public void minusOneCurrentIndex() {
        this.currentIndex --;
    }

    public Integer getCompletePagesIndex(Integer index){
        return visitedPages.get(index);
    }

    public void addCurrentIndex(){
        visitedPages.add(currentIndex);
    }
}


