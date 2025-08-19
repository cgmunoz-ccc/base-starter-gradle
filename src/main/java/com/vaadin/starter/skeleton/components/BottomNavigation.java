package com.vaadin.starter.skeleton.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.starter.skeleton.services.CalculatorState;

public class BottomNavigation extends HorizontalLayout {

    private static Button previusBottom;
    private static Button nextButtom;

    private CalculatorState state;

    public static BottomNavigation build(CalculatorState state){
        return new BottomNavigation(state);
    }

    private BottomNavigation(CalculatorState state) {
        this.state = state;

        previusBottom = createPreviusButton();
        nextButtom = createNextButton();
        add(previusBottom, nextButtom);
    }

    private Button createPreviusButton(){
        Button previusButton = new Button("previus",
            new Icon(VaadinIcon.ARROW_LEFT));
        previusButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        previusButton.addClickListener(
            e -> {
                currentPageIndex --;
                previusButton.getUI().ifPresent(ui -> ui.navigate(
                    BreadcrumbConstants.PAGE_ROUTES.get(currentPageIndex)
                ));
                updateBreadcrumbButtons();
            }
        );
        previusAndNextButtons.add(previusButton);
        return previusButton;
    }

    private Button createNextButton(){
        Button nextButton = new Button("next",
            new Icon(VaadinIcon.ARROW_RIGHT));
        nextButton.setIconAfterText(true);
        nextButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        nextButton.addClickListener(e -> {
            pagesCompleteIndex.add(currentPageIndex);
            currentPageIndex ++;
            nextButton.getUI().ifPresent(ui -> ui.navigate(
                BreadcrumbConstants.PAGE_ROUTES.get(currentPageIndex)
            ));
            updateBreadcrumbButtons();
        });
        previusAndNextButtons.add(nextButton);
        return nextButton;
    }

    private void handleBottomLayoutButtons(){
//        if(currentPageIndex == 0)
//            previusAndNextButtons.get(0).setEnabled(false);
//
//        if(currentPageIndex == breadcrumbButtons.size()-1)
//            previusAndNextButtons.get(1).setEnabled(false);
    }
}
