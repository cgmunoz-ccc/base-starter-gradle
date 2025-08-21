package com.vaadin.starter.skeleton.views.calculatorViews;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HasDynamicTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.starter.skeleton.AppNavigation;
import com.vaadin.starter.skeleton.components.Breadcrumb;
import com.vaadin.starter.skeleton.components.BreadcrumbConstants;

@Route(value = "calculator/start", layout = AppNavigation.class)
public class CalculatorView extends VerticalLayout implements HasDynamicTitle {

    public CalculatorView() {
        Breadcrumb breadcrumb = new Breadcrumb();
        add(breadcrumb);

        Paragraph message = new Paragraph("ESTE ES EL SEGUNDO FORMULARIO. " +
            "Aquí se harán preguntas y se dará el valor calculado final" +
            breadcrumb.currentIndex + "/npags: " + breadcrumb.visitedPages);
        add(message);
    }

    @Override
    public String getPageTitle() {
        return BreadcrumbConstants.PAGE_TITLE_1;
    }
}

