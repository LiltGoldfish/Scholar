package com.quan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

// 实体类,私信
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrivateMessage {
	
	private int privateMessageId;
	private User user;
	private User targetUser;
	private Boolean readed;
	private Date privateMessageTime;
	private String privateMessageContent;
	

}
