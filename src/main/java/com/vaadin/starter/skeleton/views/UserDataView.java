package com.vaadin.starter.skeleton.views;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.starter.skeleton.AppNavigation;

@Route(value = "calculator", layout = AppNavigation.class)
public class UserDataView extends VerticalLayout implements HasDynamicTitle {

    public UserDataView(){
        BreadCrumb breadCrumb = BreadCrumb.build();
        add(breadCrumb);

        Paragraph message = new Paragraph("Para poder usar la calculadora, introduce aquí tus datos.");
        add(message);
    }

    @Override
    public String getPageTitle() {
        return "User Data";
    }
}