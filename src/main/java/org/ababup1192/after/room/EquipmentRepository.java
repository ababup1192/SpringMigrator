package org.ababup1192.after.room;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface EquipmentRepository extends PagingAndSortingRepository<Equipment, Integer> {
    @Query(value = "TRUNCATE TABLE equipment", nativeQuery = true)
    @Modifying
    @Transactional
    void truncateTable();
}
