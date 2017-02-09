package org.ababup1192.room;

import org.ababup1192.room.after.*;
import org.ababup1192.room.before.EquipmentRoom;
import org.ababup1192.room.before.EquipmentRoomRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
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

    @Transactional
    @Override
    public void migrate() {
        roomService.truncateRoom();

        equipmentRoomRepository.findAll().stream().collect(
                Collectors.groupingBy(EquipmentRoom::getRoomName)
        ).forEach((roomName, equipmentRooms) -> {
            int capacity = equipmentRooms.get(0).getCapacity();
            List<Equipment> equipments = equipmentRooms.stream()
                    .map(equipmentRoom -> this.createEquipment(equipmentRoom.getEquipmentName()))
                    .collect(Collectors.toList());

            roomRepository.save(new Room(roomName, capacity, equipments));
        });
    }

    // return Category in DB if it already exists.
    private Equipment createEquipment(String equipmentName) {
        return equipmentRepository.findByEquipmentName(equipmentName).stream().
                findFirst().orElseGet(() -> new Equipment(equipmentName));
    }
}
