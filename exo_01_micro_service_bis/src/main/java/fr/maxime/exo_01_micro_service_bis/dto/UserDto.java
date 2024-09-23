package fr.maxime.exo_01_micro_service_bis.dto;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String name;
    private String email;
}
