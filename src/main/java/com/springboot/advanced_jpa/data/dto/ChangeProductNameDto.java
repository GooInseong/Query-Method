package com.springboot.advanced_jpa.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ChangeProductNameDto {
    private Long number;
    private String name;
}
