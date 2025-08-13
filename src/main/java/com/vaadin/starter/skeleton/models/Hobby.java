package com.vaadin.starter.skeleton.models;

public class Hobby {

    private static Integer id;
    private static String name;

    public Hobby(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Integer getId() {
        return id;
    }

    public static void setId(Integer id) {
        Hobby.id = id;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Hobby.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
