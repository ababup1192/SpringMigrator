package org.ababup1192.after.room;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Room implements Serializable {
    @Id
    @GeneratedValue
    private Integer roomId;

    private String roomName;

    private Integer capacity;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Equipment> equipments;

    public Room() {
    }

    public Room(Integer id, String roomName, Integer capacity, List<Equipment> equipments) {
        this.roomId = id;
        this.roomName = roomName;
        this.capacity = capacity;
        this.equipments = equipments;
    }

    public Room(String roomName, Integer capacity, List<Equipment> equipments) {
        this.roomName = roomName;
        this.capacity = capacity;
        this.equipments = equipments;
    }

    public Room(String roomName, Integer capacity) {
        this.roomName = roomName;
        this.capacity = capacity;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (roomId != null ? !roomId.equals(room.roomId) : room.roomId != null) return false;
        if (roomName != null ? !roomName.equals(room.roomName) : room.roomName != null) return false;
        if (capacity != null ? !capacity.equals(room.capacity) : room.capacity != null) return false;
        return equipments != null ? equipments.equals(room.equipments) : room.equipments == null;

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
        return "Room{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                ", capacity=" + capacity +
                ", equipments=" + equipments +
                '}';
    }
}
