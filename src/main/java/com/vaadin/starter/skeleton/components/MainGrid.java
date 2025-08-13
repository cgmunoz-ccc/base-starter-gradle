package com.vaadin.starter.skeleton.components;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.starter.skeleton.models.Person;
import com.vaadin.starter.skeleton.services.DataBinding;
import com.vaadin.starter.skeleton.services.PersonService;

import java.util.List;

public class MainGrid extends HorizontalLayout {

    public static Grid<Person> grid;

    public MainGrid(DataBinding dataBinding){
        grid = new Grid<>(Person.class, false);

        grid.addColumn(Person::getId).setHeader("Id").setSortable(true);
        grid.addColumn(Person::getFirstName).setHeader("First name").setSortable(true);
        grid.addColumn(Person::getBirthday).setHeader("Birthday").setSortable(true);
        grid.addColumn(Person::getEmail).setHeader("Email").setSortable(true);
        grid.addColumn(Person::getHobbies).setHeader("Hobbies").setSortable(true);

        grid.setItems(dataBinding.getPersonService().getPersonList());

        grid.addSelectionListener(
            event -> dataBinding.loadPerson(
                event.getFirstSelectedItem().orElse(null)));
    }

    public Grid<Person> getGrid(){
        return grid;
    }

    public static void refreshGrid(List<Person> personList){
        grid.setItems(personList);
    }
}