package com.vaadin.starter.skeleton.views.calculatorViews;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.starter.skeleton.AppNavigation;
import com.vaadin.starter.skeleton.components.Breadcrumb;
import com.vaadin.starter.skeleton.components.BreadcrumbConstants;

@Route(value = "calculator/summary", layout = AppNavigation.class)
public class SummaryView extends VerticalLayout implements HasDynamicTitle {

    public SummaryView() {
        Breadcrumb breadcrumb = Breadcrumb.build();
        add(breadcrumb);

        Paragraph message = new Paragraph("ESTA ES LA PÁGINA FINAL DE RESUMEN. " +
            "Aquí se verá un resumen de los datos que se han introducido en las vistas anteriores" + breadcrumb.currentIndex);
        add(message);

        add(breadcrumb.bottomNavigation());
    }

    @Override
    public String getPageTitle() {
        return BreadcrumbConstants.PAGE_TITLE_2;
    }
}