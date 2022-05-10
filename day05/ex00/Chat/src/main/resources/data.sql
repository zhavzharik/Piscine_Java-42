insert into chat.users (login, password) VALUES ('abridger', '123');
insert into chat.users (login, password) VALUES ('aheidy', '345');
insert into chat.users (login, password) VALUES ('bferny', '123345');
insert into chat.users (login, password) VALUES ('fuserwyn', '123567');
insert into chat.users (login, password) VALUES ('lechalme', '987123');

insert into chat.rooms (room_name, room_owner) VALUES ('chat1', 1);
insert into chat.rooms (room_name, room_owner) VALUES ('chat2', 2);
insert into chat.rooms (room_name, room_owner) VALUES ('chat3', 3);
insert into chat.rooms (room_name, room_owner) VALUES ('chat4', 4);
insert into chat.rooms (room_name, room_owner) VALUES ('chat5', 5);

insert into chat.messages (msg_author, msg_room, msg_text, msg_date) VALUES (1, 2, 'Hello! My name is Svetlana.',current_timestamp);
insert into chat.messages (msg_author, msg_room, msg_text, msg_date) VALUES (2, 3, 'Hello! My name is Alisa.',current_timestamp);
insert into chat.messages (msg_author, msg_room, msg_text, msg_date) VALUES (3, 4, 'Hello! My name is Nataly.',current_timestamp);
insert into chat.messages (msg_author, msg_room, msg_text, msg_date) VALUES (4, 1, 'Hello! My name is Ivano.',current_timestamp);
insert into chat.messages (msg_author, msg_room, msg_text, msg_date) VALUES (5, 5, 'Hello! My name is Slava.',current_timestamp);