package com.vaadin.starter.skeleton.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HobbyService {

    private List<String> hobbies;

    public static List<String> getHobbies(){
        return List.of("Read", "Video Games", "Surf", "Dance", "Sing", "Sports");
    }
}
