package com.vaadin.starter.skeleton.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.starter.skeleton.services.CalculatorState;

import java.util.List;

public class BottomNavigation extends HorizontalLayout {

    private static Button previusBottom;
    private static Button nextButtom;

    private List<Integer> visitedPages;
    private Integer currentIndex;

    public static BottomNavigation build() {
        return new BottomNavigation();
    }

    private BottomNavigation() {
        previusBottom = createPreviusButton();
        nextButtom = createNextButton();
        add(previusBottom, nextButtom);
    }

    private Button createPreviusButton() {
        Button previusButton = new Button("previus",
            new Icon(VaadinIcon.ARROW_LEFT));
        previusButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        previusButton.addClickListener(
            e -> {
                currentIndex--;
                previusButton.getUI().ifPresent(ui -> ui.navigate(
                    BreadcrumbConstants.PAGE_ROUTES.get(currentIndex)
                ));
                handleBottomLayoutButtons();
            }
        );
        return previusButton;
    }

    private Button createNextButton() {
        Button nextButton = new Button("next",
            new Icon(VaadinIcon.ARROW_RIGHT));
        nextButton.setIconAfterText(true);
        nextButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        nextButton.addClickListener(e -> {
            visitedPages.add(currentIndex);
            currentIndex++;
            nextButton.getUI().ifPresent(ui -> ui.navigate(
                BreadcrumbConstants.PAGE_ROUTES.get(currentIndex)
            ));
            handleBottomLayoutButtons();
        });
        return nextButton;
    }

    public void handleBottomLayoutButtons(){
        if(currentIndex == 0)
            previusBottom.setEnabled(false);

        if(currentIndex == BreadcrumbConstants.NUMBER_OF_PAGES)
            nextButtom.setEnabled(false);
    }
}
