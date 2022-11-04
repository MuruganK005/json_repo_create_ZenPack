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
@Table(name = "report")
public class Report {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "report_id")
	private long id;
	@Column(name = "feature")
	private String feature;
	@Column(name = "category")
	private String category;
	@Column(name = "os_type")
	private String osType;
	@Column(name = "discovery_type")
	private String discoveryType;
	@Column(name = "analytics_by")
	private String analyticsBy;

}
