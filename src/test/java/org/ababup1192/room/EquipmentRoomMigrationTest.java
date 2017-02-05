package org.ababup1192.room;

import org.ababup1192.after.room.Equipment;
import org.ababup1192.after.room.Room;
import org.ababup1192.after.room.RoomService;
import org.ababup1192.before.room.EquipmentRoom;
import org.ababup1192.before.room.EquipmentRoomRepository;
import org.ababup1192.query.room.EquipmentRoomMigrateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EquipmentRoomMigrationTest {
    @Autowired
    private EquipmentRoomRepository equipmentRoomRepository;
    @Autowired
    private EquipmentRoomMigrateService equipmentRoomMigrateService;
    @Autowired
    private RoomService roomService;

    private static final List<EquipmentRoom> equipmentRooms = Arrays.asList(
            new EquipmentRoom("sakura", 2, "fork"),
            new EquipmentRoom("sakura", 2, "spoon"),
            new EquipmentRoom("tsubaki", 3, "fork")
    );

    @Before
    public void SetUp() {
        equipmentRoomRepository.truncateTable();
        equipmentRoomRepository.save(equipmentRooms);
    }

    @Test
    public void migrateTest() {
        equipmentRoomMigrateService.migrate();

        Room actual = ((List<Room>)roomService.findByEquipmentName("spoon")).get(0);

        assertThat(actual.getEquipments(), contains(new Equipment(2, "spoon")));
        assertThat(actual.getRoomId(), is(1));
        assertThat(actual.getRoomName(), is("sakura"));
        assertThat(actual.getCapacity(), is(2));
    }

}
