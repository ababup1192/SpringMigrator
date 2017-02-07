package org.ababup1192.after;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface EquipmentRepository extends PagingAndSortingRepository<Equipment, Integer> {
    // Delete code on production
    @Query(value = "TRUNCATE TABLE equipment", nativeQuery = true)
    @Modifying
    @Transactional
    void truncate();

    // Delete code on production
    @Query(value = "DROP TABLE equipment", nativeQuery = true)
    @Modifying
    @Transactional
    void drop();

    List<Equipment> findByEquipmentName(String equipmentName);
}
