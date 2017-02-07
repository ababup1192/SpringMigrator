package org.ababup1192.after;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Equipment implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "equipment_id")
    private Integer equipmentId;

    @Column(unique = true, length = 40, nullable = false)
    private String equipmentName;

    // map room.equipments
    @ManyToMany(mappedBy = "equipments")
    private List<Room> rooms;

    // Implicitly used in JPA
    public Equipment() {
    }

    public Equipment(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Equipment(Integer equipmentId, String equipmentName) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
    }

    public Equipment(Integer equipmentId, String equipmentName, List<Room> room) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.rooms = room;
    }

    // Implicitly used in JPA
    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipment equipment = (Equipment) o;

        return equipmentName != null ? equipmentName.equals(equipment.equipmentName) : equipment.equipmentName == null;
    }

    @Override
    public int hashCode() {
        int result = equipmentId != null ? equipmentId.hashCode() : 0;
        result = 31 * result + (equipmentName != null ? equipmentName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "equipmentId=" + equipmentId +
                ", equipmentName='" + equipmentName + '\'' +
                '}';
    }
}
