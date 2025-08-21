package com.vaadin.starter.skeleton;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.starter.skeleton.views.HomeView;
import com.vaadin.starter.skeleton.views.calculatorViews.UserDataView;

public class AppNavigation extends AppLayout {

    public AppNavigation(){
        H1 title = new H1("MyApp");
        title.getStyle().set("font-size", "var(--lumo-font-size-xl)")
            .set("margin", "var(--lumo-space-l)");
        addToNavbar(title);

        HorizontalLayout navButtons = getSideNav();
        addToNavbar(navButtons);
    }

    private HorizontalLayout getSideNav() {
        HorizontalLayout sideNavButtonsLayout = new HorizontalLayout();
        Button sideNavButton_0 = new Button("Home", new Icon(VaadinIcon.HOME),
            e -> {getUI().ifPresent(
                ui -> ui.navigate(HomeView.class));
        });
        sideNavButton_0.addThemeVariants(ButtonVariant.LUMO_TERTIARY,
            ButtonVariant.LUMO_CONTRAST);

        Button sideNavButton_1 = new Button("Calculator", new Icon(VaadinIcon.CALC),
            e -> {getUI().ifPresent(
                ui -> ui.navigate(UserDataView.class));
        });
        sideNavButton_1.addThemeVariants(ButtonVariant.LUMO_TERTIARY,
            ButtonVariant.LUMO_CONTRAST);

        sideNavButtonsLayout.add(sideNavButton_0, sideNavButton_1);
        styleLayout(sideNavButtonsLayout);
        return sideNavButtonsLayout;
    }

    private void styleLayout(HorizontalLayout layout){
        layout.setWidthFull();
        layout.setJustifyContentMode(JustifyContentMode.END);
        layout.setMargin(true);
    }

}
