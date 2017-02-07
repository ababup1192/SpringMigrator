# Spring Migrator

## Used DB

- Mysql
- default port
- db name is "test", pass is "pass"
- src/main/resources/application.properties

## Testing

```
$ ./gradlew test
```

## Launch App

```
$ ./gradlew buildRun
```

## Migrator Samples

### BookCategory(One To Many)
![book-category](https://raw.githubusercontent.com/ababup1192/SpringMigrator/master/img/book_category.png)

### EquipmentRoom(Many To Many)
![](https://raw.githubusercontent.com/ababup1192/SpringMigrator/master/img/equipment_room.png)
