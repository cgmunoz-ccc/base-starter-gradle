package com.vaadin.starter.skeleton.views;

import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HasDynamicTitle;

public class CalculatorView extends VerticalLayout implements HasDynamicTitle {

    public CalculatorView() {
        BreadCrumb breadCrumb = BreadCrumb.build();
        add(breadCrumb);

        Paragraph message = new Paragraph("ESTE ES EL SEGUNDO FORMULARIO. " +
            "Aquí se harán preguntas y se dará el valor calculado final");
        add(message);
    }

    @Override
    public String getPageTitle() {
        return "Calculator";
    }
}

