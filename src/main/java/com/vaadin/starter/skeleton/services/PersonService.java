package com.vaadin.starter.skeleton.services;

import com.vaadin.starter.skeleton.models.Person;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.xml.crypto.Data;

@Service
public class PersonService {

    private List<Person> personList;  //sería mejor con un set??

    public PersonService() {
        //como coger esto de la base de datos??
        personList = new ArrayList<>();
        for(int i=0; i<50; i++){
            Person person = new Person(i,
                "FN"+i,
                LocalDate.of(1960+i, 12, 1),
                "email"+i+"@example.com",
                new HashSet<>());
            personList.add(person);
        }
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void addPerson(Person person){
        personList.add(person);
    }

    public void updatePerson(Person person, Integer index){
        personList.remove(index);
        personList.set(index, person);
    }

    public void removePerson(Person person){
        personList.remove(person);
    }

    public Integer findPerson(Person person){
        return personList.indexOf(person);
    }
}
