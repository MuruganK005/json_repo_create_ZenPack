package com.ZenPack.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "report_columns")
public class ReportColumns {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_data_id")
	private String reportDataId;
	
	@Column(name = "device_type")
	private String deviceType;
	
	@Column(name = "report_name")
	private String reportName;
	
	@Column(name = "data_type")
	private String dataType;
	
	@Column(name = "is_size_matrics")
	private String isSizeMatrics;
	
	@Column(name = "seq")
	private String seq;
	
	@Column(name = "column_name")
	private String columnName;
	
	@Column(name = "report_by")
	private String reportBy;
	
	@Column(name = "db_field_name")
	private String dbFieldName;
	
	@Column(name = "is_pinned")
	private boolean isPinned;

	@Column(name = "tasklist_sub_category")
	private String taskListSubCategory;

	@Column(name = "alias_name")
	private String aliasName;
	
	@Column(name = "devices")
	private String devices;
	
	@Column(name = "tasklist_category")
	private String tasklistCategory;
	
	@Column(name = "rcategory_seq")
	private String categorySeq;
	
	@Column(name = "sub_category_seq")
	private String subCategorySeq;
	
	@Column(name = "hide")
	private boolean hide;


}
