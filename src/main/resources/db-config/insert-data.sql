insert into COMPANY(ID, NAME, ADDRESS) values (1, 'BT', 'address');
insert into COMPANY(ID, NAME, ADDRESS) values (2, 'FET', 'address2');
insert into COMPANY(ID, NAME, ADDRESS) values (3, 'TWT', 'address2');

insert into ARTICLE_TYPE(ARTICLE_TYPE_ID, DESCRIPTION) values (1, 'blog');
insert into ARTICLE_TYPE(ARTICLE_TYPE_ID, DESCRIPTION) values (2, 'novel');
insert into ARTICLE_TYPE(ARTICLE_TYPE_ID, DESCRIPTION) values (3, 'news');

insert into CATEGORY(CATEGORY_ID, NAME) values (1, 'tibco bw');
insert into CATEGORY(CATEGORY_ID, NAME) values (2, 'hibernate');
insert into CATEGORY(CATEGORY_ID, NAME) values (3, 'spring');

insert into ARTICLE(ARTICLE_ID, TITLE, CONTENT, ARTICLE_TYPE_ID) values (1, 'title1', 'content1', 1);
insert into ARTICLE(ARTICLE_ID, TITLE, CONTENT, ARTICLE_TYPE_ID) values (2, 'title2', 'content2', 2);
insert into ARTICLE(ARTICLE_ID, TITLE, CONTENT, ARTICLE_TYPE_ID) values (3, 'title3', 'content3', 2);
insert into ARTICLE(ARTICLE_ID, TITLE, CONTENT, ARTICLE_TYPE_ID) values (4, 'title4', 'content4', 3);
insert into ARTICLE(ARTICLE_ID, TITLE, CONTENT, ARTICLE_TYPE_ID) values (5, 'title5', 'content5', 3);
insert into ARTICLE(ARTICLE_ID, TITLE, CONTENT, ARTICLE_TYPE_ID) values (6, 'title6', 'content6', 3);

insert into COMMENT(COMMENT_ID, TEXT, ARTICLE_ID) values (1, 'this article suck', 1);
insert into COMMENT(COMMENT_ID, TEXT, ARTICLE_ID) values (2, 'this article suck+1', 1);
insert into COMMENT(COMMENT_ID, TEXT, ARTICLE_ID) values (3, 'this article suck+2', 1);
insert into COMMENT(COMMENT_ID, TEXT, ARTICLE_ID) values (4, 'this article suck+3', 1);
insert into COMMENT(COMMENT_ID, TEXT, ARTICLE_ID) values (5, 'this article nice', 2);
insert into COMMENT(COMMENT_ID, TEXT, ARTICLE_ID) values (6, 'this article nice+1', 2);
insert into COMMENT(COMMENT_ID, TEXT, ARTICLE_ID) values (7, 'this article nice+2', 2);
insert into COMMENT(COMMENT_ID, TEXT, ARTICLE_ID) values (8, 'this article nice+3', 2);

insert into ARTICLE_CATEGORY_RELATION(ARTICLE_ID, CATEGORY_ID) values(1, 1);
insert into ARTICLE_CATEGORY_RELATION(ARTICLE_ID, CATEGORY_ID) values(1, 2);
insert into ARTICLE_CATEGORY_RELATION(ARTICLE_ID, CATEGORY_ID) values(1, 3);
insert into ARTICLE_CATEGORY_RELATION(ARTICLE_ID, CATEGORY_ID) values(2, 1);
insert into ARTICLE_CATEGORY_RELATION(ARTICLE_ID, CATEGORY_ID) values(2, 2);
insert into ARTICLE_CATEGORY_RELATION(ARTICLE_ID, CATEGORY_ID) values(3, 3);






