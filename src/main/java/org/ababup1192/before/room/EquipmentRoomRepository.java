package org.ababup1192.before.room;

import org.ababup1192.after.room.Room;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EquipmentRoomRepository extends PagingAndSortingRepository<EquipmentRoom, Integer> {
    List<EquipmentRoom> findAll();

    @Query(value = "TRUNCATE TABLE equipment_room", nativeQuery = true)
    @Modifying
    @Transactional
    void truncateTable();
}

