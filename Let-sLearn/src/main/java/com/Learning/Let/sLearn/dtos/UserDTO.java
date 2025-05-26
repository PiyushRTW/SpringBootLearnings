package com.Learning.Let.sLearn.dtos;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password; // Be cautious about exposing passwords in responses
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // Include other relevant user fields
}
