package com.example.servingwebcontent.repository.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "devices")

@NamedNativeQueries({
        @NamedNativeQuery(name = "INSERT_INTO_DEVICES",
                query = "INSERT INTO devices (name, type, owner_id) VALUES (:name, :type, :ownerId)"),
        @NamedNativeQuery(name = "GET_ALL_DEVICES", query = "SELECT * FROM devices", resultClass = Device.class),
        @NamedNativeQuery(name = "GET_DEVICE_BY_ID", query = "SELECT * FROM devices WHERE id=:id", resultClass = Device.class),
        @NamedNativeQuery(name = "DELETE_FROM_DEVICES_BY_ID", query = "DELETE FROM devices WHERE id=:id")
})
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;

    @Column(name = "owner_id")
    private Long ownerId;
}



