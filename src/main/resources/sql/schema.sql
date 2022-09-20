CREATE TABLE languages
(
    id   serial primary key,
    name varchar(50)
);

CREATE TABLE courses
(
    id          serial primary key,
    language_id integer references languages (id),
    title       varchar(200)
);

CREATE TABLE orders
(
    id                     serial primary key,
    course_id              integer references courses (id),
    username               varchar(200),
    credit_card_number     varchar(50),
    credit_card_expiration varchar(10),
    credit_card_cvv        varchar(3)
);