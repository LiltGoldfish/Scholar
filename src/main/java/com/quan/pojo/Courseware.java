package com.quan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Insert;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courseware {
    Integer coursewareID;
    Integer lessonID;
    String coursewareTitle;
    Date publicTime;
    String src;
}
