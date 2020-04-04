package com.quan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// 实体类,用户
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private int userId;
	private String userUsername;
	private String userPassword;
	private String userType;
	private String userName;
	private String userSex;
	private int userAge;
	private Date userBirthday;
	private String userPhone;
	private String userEmail;
	private String userSchool;
	private String userAddress;
	private String userIntroduction;
	private String userPictureUrl;
}
