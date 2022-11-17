package ru.rsreu.alexanastasyev.java_labs.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Getter
@Setter
public class Course {

    private final String title;

    private final Language language;

}
