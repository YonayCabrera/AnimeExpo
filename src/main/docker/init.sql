CREATE TABLE anime
(
  ID       SERIAL PRIMARY KEY NOT NULL,
  posterImage     TEXT               NULL,
  title  TEXT               NULL,
  description TEXT               NULL,
  year    TEXT               NULL,
  rating TEXT               NULL,
  video TEXT               NULL
);