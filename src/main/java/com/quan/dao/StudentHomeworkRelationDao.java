package com.quan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.quan.pojo.StudentHomeworkRelation;

public interface StudentHomeworkRelationDao {

	@Select("SELECT * FROM studentHomeworkRelation")
	@Results({ @Result(column = "studentHomeworkRelationId", id = true, property = "studentHomeworkRelationId"),
			@Result(column = "studentId", property = "student", one = @One(select = "com.quan.dao.UserDao.getById")),
			@Result(column = "homeworkId", property = "homework", one = @One(select = "com.quan.dao.HomeworkDao.getById")),
			@Result(column = "submitTime", property = "submitTime"), @Result(column = "score", property = "score")

	})
	public List<StudentHomeworkRelation> get();

	@Select("SELECT * FROM studentHomeworkRelation WHERE StudentHomeworkRelationId = #{StudentHomeworkRelationId}")
	@Results({ @Result(column = "studentHomeworkRelationId", id = true, property = "studentHomeworkRelationId"),
			@Result(column = "studentId", property = "student", one = @One(select = "com.quan.dao.UserDao.getById")),
			@Result(column = "homeworkId", property = "homework", one = @One(select = "com.quan.dao.HomeworkDao.getById")),
			@Result(column = "submitTime", property = "submitTime"), @Result(column = "score", property = "score")

	})
	public StudentHomeworkRelation getById(int studentHomeworkRelationId);

	@Insert("INSERT INTO studentHomeworkRelation VALUES (null, #{student.userId}, #{homework.homeworkId}, #{submitTime}, #{score} ,#{src})")
	public void add(StudentHomeworkRelation studentHomeworkRelation);

	@Update("UPDATE studentHomeworkRelation SET studentId = #{student.userId}, homeworkId = #{homework.homeworkId}, submitTime = #{submitTime}, score = #{score} ,src = #{src} WHERE studentHomeworkRelationId = #{studentHomeworkRelationId}")
	public void update(StudentHomeworkRelation studentHomeworkRelation);

	@Delete("DELETE FROM studentHomeworkRelation WHERE studentHomeworkRelationId = #{studentHomeworkRelationId}")
	public void delete(int studentHomeworkRelationId);
	
	@Select("SELECT * FROM studentHomeworkRelation WHERE homeworkId = #{homeworkId}")
	@Results({ @Result(column = "studentHomeworkRelationId", id = true, property = "studentHomeworkRelationId"),
			@Result(column = "studentId", property = "student", one = @One(select = "com.quan.dao.UserDao.getById")),
			@Result(column = "homeworkId", property = "homework", one = @One(select = "com.quan.dao.HomeworkDao.getById")),
			@Result(column = "submitTime", property = "submitTime"),
			@Result(column = "score", property = "score"),
			@Result(column = "src", property = "src")
	})
	public List<StudentHomeworkRelation> getByHomeworkId(int homeworkId);
	
	@Select("SELECT * FROM studentHomeworkRelation shr JOIN homework h ON shr.homeworkId = h.homeworkId WHERE h.lessonId = #{lessonId}")
	@Results({ @Result(column = "studentHomeworkRelationId", id = true, property = "studentHomeworkRelationId"),
			@Result(column = "studentId", property = "student", one = @One(select = "com.quan.dao.UserDao.getById")),
			@Result(column = "homeworkId", property = "homework", one = @One(select = "com.quan.dao.HomeworkDao.getById")),
			@Result(column = "submitTime", property = "submitTime"), @Result(column = "score", property = "score"),
			@Result(column = "src", property = "src")
	})
	public List<StudentHomeworkRelation> getByLessonId(int lessonId);
	
	@Select("SELECT * FROM studentHomeworkRelation shr JOIN homework h ON shr.homeworkId = h.homeworkId WHERE shr.studentId = #{studentId}")
	@Results({ @Result(column = "studentHomeworkRelationId", id = true, property = "studentHomeworkRelationId"),
			@Result(column = "studentId", property = "student", many = @Many(select = "com.quan.dao.UserDao.getById")),
			@Result(column = "homeworkId", property = "homework", one = @One(select = "com.quan.dao.HomeworkDao.getById")),
			@Result(column = "submitTime", property = "submitTime"), @Result(column = "score", property = "score"),
			@Result(column = "src", property = "src")
	})
	public List<StudentHomeworkRelation> getByTheStudentId(int studentId);

	@Select("SELECT * FROM studentHomeworkRelation shr JOIN homework h ON shr.homeworkId = h.homeworkId WHERE shr.studentId = #{studentId} and h.lessonId = #{lessonId}")
	@Results({ @Result(column = "studentHomeworkRelationId", id = true, property = "studentHomeworkRelationId"),
			@Result(column = "studentId", property = "student", many = @Many(select = "com.quan.dao.UserDao.getById")),
			@Result(column = "homeworkId", property = "homework", one = @One(select = "com.quan.dao.HomeworkDao.getById")),
			@Result(column = "submitTime", property = "submitTime"), @Result(column = "score", property = "score"),
			@Result(column = "src", property = "src")
	})
	public List<StudentHomeworkRelation> getHomeworkByStudentId(@Param("studentId")int studentId , @Param("lessonId")int lessonId);


	@Select("SELECT * FROM studentHomeworkRelation WHERE studentId = #{studentId} AND homeworkId = #{homeworkId}")
	@Results({ @Result(column = "studentHomeworkRelationId", id = true, property = "studentHomeworkRelationId"),
			@Result(column = "studentId", property = "student", many = @Many(select = "com.quan.dao.UserDao.getById")),
			@Result(column = "homeworkId", property = "homework", many = @Many(select = "com.quan.dao.HomeworkDao.getById")),
			@Result(column = "submitTime", property = "submitTime"), @Result(column = "score", property = "score"),
			@Result(column = "src", property = "src")
	})
	public StudentHomeworkRelation getByLessonIdHomeworkId(@Param("studentId") int studentId, @Param("homeworkId") int homeworkId);
}
