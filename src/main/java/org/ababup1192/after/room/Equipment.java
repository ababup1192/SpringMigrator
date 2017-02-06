package org.ababup1192.after.room;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Equipment implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "equipment_id")
    private Integer equipmentId;

    @Column(unique = true)
    private String equipmentName;

    @ManyToMany(mappedBy = "equipments")
    private List<Room> rooms;

    public Equipment() {
    }

    public Equipment(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Equipment(String equipmentName, List<Room> room) {
        this.equipmentName = equipmentName;
        this.rooms = room;
    }

    public Equipment(Integer equipmentId, String equipmentName) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipment equipment = (Equipment) o;

        if (equipmentId != null ? !equipmentId.equals(equipment.equipmentId) : equipment.equipmentId != null)
            return false;
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
        return "Equipment{" +
                "equipmentId=" + equipmentId +
                ", equipmentName='" + equipmentName + '\'' +
                '}';
    }
}
