INSERT INTO survey (id, date_created) VALUES (1, CURRENT_DATE());
INSERT INTO survey (id, date_created) VALUES (2, CURRENT_DATE());

INSERT INTO question_catalogue (id,text) VALUES (1,'¿La comida te llegó en buen estado?');
INSERT INTO question_catalogue (id,text) VALUES (2,'¿Recibiste el pedido completo?');
INSERT INTO question_catalogue (id,text) VALUES (3,'¿Cómo calificas nuestro tiempo de entrega?');
INSERT INTO question_catalogue (id,text) VALUES (4,'Califica la actitud de nuestro repartidor');
INSERT INTO question_catalogue (id,text) VALUES (5,'Califica al restaurante');
INSERT INTO question_catalogue (id,text) VALUES (6,'¿Cuéntanos por qué nos escogiste?');
INSERT INTO question_catalogue (id,text) VALUES (7,'¿Qué consideras que debemos mejorar?');

INSERT INTO answer_catalogue (id,text) VALUES (1,'Si');
INSERT INTO answer_catalogue (id,text) VALUES (2,'No');
INSERT INTO answer_catalogue (id,text) VALUES (3,'Si, pero no tuvieron en cuenta mis recomendaciones');
INSERT INTO answer_catalogue (id,text) VALUES (4,'Muy rápido');
INSERT INTO answer_catalogue (id,text) VALUES (5,'Dentro de lo esperado');
INSERT INTO answer_catalogue (id,text) VALUES (6,'Un poco demorado');
INSERT INTO answer_catalogue (id,text) VALUES (7,'Pésimo');
INSERT INTO answer_catalogue (id,text) VALUES (8,'1');
INSERT INTO answer_catalogue (id,text) VALUES (9,'2');
INSERT INTO answer_catalogue (id,text) VALUES (10,'3');
INSERT INTO answer_catalogue (id,text) VALUES (11,'4');
INSERT INTO answer_catalogue (id,text) VALUES (12,'5');

INSERT INTO SURVEY_QUESTION (survey_id,question_id,order_position) VALUES (1,1,1);
INSERT INTO SURVEY_QUESTION (survey_id,question_id,order_position) VALUES (1,2,2);
INSERT INTO SURVEY_QUESTION (survey_id,question_id,order_position) VALUES (1,3,3);
INSERT INTO SURVEY_QUESTION (survey_id,question_id,order_position) VALUES (1,4,4);
INSERT INTO SURVEY_QUESTION (survey_id,question_id,order_position) VALUES (1,5,5);
INSERT INTO SURVEY_QUESTION (survey_id,question_id,order_position) VALUES (1,6,6);
INSERT INTO SURVEY_QUESTION (survey_id,question_id,order_position) VALUES (1,7,7);
INSERT INTO SURVEY_QUESTION (survey_id,question_id,order_position) VALUES (2,5,1);
INSERT INTO SURVEY_QUESTION (survey_id,question_id,order_position) VALUES (2,6,2);
INSERT INTO SURVEY_QUESTION (survey_id,question_id,order_position) VALUES (2,7,3);

INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (1,1,1);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (1,2,2);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (2,1,1);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (2,2,2);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (2,3,3);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (3,4,1);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (3,5,2);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (3,6,3);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (3,7,4);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (4,8,1);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (4,9,2);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (4,10,3);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (4,11,4);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (4,12,5);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (5,8,1);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (5,9,2);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (5,10,3);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (5,11,4);
INSERT INTO QUESTION_ANSWER (question_id,answer_id,order_position) VALUES (5,12,5);


