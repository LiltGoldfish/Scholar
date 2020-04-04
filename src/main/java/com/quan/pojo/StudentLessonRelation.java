package com.quan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 实体类,学生与课程关系类,用于记录和关联学生学习的课程
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentLessonRelation {
	
	private int studentLessonRelationId;
	private User student;
	private Lesson lesson;
}
