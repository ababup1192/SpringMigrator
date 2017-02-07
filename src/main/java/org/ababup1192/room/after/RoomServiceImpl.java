package org.ababup1192.room.after;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @PersistenceContext
    private EntityManager entityManager;
    private final RoomRepository roomRepository;
    private final EquipmentRepository equipmentRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository, EquipmentRepository equipmentRepository) {
        this.roomRepository = roomRepository;
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<Room> findByEquipmentName(String equipmentName) {
        final String jpql = "SELECT DISTINCT r FROM Room r INNER JOIN FETCH r.equipments AS e " +
                "WHERE e.equipmentName = :equipmentName";
        TypedQuery<Room> query = entityManager.createQuery(jpql, Room.class);
        query.setParameter("equipmentName", equipmentName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void truncateRoom() {
        entityManager.createNativeQuery("SET foreign_key_checks = 0").executeUpdate();
        entityManager.createNativeQuery("TRUNCATE TABLE quota").executeUpdate();
        equipmentRepository.truncateTable();
        roomRepository.truncateTable();
        entityManager.createNativeQuery("SET foreign_key_checks = 1").executeUpdate();
    }

    @Override
    @Transactional
    public void dropRoom() {
        entityManager.createNativeQuery("DROP TABLE quota").executeUpdate();
        equipmentRepository.drop();
        roomRepository.drop();
    }
}
