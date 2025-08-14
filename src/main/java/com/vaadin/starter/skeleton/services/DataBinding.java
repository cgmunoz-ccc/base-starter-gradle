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
        //MAL
        try {
            person = new Person();
            this.binder.writeBean(person);
            personService.addPerson(person);
            MainGrid.refreshGrid(personService.getPersonList());
        } catch (ValidationException e) {
            throw new RuntimeException(e);
        }
    }

    //Antes: función load, en la que:
    //      1.  this.binder.readBean(person)  -> binder(formulario) = person
    //      2.  this.person = person          -> Se envían los datos a la propiedad de la clase (¿para que si luego se modifica?)
    private void saveEditPerson(Integer index){
        //BIEN
        //3. ENTRA CUANDO SE PULSA EL BOTÓN DE SAVE
        try {
            this.binder.writeBean(person); // 4. person = binder(formulario) -->
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
