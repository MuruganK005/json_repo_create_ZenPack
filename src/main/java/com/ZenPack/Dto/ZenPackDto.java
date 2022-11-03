package com.ZenPack.Dto;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ZenPackDto {
    private Long zenPackId;
    private String name;
    private String createdBy;
    private String createdDate;
    private String updatedBy;
    private String updatedTime;
    private List<MenuDto> menus;
    private List<FeatureDto> features;
    private Boolean inActive=false;
}