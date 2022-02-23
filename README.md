Spring security role based

This project is for demostration of spring security

Requirements

1.Eclipse
2.Mysql

create database name sms on mysql workbench

got to src->main->resourecs->application modify depend on your database configuration username and password

spring.datasource.url=jdbc:mysql://localhost:3307/sms
spring.datasource.username=root
spring.datasource.password="your password"


spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver


#Hbibernate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect

spring.jpa.hibernate.ddl-auto=update

logging.level.org.hibernate.SQL=DEBUG
