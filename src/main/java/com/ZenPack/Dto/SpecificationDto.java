package com.ZenPack.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpecificationDto {
    private String key;
    private String operation;
    private String value;
    private List<?> vaLues;
}
