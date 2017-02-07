package org.ababup1192.room.after;

import org.ababup1192.util.ListUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Room implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "room_id")
    private Integer roomId;

    @Column(unique = true, length = 30, nullable = false)
    private String roomName;

    @Column(length = 3)
    private Integer capacity = -1;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "quota",
            joinColumns = {@JoinColumn(name = "room_id", referencedColumnName = "room_id")},
            inverseJoinColumns = {@JoinColumn(name = "equipment_id", referencedColumnName = "equipment_id")}
    )
    private List<Equipment> equipments;

    // Implicitly used in JPA
    public Room() {
    }

    public Room(String roomName, Integer capacity, List<Equipment> equipments) {
        this.roomName = roomName;
        this.capacity = capacity;
        this.equipments = equipments;
    }

    public Room(Integer roomId, String roomName, Integer capacity, List<Equipment> equipments) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.capacity = capacity;
        this.equipments = equipments;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (roomName != null ? !roomName.equals(room.roomName) : room.roomName != null) return false;
        if (capacity != null ? !capacity.equals(room.capacity) : room.capacity != null) return false;
        return equipments != null ? ListUtil.any(equipments, room.equipments, Equipment::equals) : room.equipments == null;
    }

    @Override
    public int hashCode() {
        int result = roomId != null ? roomId.hashCode() : 0;
        result = 31 * result + (roomName != null ? roomName.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (equipments != null ? equipments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", capacity=" + capacity +
                ", equipments=" + equipments +
                '}';
    }
}
