package GDSCBackend5.HappyNewYear.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "POST_ID")
    private Long postid;

    private String sender;

    private String token;

    private String title;

    private String content;

    private Date regdate;


}
