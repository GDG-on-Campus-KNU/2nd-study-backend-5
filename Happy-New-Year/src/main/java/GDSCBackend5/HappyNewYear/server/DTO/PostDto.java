package GDSCBackend5.HappyNewYear.server.DTO;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class PostDto {
    private Long post_id;
    private String sender;
    private String token;
    private String title;
    private String content;
    private Date date;

}
