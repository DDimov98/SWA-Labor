-- Some initial data
INSERT INTO TUSER (id, username, password) 
       VALUES ("1", "Ausername", "Apassword");
INSERT INTO TUSER (id, username, password)
       VALUES ("2", "Busername", "Bpassword");
INSERT INTO TUSER (id, username, password)
       VALUES ("3", "Dimitar", "Dimov");
INSERT INTO TUSER (id, username, password)
       VALUES ("4", "Moha", "Sale");

INSERT INTO Post (id, latitude, longitude, postedat, text, authorId)
       VALUES ("1", "42", "25345", "2022.01.01", "First Post", "1");
INSERT INTO Post (id, latitude, longitude, postedat, text, authorId)
       VALUES ("2", "42042", "6969", "2022.01.01", "Second Post", "2");
INSERT INTO Post (id, latitude, longitude, postedat, text, authorId)
       VALUES ("3", "42", "25345", "2022.01.01", "Third Post", "1");

INSERT INTO Comment (id, latitude, longitude, postedat, text, authorId, postId)
       VALUES ("1", "6969", "245", "2022.01.01", "First Comment", "1", "1");
INSERT INTO Comment (id, latitude, longitude, postedat, text, authorId, postId)
       VALUES ("2", "2545", "69", "2022.01.01", "Second Comment", "2", "1");
INSERT INTO Comment (id, latitude, longitude, postedat, text, authorId, postId)
       VALUES ("3", "2222", "22", "2022.01.01", "Third Comment", "2", "2");


