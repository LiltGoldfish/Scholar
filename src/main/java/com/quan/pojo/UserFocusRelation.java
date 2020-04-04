package com.quan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 实体类,用户关注关系,用于记录和关联用户之间的关注
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFocusRelation {
	
	private int userFocusRelationId;
	private User user;
	private User targetUser;

}
