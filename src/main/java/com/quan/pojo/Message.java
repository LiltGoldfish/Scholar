package com.quan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// 实体类,留言
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	
	private int messageId;
	private User user;
	private Lesson lesson;
	private User targetUser;
	private int floor;
	private Date messageTime;
	private String messageContent;

}
