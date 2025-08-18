package com.vaadin.starter.skeleton.views;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.starter.skeleton.AppNavigation;

@Route(value = "calculator/summary", layout = AppNavigation.class)
public class SummaryView extends VerticalLayout implements HasDynamicTitle {

    public SummaryView() {
        BreadCrumb breadCrumb = BreadCrumb.build();
        add(breadCrumb);

        Paragraph message = new Paragraph("ESTA ES LA PÁGINA FINAL DE RESUMEN. " +
            "Aquí se verá un resumen de los datos que se han introducido en las vistas anteriores");
        add(message);
    }

    @Override
    public String getPageTitle() {
        return "Summary";
    }
}