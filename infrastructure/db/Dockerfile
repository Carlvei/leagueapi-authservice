# cat Dockerfile
FROM mysql:latest

RUN chown -R mysql:root /var/lib/mysql/

ENV MYSQL_DATABASE=authservice
ENV MYSQL_USER=admin
ENV MYSQL_PASSWORD=password
ENV MYSQL_ROOT_PASSWORD=root_password

EXPOSE 3306
