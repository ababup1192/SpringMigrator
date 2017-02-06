package org.ababup1192.query.room;

import org.ababup1192.after.room.*;
import org.ababup1192.before.room.EquipmentRoom;
import org.ababup1192.before.room.EquipmentRoomRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class EquipmentRoomMigrateServiceImpl implements EquipmentRoomMigrateService {
    private final EquipmentRoomRepository equipmentRoomRepository;
    private final RoomRepository roomRepository;
    private final EquipmentRepository equipmentRepository;
    private final RoomService roomService;

    @Inject
    public EquipmentRoomMigrateServiceImpl(
            EquipmentRoomRepository equipmentRoomRepository,
            RoomRepository roomRepository,
            EquipmentRepository equipmentRepository,
            RoomService roomService) {
        this.equipmentRoomRepository = equipmentRoomRepository;
        this.roomRepository = roomRepository;
        this.equipmentRepository = equipmentRepository;
        this.roomService = roomService;
    }

    @Override
    public void migrate() {
        roomService.truncateRoom();

        equipmentRoomRepository.findAll().stream().collect(
                Collectors.groupingBy(EquipmentRoom::getRoomName)
        ).forEach((roomName, equipmentRooms) -> {
            int capacity = equipmentRooms.get(0).getCapacity();

            List<Equipment> equipments = equipmentRooms.stream()
                    .map(equipmentRoom -> new Equipment(equipmentRoom.getEquipmentName())) // this.createEquipment(equipmentRoom.getEquipmentName()))
                    .collect(Collectors.toList());

            /*
            equipmentRepository.save(equipments);
            roomRepository.save(new Room(roomName, capacity, equipments));
            */
            // equipmentRepository.save(equipments);
            roomRepository.save(new Room(roomName, capacity, equipments));

            // equipments.forEach(equipment -> equipment.setRoomFk(Arrays.asList(room)));
            // equipmentRepository.save(equipments);
            System.out.println(roomRepository.findAll());

        });
    }

    // もし、すでに存在するEquipmentなら、それを返す。
    private Equipment createEquipment(String equipmentName) {
        Equipment equipment = equipmentRepository.findByEquipmentName(equipmentName).stream().
                findFirst().orElseGet(() -> new Equipment(equipmentName));
        equipment.setRooms(null);
        return equipment;
    }
}
