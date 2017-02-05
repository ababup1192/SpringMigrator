package org.ababup1192.after.room;

public interface RoomService {
    Iterable<Room> findByEquipmentName(String equipmentName);
    void truncateRoom();
}
