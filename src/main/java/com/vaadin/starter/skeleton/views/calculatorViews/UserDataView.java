package com.vaadin.starter.skeleton.views.calculatorViews;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.starter.skeleton.AppNavigation;
import com.vaadin.starter.skeleton.components.BottomNavigation;
import com.vaadin.starter.skeleton.components.Breadcrumb;
import com.vaadin.starter.skeleton.components.BreadcrumbConstants;

@Route(value = "calculator", layout = AppNavigation.class)
public class UserDataView extends VerticalLayout implements HasDynamicTitle {

    public UserDataView(){
        Breadcrumb breadcrumb = Breadcrumb.build();
        add(breadcrumb);

        Paragraph message = new Paragraph("Para poder usar la calculadora, introduce aquí tus datos.");
        add(message);

        BottomNavigation bottomNavigation = BottomNavigation.build();
        add(bottomNavigation);
    }

    @Override
    public String getPageTitle() {
        return BreadcrumbConstants.PAGE_TITLE_0;
    }
}