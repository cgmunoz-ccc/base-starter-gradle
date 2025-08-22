package com.vaadin.starter.skeleton.components;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Breadcrumb extends VerticalLayout {

    private List<Button> breadcrumbButtons = new ArrayList<>();

    public static List<Integer> visitedPages;
    public static Integer currentIndex;

    private static Button previusButton;
    private static Button nextButton;


    public Breadcrumb() {
        HorizontalLayout breadcrumbLayout = createBreadcrumbButtons();
        HorizontalLayout bottomLayout = createBottomNavigation();
        add(breadcrumbLayout, bottomLayout);
        styleBreadcrumb(breadcrumbLayout, bottomLayout);
    }

    private HorizontalLayout createBreadcrumbButtons(){
        HorizontalLayout layout = new HorizontalLayout();
        for(int i = 0; i< BreadcrumbConstants.PAGE_TITLES.size(); i++){
            String buttonLabel = BreadcrumbConstants.PAGE_TITLES.get(i);
            String buttonRoute = BreadcrumbConstants.PAGE_ROUTES.get(i);

            Button button = new Button(buttonLabel);
            button.addClickListener(e -> {
                visitedPages.add(currentIndex);
                currentIndex = BreadcrumbConstants.PAGE_TITLES.indexOf(buttonLabel);
                button.getUI().ifPresent(ui -> ui.navigate(buttonRoute));
            });

            breadcrumbButtons.add(button);
            layout.add(button);
        }
        return layout;
    }

    public HorizontalLayout createBottomNavigation() {
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
                visitedPages.add(currentIndex);
                currentIndex--;
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
            button.getUI().ifPresent(ui -> ui.navigate(
                BreadcrumbConstants.PAGE_ROUTES.get(currentIndex)
            ));
        });
        this.nextButton = button;
    }

    private void styleBreadcrumb(HorizontalLayout breadcrumbLayout, HorizontalLayout bottomLayout){
        breadcrumbLayout.setWidthFull();
        breadcrumbLayout.setDefaultVerticalComponentAlignment(Alignment.CENTER); //Para que se alineen verticalmente en el centro
        setStateOfButtoms(breadcrumbLayout, bottomLayout);
    }

    private void setStateOfButtoms(HorizontalLayout breadcrumbLayout, HorizontalLayout bottomLayout){
        setBreadcrumbButtonsVisibility();
        setBreadcrumbButtonsStyle(breadcrumbLayout);
        handleBottomLayout(bottomLayout);
    }

    private void setBreadcrumbButtonsVisibility(){
        for(int i=0; i<BreadcrumbConstants.NUMBER_OF_PAGES; i++){
            breadcrumbButtons.get(i).removeClassNames("visibleBtn", "hiddenBtn");
            if(i<=currentIndex || visitedPages.contains(i))
                breadcrumbButtons.get(i).addClassName("visibleBtn");
            else
                breadcrumbButtons.get(i).addClassName("hiddenBtn");
        }
    }

    private void setBreadcrumbButtonsStyle(HorizontalLayout breadcrumbLayout){
        for(int i=0; i<BreadcrumbConstants.NUMBER_OF_PAGES; i++){
            breadcrumbLayout.setFlexGrow(1, breadcrumbButtons.get(i));
            if (i!=currentIndex) {
                breadcrumbButtons.get(i).addThemeVariants(ButtonVariant.LUMO_CONTRAST);
            } else {
                breadcrumbButtons.get(i).addThemeVariants(ButtonVariant.LUMO_PRIMARY,
                    ButtonVariant.LUMO_CONTRAST);
            }
        }
    }

    public void handleBottomLayout(HorizontalLayout bottomLayout){
        bottomLayout.setWidthFull();
        bottomLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        if(currentIndex == 0)
            previusButton.setEnabled(false);

        if(currentIndex == BreadcrumbConstants.NUMBER_OF_PAGES-1)
            nextButton.setEnabled(false);
    }
}
