package org.ababup1192;

import org.ababup1192.room.EquipmentRoomMigrateService;
import org.ababup1192.room.after.Equipment;
import org.ababup1192.room.after.EquipmentRepository;
import org.ababup1192.room.after.RoomRepository;
import org.ababup1192.room.before.EquipmentRoom;
import org.ababup1192.room.before.EquipmentRoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    @Inject
    private EquipmentRoomMigrateService equipmentRoomMigrateService;
    @Inject
    private EquipmentRoomRepository equipmentRoomRepository;
    @Inject
    private EquipmentRepository equipmentRepository;
    @Inject
    private RoomRepository roomRepository;


    private static final List<EquipmentRoom> equipmentRooms = Arrays.asList(
            new EquipmentRoom("sakura", 2, "fork"),
            new EquipmentRoom("sakura", 2, "spoon"),
            new EquipmentRoom("tsubaki", 3, "fork"),
            new EquipmentRoom("katsura", 1, "toothbrush")
    );

    public static void main(String[] args) {
        System.out.println("main()");
        try (ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args)) {
            Application app = ctx.getBean(Application.class);
            app.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(String... args) {
        equipmentRoomRepository.deleteAll();
        equipmentRoomRepository.save(equipmentRooms);

        log.info("Start migration");
        equipmentRoomMigrateService.migrate();
        log.info("End migration");

        log.info("Start Find All");
        equipmentRepository.findAll().forEach(Equipment::getRooms);
        log.info("End Find All");
    }
}
