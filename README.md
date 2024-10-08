# Dukes Data

Demo code for my demo of Jakarta Data


Install a database, e.g. PostgreSQL
```
brew install postgresql
```

Set up the database
```
createdb dukes_data

psql dukes_data

create user duke with password 'duke';
grant all privileges on database dukes_data to duke;

```
