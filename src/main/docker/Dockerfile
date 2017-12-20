FROM postgres

MAINTAINER Yonay Cabrera <yonaycl@gmail.com>

ENV POSTGRES_DB animeexpo
ENV POSTGRES_USER root
ENV POSTGRES_PASSWORD root

COPY init.sql /docker-entrypoint-initdb.d/10-init.sql

WORKDIR /anime-expo

EXPOSE 5432