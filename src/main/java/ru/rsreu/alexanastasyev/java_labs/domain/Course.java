package ru.rsreu.alexanastasyev.java_labs.domain;

import lombok.Data;

@Data
public class Course {

    private final String id;
    private final String title;
    private final Language language;

}
