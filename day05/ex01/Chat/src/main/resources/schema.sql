create schema if not exists chat;

drop table if exists chat.users, chat.rooms, chat.messages;

create table if not exists chat.users (

    id          serial primary key,
    login       text not null,
    password    text

);

create table if not exists chat.rooms (

    room_id         serial primary key,
    room_name       text not null,
    room_owner      int not null references chat.users(id)
);

create table if not exists chat.messages (
    msg_id          serial primary key,
    msg_author      int not null references chat.users(id),
    msg_room        int not null references chat.rooms(room_id),
    msg_text        text not null,
    msg_date        timestamp
);





