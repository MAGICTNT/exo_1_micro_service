package fr.maxime.exo_01_micro_service_bis.dto;

import lombok.Data;

@Data
public class OrderDtoReceive {
    private String product;
    private long userId;
}
