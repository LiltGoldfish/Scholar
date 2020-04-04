package com.quan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 实体类,专业
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Major {
	
	private int majorId;
	private Department department;
	private String majorName;

}
