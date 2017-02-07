package org.ababup1192;

import org.ababup1192.query.EquipmentRoomMigrateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.inject.Inject;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    @Inject
    private EquipmentRoomMigrateService equipmentRoomMigrateService;

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
        log.info("Start migration");
        equipmentRoomMigrateService.migrate();
        log.info("End migration");
    }
}
