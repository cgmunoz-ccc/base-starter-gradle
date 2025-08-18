package com.vaadin.starter.skeleton.views;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

import javax.swing.text.View;

public class BreadCrumb extends HorizontalLayout {

    private List<Button> breadcrumbButtons = new ArrayList<>();

    private BreadCrumb() {
        addBreadcrumbButtons();
    }

    public static BreadCrumb build(){
        return new BreadCrumb();
    }

    private void addBreadcrumbButtons(){
        Button buttonUserDataView = createBreadcrumbButton(
            "Your Data", "calculator");
        Button buttonCalculatorView = createBreadcrumbButton(
            "Calculator", "calculator/start");
        Button buttonSummaryView = createBreadcrumbButton(
            "Summary", "calculator/summary");

        add(buttonUserDataView, buttonCalculatorView, buttonSummaryView);
    }

    private Button createBreadcrumbButton(String buttonLabel, String buttonRoute){
        Button button = new Button(buttonLabel);
        button.addClassName("visibleBtn");

        button.addClickListener(e ->
            button.getUI().ifPresent(ui ->
                ui.navigate(buttonRoute)));
        return button;
    }
}
