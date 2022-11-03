package com.ZenPack.Dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class HeaderInfoDto implements Serializable {

	private static final long serialVersionUID = 6067643839574646866L;
	
	private String actualName;
	private boolean hide;
	private String displayName;
	private String dataType;
	
}
