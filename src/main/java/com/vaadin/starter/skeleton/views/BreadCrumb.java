package com.vaadin.starter.skeleton.views;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class BreadCrumb extends HorizontalLayout {

    List<Button> breadCrumbButtons = new ArrayList<>();

    private BreadCrumb() {
        addBreadcrumbButtons();
        styleBreadCrumb();
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

        breadCrumbButtons.add(buttonUserDataView);
        breadCrumbButtons.add(buttonCalculatorView);
        breadCrumbButtons.add(buttonSummaryView);

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

    private void styleBreadCrumb(){
        this.setWidthFull();
        this.setDefaultVerticalComponentAlignment(Alignment.CENTER); //Para que se alineen verticalmente en el centro
        breadCrumbButtons.stream().forEach(button -> {
            button.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
            this.setFlexGrow(1, button);
            });
    }
}
