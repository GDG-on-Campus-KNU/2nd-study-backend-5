package GDSCBackend5.HappyNewYear.server.dto;

import lombok.Data;

@Data
public class ResponseDto {
    private String message;

    public ResponseDto(String message) {
        this.message = message;
    }
}
