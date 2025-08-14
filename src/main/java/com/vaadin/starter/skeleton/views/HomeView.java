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

        PersonService personService = new PersonService();
        DataBinding dataBinding = new DataBinding(personService);

        MainGrid mainGrid = new MainGrid(dataBinding);
        MainFormLayout mainForm = new MainFormLayout(dataBinding, () -> mainGrid.getGrid().getGenericDataView().refreshAll());

        add(mainForm.getForm(), mainGrid.getGrid());
    }
}
