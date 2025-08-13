package com.vaadin.starter.skeleton.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.starter.skeleton.AppNavigation;
import com.vaadin.starter.skeleton.components.MainFormLayout;
import com.vaadin.starter.skeleton.components.MainGrid;
import com.vaadin.starter.skeleton.services.DataBinding;
import com.vaadin.starter.skeleton.services.PersonService;

/**
 * The main view contains a button and a click listener.
 */
@Route(value = "", layout = AppNavigation.class)
public class HomeView extends VerticalLayout {

    public HomeView() {

        //EL BINDER SE PUEDE CONSIDERAR COMO EL FORMULARIO
        //EL SERVICE SE PUEDE CONSIDERAR COMO EL BACKEND

        PersonService personService = new PersonService();  //crea una lista de personas
        DataBinding dataBinding = new DataBinding(personService);  //crea el binder principal y tiene la lista de personas anterior

        MainGrid mainGrid = new MainGrid(dataBinding);  //crea el Grid, con la lista y el binder (AQUÍ SOLO EL BINDER?)
        MainFormLayout mainForm = new MainFormLayout(dataBinding, () -> mainGrid.getGrid().getGenericDataView().refreshAll()); //crea el FormLayout, haciendo el binding con el Binder anterior

        add(mainForm.getForm(), mainGrid.getGrid());
    }
}
