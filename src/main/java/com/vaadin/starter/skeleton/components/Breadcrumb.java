package com.vaadin.starter.skeleton.components;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Breadcrumb extends HorizontalLayout {

    private static List<Button> breadcrumbButtons = new ArrayList<>();

    private List<Integer> visitedPages;
    public Integer currentIndex;

    private static Button previusButton;
    private static Button nextButton;

    public static Breadcrumb build(){
        return new Breadcrumb();
    }

    private Breadcrumb() {
        addBreadcrumbButtons();
        styleBreadcrumb();
    }

    private void addBreadcrumbButtons(){
        currentIndex = 0;
        visitedPages = new ArrayList<>();

        for(int i = 0; i< BreadcrumbConstants.PAGE_TITLES.size(); i++){
            String buttonLabel = BreadcrumbConstants.PAGE_TITLES.get(i);
            String buttonRoute = BreadcrumbConstants.PAGE_ROUTES.get(i);

            Button button = new Button(buttonLabel);
            button.addClickListener(e -> {
                visitedPages.add(currentIndex);
                currentIndex = BreadcrumbConstants.PAGE_TITLES.indexOf(buttonLabel);
                setStateOfButtoms();
                button.getUI().ifPresent(ui -> ui.navigate(buttonRoute));
            });

            breadcrumbButtons.add(button);
            add(button);
        }
    }

    public HorizontalLayout bottomNavigation() {
        HorizontalLayout layout = new HorizontalLayout();
        createNextButton();
        createPreviusButton();

        layout.add(previusButton, nextButton);
        return layout;
    }

    private void createPreviusButton() {
        Button button = new Button("previus",
            new Icon(VaadinIcon.ARROW_LEFT));
        button.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        button.addClickListener(
            e -> {
                currentIndex--;
                setStateOfButtoms();
                button.getUI().ifPresent(ui -> ui.navigate(
                    BreadcrumbConstants.PAGE_ROUTES.get(currentIndex)
                ));
            }
        );
        this.previusButton = button;
    }

    private void createNextButton() {
        Button button = new Button("next",
            new Icon(VaadinIcon.ARROW_RIGHT));
        button.setIconAfterText(true);
        button.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        button.addClickListener(e -> {
            visitedPages.add(currentIndex);
            currentIndex++;
            setStateOfButtoms();
            button.getUI().ifPresent(ui -> ui.navigate(
                BreadcrumbConstants.PAGE_ROUTES.get(currentIndex)
            ));
        });
        this.nextButton = button;
    }

    private void styleBreadcrumb(){
        this.setWidthFull();
        this.setDefaultVerticalComponentAlignment(Alignment.CENTER); //Para que se alineen verticalmente en el centro
        setStateOfButtoms();
    }

    private void setStateOfButtoms(){
        setBreadcrumbButtonsVisibility();
        setBreadcrumbButtonsStyle();
        //handleBottomLayoutButtons();
    }

    private void setBreadcrumbButtonsVisibility(){
        for(Button button:breadcrumbButtons){
            Integer buttonIndex = breadcrumbButtons.indexOf(button);
            breadcrumbButtons.get(buttonIndex).removeClassNames("visibleBtn", "hiddenBtn");
            if(buttonIndex < currentIndex)
                breadcrumbButtons.get(buttonIndex).addClassName("hiddenBtn");
            else
                breadcrumbButtons.get(buttonIndex).addClassName("visibleBtn");
        }
    }

    private void setBreadcrumbButtonsStyle(){
        for(Button button:breadcrumbButtons){
            this.setFlexGrow(1, button);
            if (breadcrumbButtons.indexOf(button) != currentIndex) {
                button.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
            }
        }
    }

    public void handleBottomLayoutButtons(){
        if(currentIndex == 0)
            previusButton.setEnabled(false);

        if(currentIndex == BreadcrumbConstants.NUMBER_OF_PAGES)
            nextButton.setEnabled(false);
    }
}
