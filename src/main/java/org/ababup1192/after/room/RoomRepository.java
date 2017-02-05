package org.ababup1192.after.room;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface RoomRepository extends PagingAndSortingRepository<Room, Integer> {
    Iterable<Room> findByRoomName(String equipmentName);

    @Query(value = "TRUNCATE TABLE room;", nativeQuery = true)
    @Modifying
    @Transactional
    void truncateTable();
}

