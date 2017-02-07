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

### Member(Single)
![member](https://raw.githubusercontent.com/ababup1192/SpringMigrator/master/img/member.png)

### BookCategory(One To Many)
![book-category](https://raw.githubusercontent.com/ababup1192/SpringMigrator/master/img/book_category.png)

### EquipmentRoom(Many To Many)
![equipment-room](https://raw.githubusercontent.com/ababup1192/SpringMigrator/master/img/equipment_room.png)
