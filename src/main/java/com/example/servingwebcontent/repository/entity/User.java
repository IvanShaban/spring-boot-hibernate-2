package com.example.servingwebcontent.repository.entity;

import lombok.*;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")

@NamedNativeQueries({
        @NamedNativeQuery(name = "INSERT_INTO_USERS",
                query = "INSERT INTO users (name, sex, email) VALUES (:name, :sex, :email)"),
        @NamedNativeQuery(name = "GET_ALL_USERS", query = "SELECT * FROM users", resultClass = User.class),
        @NamedNativeQuery(name = "GET_USER_BY_ID", query = "SELECT * FROM users WHERE id=:id", resultClass = User.class),
        @NamedNativeQuery(name = "DELETE_FROM_USERS_BY_ID", query = "DELETE FROM users WHERE id=:id")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sex;
    private String email;
}
