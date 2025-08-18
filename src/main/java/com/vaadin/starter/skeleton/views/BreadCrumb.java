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
        Button buttonUserDataView = new Button("Your Data");
        buttonUserDataView.addClickListener(e ->
                buttonUserDataView.getUI().ifPresent(ui ->
                    ui.navigate("calculator")));
        buttonUserDataView.addClassName("visibleBtn");

        Button buttonCalculatorView = new Button("Calculator");
        buttonCalculatorView.addClassName("visibleBtn");
        buttonCalculatorView.addClickListener(e ->
            buttonCalculatorView.getUI().ifPresent(ui ->
                ui.navigate("calculator/start")));

        Button buttonSummaryView = new Button("Summary");
        buttonSummaryView.addClickListener(e ->
            buttonSummaryView.getUI().ifPresent(ui ->
                ui.navigate("calculator/summary")));
        buttonSummaryView.addClassName("visibleBtn");

        add(buttonUserDataView, buttonCalculatorView, buttonSummaryView);
    }

//    static void goToView(final UI ui,
//                         final Class<? extends View> classView) {
//        ui.getPage().executeJs(SCROLL_UP);
//        ui.navigate(classView);
//    }

//    private Button createBreadcrumbButton(final Class<T> classView, final String buttonLabel){
//        final Button button = new Button(buttonLabel,
//            buttonClickEvent -> UI.getCurrent().getUI()
//                .ifPresent(ui -> NavigationButtonLayout.goToView(ui, classView, Optional.empty())));
//        button.removeClassNames(VISIBLE, HIDDEN);
//        button.addClassName(HIDDEN);
//        return button;
//    }
//    }
}
