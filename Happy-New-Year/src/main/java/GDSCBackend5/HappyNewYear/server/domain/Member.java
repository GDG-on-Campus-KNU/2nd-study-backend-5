package GDSCBackend5.HappyNewYear.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String userId;

    private String password;

    private String name;

    private String token;

    public void signup(String userId, String password, String name) {
        this.userId = userId;
        this.password = password;
        this.name = name;
        this.token = UUID.randomUUID().toString();
    }
}
