package com.ZenPack.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportColumnsDto {

    private String reportDataId;
    private String deviceType;
    private String reportName;
    private String dataType;
    private String isSizeMetrics;
    private String seq;
    private String reportColumns;
    private String reportBy;
    private String dbFieldName;
    private boolean isPinned;
    private String tasklistSubCategory;
    private String aliasName;
    private String devices;
    private String tasklistCategory;
    private String categorySeq;
    private String subCategorySeq;
    private boolean hide;

}
