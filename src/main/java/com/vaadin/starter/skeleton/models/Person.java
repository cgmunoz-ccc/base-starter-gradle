package com.vaadin.starter.skeleton.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Person {

    private Integer id;
    private String firstName;
    private LocalDate birthday;
    private String email;
    private Set<String> hobbies;

    public Person(){

    }

    public Person(Integer id, String firstName, LocalDate birthday, String email, Set<String> hobbies){
        //cómo se hacen en realidad los id de las tablas?
        this.id = id;
        this.firstName = firstName;
        this.birthday = birthday;
        this.email = email;
        this.hobbies = new HashSet<>(hobbies);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<String> hobbies) {
        this.hobbies = new HashSet<>(hobbies);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(id, person.id) && Objects.equals(firstName,
            person.firstName) && Objects.equals(birthday, person.birthday) && Objects.equals(email,
            person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, birthday, email);
    }
}
