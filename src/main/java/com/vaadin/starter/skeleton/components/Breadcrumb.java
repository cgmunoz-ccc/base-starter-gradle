package com.vaadin.starter.skeleton.components;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.starter.skeleton.services.CalculatorState;

public class Breadcrumb extends HorizontalLayout {

    private static List<Button> breadcrumbButtons = new ArrayList<>();
    private CalculatorState state;

    public static Breadcrumb build(CalculatorState state){
        return new Breadcrumb(state);
    }

    private Breadcrumb(CalculatorState state) {
        this.state = state;
        addBreadcrumbButtons();
        styleBreadcrumb();
    }

    private void addBreadcrumbButtons(){
        for(int i = 0; i< BreadcrumbConstants.PAGE_TITLES.size(); i++){
            String buttonLabel = BreadcrumbConstants.PAGE_TITLES.get(i);
            String buttonRoute = BreadcrumbConstants.PAGE_ROUTES.get(i);

            Button button = new Button(buttonLabel);
            button.addClickListener(e -> {
                pagesCompleteIndex.add(currentPageIndex);
                currentPageIndex = BreadcrumbConstants.PAGE_TITLES.indexOf(buttonLabel);
                button.getUI().ifPresent(ui -> ui.navigate(buttonRoute));
                updateBreadcrumbButtons();
            });

            breadcrumbButtons.add(button);
            add(button);
        }
    }

    private void styleBreadcrumb(){
        this.setWidthFull();
        this.setDefaultVerticalComponentAlignment(Alignment.CENTER); //Para que se alineen verticalmente en el centro
        updateBreadcrumbButtons();
    }

    private void updateBreadcrumbButtons(){
        setBreadcrumbButtonsVisibility();
        setBreadcrumbButtonsStyle();
    }

    private void setBreadcrumbButtonsVisibility(){
        for(int i=0; i<breadcrumbButtons.size(); i++){
            breadcrumbButtons.get(i).removeClassNames("visibleBtn", "hiddenBtn");
            if(i > currentPageIndex)
                breadcrumbButtons.get(i).addClassName("hiddenBtn");
            else
                breadcrumbButtons.get(i).addClassName("visibleBtn");
        }
    }

    private void setBreadcrumbButtonsStyle(){
        breadcrumbButtons.get(currentPageIndex)
            .addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        breadcrumbButtons.forEach(button ->
            this.setFlexGrow(1, button));
    }

    public HorizontalLayout createBottomLayout(){
        HorizontalLayout layout = new HorizontalLayout();
        layout.add(createPreviusButton(), createNextButton());
        return layout;
    }
}
