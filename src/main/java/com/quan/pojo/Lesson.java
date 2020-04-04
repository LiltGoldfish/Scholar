package com.quan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 实体类,课程
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson {
	
	private int lessonId;
	private User teacher;
	private Major major;
	private String lessonName;
	private String lessonIntroduction;
	private String lessonAnnouncement;
	private String lessonPictureUrl;
}
