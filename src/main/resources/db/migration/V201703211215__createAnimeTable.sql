CREATE TABLE public.anime
(
    id SERIAL PRIMARY KEY NOT NULL,
    posterImage TEXT NOT NULL,
    title TEXT NOT NULL,
    year TEXT NOT NULL ,
    rating TEXT NOT NULL,
    video TEXT NOT NULL
);

INSERT INTO public.anime(posterImage, title, year, rating, video)
VALUES ('http://img1.ak.crunchyroll.com/i/spire2/3b86bbf3ad40f36f86df634e138837ca1484112439_full.jpg',
 'Fuuka',
'2017',
 '10',
'');