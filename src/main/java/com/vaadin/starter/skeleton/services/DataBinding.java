package com.vaadin.starter.skeleton.services;

import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.starter.skeleton.components.MainGrid;
import com.vaadin.starter.skeleton.models.Person;

public class DataBinding {

    public Person person;
    private Binder<Person> binder;
    private PersonService personService;

    public DataBinding(PersonService personService) {
        this.binder = new Binder<>(Person.class);
        this.personService = personService;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public Binder<Person> getBinder() {
        return binder;
    }

    public void setBinder(Binder<Person> binder) {
        this.binder = binder;
    }

    public void loadPerson(Person person){
        this.binder.readBean(person);
        this.person = person;
    }

    public void saveNewOrEdit(Runnable afterSaveAction) {
        Integer index = personService.findPerson(person);
        if(index == -1){
            saveNewPerson();
        } else {
            saveEditPerson(index);
        }
    }

    private void saveNewPerson(){
        try {
            this.binder.writeBean(person);
            personService.addPerson(person);
            MainGrid.refreshGrid(personService.getPersonList());
        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveEditPerson(Integer index){
        try {
            this.binder.writeBean(person);
            personService.updatePerson(person, index);
            MainGrid.refreshGrid(personService.getPersonList());
        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Runnable afterSaveAction){
        personService.removePerson(person);
        MainGrid.refreshGrid(personService.getPersonList());
    }

    public void reset(Runnable afterSaveAction){
        //todo
    }
}
