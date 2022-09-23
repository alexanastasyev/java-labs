package ru.rsreu.alexanastasyev.java_labs.model;

import lombok.*;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
@Getter
@Setter
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final int id;

    private final String title;

    @Enumerated(EnumType.STRING)
    private final Language language;

}
