package GDSCBackend5.HappyNewYear.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;


@Entity
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue
    private Long post_id;
    private String sender;
    private String token;
    private String title;
    private String content;
    private Date date;

    public void post(String sender, String token, String title,String content,Date date) {
        this.sender=sender;
        this.content=content;
        this.date=date;
        this.title=title;
    }
}
