package org.ababup1192.room.after;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoomRepository extends PagingAndSortingRepository<Room, Integer> {
    // Delete code on production
    @Query(value = "TRUNCATE TABLE room;", nativeQuery = true)
    @Modifying
    @Transactional
    void truncateTable();

    // Delete code on production
    @Query(value = "DROP TABLE room;", nativeQuery = true)
    @Modifying
    @Transactional
    void drop();

    List<Room> findAllByOrderByRoomNameAsc();
}

