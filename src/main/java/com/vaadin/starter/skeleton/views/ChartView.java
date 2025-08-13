package com.vaadin.starter.skeleton.views;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.starter.skeleton.AppNavigation;

@Route(value = "chart", layout = AppNavigation.class)
public class ChartView extends VerticalLayout {

    private Paragraph message;

    public ChartView(){
        message = new Paragraph("La página está en construcción");
        add(message);
    }


}
