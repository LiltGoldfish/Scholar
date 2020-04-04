package com.quan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// 实体类,作业
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Homework {
	
	private int homeworkId;
	private Lesson lesson;
	private String homeworkName;
	private String homeworkContent;
	private Date homeworkStartTime;
	private Date homeworkEndTime;
}
