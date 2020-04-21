/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 100138
 Source Host           : localhost:3306
 Source Schema         : scholar

 Target Server Type    : MySQL
 Target Server Version : 100138
 File Encoding         : 65001

 Date: 21/04/2020 16:05:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for courseware
-- ----------------------------
DROP TABLE IF EXISTS `courseware`;
CREATE TABLE `courseware`  (
  `coursewareID` int(11) NOT NULL AUTO_INCREMENT,
  `lessonID` int(11) NULL DEFAULT NULL,
  `coursewareTitle` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `publicTime` datetime(6) NULL DEFAULT NULL,
  `src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`coursewareID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courseware
-- ----------------------------
INSERT INTO `courseware` VALUES (9, 41, '3D打印课件1', '2020-04-07 14:31:44.000000', 'resource/courseware/3D打印课件1.ppt');
INSERT INTO `courseware` VALUES (10, 39, '课件1', '2020-04-08 10:03:24.000000', 'resource/courseware/校招.jpg');
INSERT INTO `courseware` VALUES (14, 51, '1.1 走进Arduino的世界', '2020-04-18 14:34:33.000000', 'resource/courseware/1.1 走进Arduino的世界.ppt');
INSERT INTO `courseware` VALUES (15, 51, '1.2 闪烁LED', '2020-04-18 14:34:50.000000', 'resource/courseware/1.2 闪烁LED.ppt');
INSERT INTO `courseware` VALUES (16, 51, '1.3 按钮控制的LED', '2020-04-18 14:35:11.000000', 'resource/courseware/1.3 按钮控制LED.ppt');
INSERT INTO `courseware` VALUES (17, 51, '1.4 聪明的按钮', '2020-04-18 14:35:35.000000', 'resource/courseware/1.4 聪明的按钮.ppt');
INSERT INTO `courseware` VALUES (22, 56, '课件1-绪论', '2020-04-18 19:18:37.000000', 'resource/courseware/绪论.ppt');
INSERT INTO `courseware` VALUES (23, 57, '课件1-绪论', '2020-04-19 08:33:10.000000', 'resource/courseware/绪论.ppt');

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `departmentId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`departmentId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES (1, '1-3年级');
INSERT INTO `department` VALUES (2, '4-6年级');
INSERT INTO `department` VALUES (3, '初中');
INSERT INTO `department` VALUES (4, '高中');

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework`  (
  `homeworkId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `lessonId` int(11) UNSIGNED NOT NULL,
  `homeworkName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `homeworkContent` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `homeworkStartTime` datetime(0) NOT NULL,
  `homeworkEndTime` datetime(0) NOT NULL,
  PRIMARY KEY (`homeworkId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 82 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homework
-- ----------------------------
INSERT INTO `homework` VALUES (63, 39, '介绍自己', '做一个小小的自我介绍', '2020-04-07 14:20:47', '2020-04-09 14:20:47');
INSERT INTO `homework` VALUES (64, 40, '展示学习成果', '展示自己的学习成果，以图片形式上传', '2020-04-07 14:24:12', '2020-04-10 14:24:12');
INSERT INTO `homework` VALUES (65, 41, '描述自己对3D打印的理解', '描述自己对3D打印的理解', '2020-04-07 14:30:41', '2020-04-10 14:30:41');
INSERT INTO `homework` VALUES (66, 45, '描述对Scrztch机器人的理解', '描述对Scrztch机器人的理解', '2020-04-07 14:40:05', '2020-04-09 14:40:05');
INSERT INTO `homework` VALUES (67, 47, '上传使用无人机视频', '上传使用无人机视频', '2020-04-07 14:43:52', '2020-04-09 14:43:52');
INSERT INTO `homework` VALUES (68, 39, '作业2', '完成今天布置的作业。', '2020-04-08 10:02:52', '2020-04-10 10:02:52');
INSERT INTO `homework` VALUES (69, 39, '作业3', 'xxxx', '2020-04-14 09:07:27', '2020-04-16 09:07:27');
INSERT INTO `homework` VALUES (70, 51, '1.1查阅相关的资料', '请同学们上网或者查阅相关的资料，了解一下通过Arduino平台可以制作哪些有生活意义、有趣的智能人造物。', '2020-04-18 14:21:06', '2020-04-20 14:21:06');
INSERT INTO `homework` VALUES (71, 51, '1.2制作闪烁的LED', '将自己制作的LED闪烁效果视频上传', '2020-04-18 14:22:58', '2020-04-21 14:22:58');
INSERT INTO `homework` VALUES (72, 51, '1.3制作“按钮按下开，再按下关”的LED', '制作“按钮按下开，再按下关”的LED\r\n思考一个按钮控制LED，还有哪些情况？', '2020-04-18 14:24:55', '2020-04-21 14:24:55');
INSERT INTO `homework` VALUES (75, 51, '1.4制作“按钮按下亮，放开灭”的LED', '【探究思考】\r\n除了以上按钮控制LED亮灭的效果，还可以用按钮控制LED实现哪些效果？', '2020-04-18 14:29:42', '2020-04-20 14:29:42');
INSERT INTO `homework` VALUES (80, 56, '作业1', '作业内容', '2020-04-18 19:18:25', '2020-04-19 19:18:25');
INSERT INTO `homework` VALUES (81, 57, '作业X', '作业内容', '2020-04-19 08:32:52', '2020-04-20 08:32:52');

-- ----------------------------
-- Table structure for lesson
-- ----------------------------
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE `lesson`  (
  `lessonId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `teacherId` int(11) UNSIGNED NOT NULL,
  `majorId` int(11) UNSIGNED NOT NULL,
  `lessonName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lessonIntroduction` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lessonAnnouncement` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `lessonPictureUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`lessonId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lesson
-- ----------------------------
INSERT INTO `lesson` VALUES (39, 5, 1, '初级电子积木（上）', '认识并了解电子积木', '对机器人感兴趣！', 'resource/lesson/0.jpg');
INSERT INTO `lesson` VALUES (40, 5, 2, '初级电子积木（下）', '深入了解电子积木', '学习完初级电子积木（上）', 'resource/lesson/1.jpg');
INSERT INTO `lesson` VALUES (41, 6, 3, '3D打印G-KIT（上）', '认识并了解创客机床3D打印', '对3D打印感兴趣！', 'resource/lesson/2.jpg');
INSERT INTO `lesson` VALUES (42, 6, 3, '3D打印G-KIT（下）', '深入理解3D打印原理', '学完3D打印（上）', 'resource/lesson/3.jpg');
INSERT INTO `lesson` VALUES (43, 7, 1, 'Scrztch软件编程（上）', '初步了解编程', '对编程感兴趣', 'resource/lesson/4.jpg');
INSERT INTO `lesson` VALUES (44, 7, 7, 'Scrztch软件编程（下）', '试着理解编程思想', '学完Scratch编程（上）', 'resource/lesson/5.jpg');
INSERT INTO `lesson` VALUES (45, 10, 8, 'Scratch机器人（上）', '理解Scratch机器人', '学习完成Scratch编程（上）和（下）', 'resource/lesson/6.jpg');
INSERT INTO `lesson` VALUES (46, 10, 8, 'Scratch机器人（下）', '深入领悟Scratch机器人的工作原理', '学习完Scratch机器人（上）', 'resource/lesson/0.jpg');
INSERT INTO `lesson` VALUES (47, 11, 9, '无人机', '会使用无人机', '对无人机感兴趣', 'resource/lesson/1.jpg');
INSERT INTO `lesson` VALUES (48, 12, 10, 'Arduino金属开源机器人系列', '掌握基本概念', '对机器人感兴趣！', 'resource/lesson/2.jpg');
INSERT INTO `lesson` VALUES (49, 12, 11, 'BLOCK仿生高级机器人', '深入理解BLOCK仿生机器人', '有一定机器人基础', 'resource/lesson/3.jpg');
INSERT INTO `lesson` VALUES (50, 13, 12, 'Maker仿生机器人', '初步了解Maker仿生机器人', '对机器人感兴趣！', 'resource/lesson/4.jpg');
INSERT INTO `lesson` VALUES (51, 5, 6, 'Arduino创意机器人', '在基础教育领域，机器人可以与信息技术课程进行整合，也可以与通用技术课程整合，还可以与物理、数学、生物等等相关课程进行整合，以Arduino为平台的机器人课程教学需要搭建硬件、检测与控制电路，然后编写控制程序烧录代码，就可以控制机器人的各种动作和行为。本课程主要涉及到的教学项目有智能LED、智能风扇、智能小车等，分为三章22课，具体的课程内容主要为：\r\n1．智能LED系列，包括点亮LED、按钮控制的LED、创意LED三个专题，主要是Arduino的基础知识。\r\n    2．智能风扇系列，包括智能风扇、变速风扇、创意风扇三个专题，主要是Arduino基础知识的强化与深入。\r\n3．智能小车系列，包括会走路的小车、避障小车、巡线小车三个专题，主要是Arduino机器人的综合运用。', 'Arduino创意机器人课程的总目标是提高学生的创新能力、综合设计能力和动手实践能力，进而培养和提升学生的STEM素养，强调学生在直接经验和亲身经历的基础上，通过观察、思考、设计、制作、试验等活动获得丰富的学习体验，在生活中发现问题，在实践中解决问题，在活动中获得知识。', 'resource/lesson/3.jpg');
INSERT INTO `lesson` VALUES (56, 5, 1, '课程1', '课程描述', '课程要求', 'resource/lesson/0.jpg');
INSERT INTO `lesson` VALUES (57, 5, 4, '课程2', '课程描述', '课程要求', 'resource/lesson/0.jpg');

-- ----------------------------
-- Table structure for major
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major`  (
  `majorId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `departmentId` int(11) UNSIGNED NOT NULL,
  `majorName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`majorId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES (1, 1, '初级机器人Ⅰ');
INSERT INTO `major` VALUES (2, 1, '初级机器人Ⅱ');
INSERT INTO `major` VALUES (3, 2, '初级机器人Ⅲ');
INSERT INTO `major` VALUES (4, 2, '中级机器人Ⅰ');
INSERT INTO `major` VALUES (5, 2, '中级机器人Ⅱ');
INSERT INTO `major` VALUES (6, 3, '中级机器人Ⅲ');
INSERT INTO `major` VALUES (7, 3, '高级机器人Ⅰ');
INSERT INTO `major` VALUES (8, 3, '高级机器人Ⅱ');
INSERT INTO `major` VALUES (9, 4, 'BLOCK仿生初级机器人');
INSERT INTO `major` VALUES (10, 4, 'BLOCK仿生中级机器人');
INSERT INTO `major` VALUES (11, 4, 'Arduino初级编程');
INSERT INTO `major` VALUES (12, 4, 'Arduino金属开源机器人入门');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `messageId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `userId` int(11) UNSIGNED NOT NULL,
  `lessonId` int(11) UNSIGNED NOT NULL,
  `targetUserId` int(11) UNSIGNED NOT NULL,
  `floor` int(11) UNSIGNED NOT NULL,
  `messageTime` datetime(0) NOT NULL,
  `messageContent` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`messageId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 77 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (54, 5, 39, 0, 1, '2020-04-07 14:21:52', '欢迎大家积极留言，不懂的地方可以提问！');
INSERT INTO `message` VALUES (55, 5, 40, 0, 1, '2020-04-07 14:25:08', '我们已经学习完初级电子积木（上）了，同学们有问题积极提问哦！');
INSERT INTO `message` VALUES (56, 6, 41, 0, 1, '2020-04-07 14:32:13', '第一节课大家好好完成作业！');
INSERT INTO `message` VALUES (57, 7, 43, 0, 1, '2020-04-07 14:35:44', '编程课开始啦');
INSERT INTO `message` VALUES (58, 7, 44, 0, 1, '2020-04-07 14:37:52', '同学们对编程有什么疑问吗？');
INSERT INTO `message` VALUES (59, 11, 47, 0, 1, '2020-04-07 14:45:20', '姜承禄使用情况非常好，在这里提出表扬，大家向他学习！\r\n');
INSERT INTO `message` VALUES (60, 13, 50, 0, 1, '2020-04-07 14:50:56', '开课啦');
INSERT INTO `message` VALUES (61, 1, 39, 5, 1, '2020-04-07 14:55:04', '老师你好，今天的作业以什么格式提交');
INSERT INTO `message` VALUES (62, 1, 39, 0, 2, '2020-04-07 14:55:18', '老师讲课很好');
INSERT INTO `message` VALUES (63, 2, 42, 0, 1, '2020-04-07 14:56:43', '课程不错');
INSERT INTO `message` VALUES (64, 1, 50, 13, 1, '2020-04-07 14:59:05', '来啦');
INSERT INTO `message` VALUES (65, 5, 39, 0, 3, '2020-04-08 10:03:59', 'xxx');
INSERT INTO `message` VALUES (66, 5, 51, 0, 1, '2020-04-18 14:36:56', '欢迎大家积极留言提问');
INSERT INTO `message` VALUES (73, 5, 56, 0, 1, '2020-04-18 19:18:57', '大家好，欢迎大家积极提问！');
INSERT INTO `message` VALUES (74, 1, 56, 5, 1, '2020-04-18 19:20:31', '老师好');
INSERT INTO `message` VALUES (75, 5, 57, 0, 1, '2020-04-19 08:33:28', '大家好！');
INSERT INTO `message` VALUES (76, 1, 57, 5, 1, '2020-04-19 08:34:19', '老师好');

-- ----------------------------
-- Table structure for privatemessage
-- ----------------------------
DROP TABLE IF EXISTS `privatemessage`;
CREATE TABLE `privatemessage`  (
  `privateMessageId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `userId` int(11) UNSIGNED NOT NULL,
  `targetUserId` int(11) UNSIGNED NOT NULL,
  `readed` tinyint(1) UNSIGNED NOT NULL,
  `privateMessageTime` datetime(0) NOT NULL,
  `privateMessageContent` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`privateMessageId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of privatemessage
-- ----------------------------
INSERT INTO `privatemessage` VALUES (27, 5, 3, 1, '2020-04-07 14:25:53', '你的作业没有提交哦！');
INSERT INTO `privatemessage` VALUES (28, 5, 1, 0, '2020-04-07 14:26:45', '你的作业很棒！');
INSERT INTO `privatemessage` VALUES (29, 7, 5, 0, '2020-04-07 14:36:11', '张老师，你好！');
INSERT INTO `privatemessage` VALUES (30, 10, 4, 1, '2020-04-07 14:41:22', '你的作业很棒哦！');
INSERT INTO `privatemessage` VALUES (31, 12, 2, 1, '2020-04-07 14:47:56', '你好');
INSERT INTO `privatemessage` VALUES (33, 5, 1, 0, '2020-04-18 19:21:51', '同学你好');
INSERT INTO `privatemessage` VALUES (34, 1, 5, 0, '2020-04-19 08:34:35', '老师你好！');

-- ----------------------------
-- Table structure for studenthomeworkrelation
-- ----------------------------
DROP TABLE IF EXISTS `studenthomeworkrelation`;
CREATE TABLE `studenthomeworkrelation`  (
  `studentHomeworkRelationId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `studentId` int(11) UNSIGNED NOT NULL,
  `homeworkId` int(11) UNSIGNED NOT NULL,
  `submitTime` datetime(0) NOT NULL,
  `score` int(11) UNSIGNED NOT NULL,
  `src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`studentHomeworkRelationId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studenthomeworkrelation
-- ----------------------------
INSERT INTO `studenthomeworkrelation` VALUES (19, 1, 63, '2020-04-07 14:54:19', 2, 'resource/homework/5b9de60d-4c33-4266-8d21-91510f692ef0.doc');
INSERT INTO `studenthomeworkrelation` VALUES (20, 1, 68, '2020-04-08 10:09:18', 0, 'resource/homework/efca8303-32b9-4a77-93b8-bd6006f27479.pdf');
INSERT INTO `studenthomeworkrelation` VALUES (23, 1, 80, '2020-04-18 19:19:53', 3, 'resource/homework/9c646b3e-15f5-41fc-942f-bb4bf6d16ac5.doc');
INSERT INTO `studenthomeworkrelation` VALUES (24, 1, 81, '2020-04-19 08:34:03', 3, 'resource/homework/d847e756-4965-4767-81d6-15e72ce9184d.doc');

-- ----------------------------
-- Table structure for studentlessonrelation
-- ----------------------------
DROP TABLE IF EXISTS `studentlessonrelation`;
CREATE TABLE `studentlessonrelation`  (
  `studentLessonRelationId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `studentId` int(11) UNSIGNED NOT NULL,
  `lessonId` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`studentLessonRelationId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of studentlessonrelation
-- ----------------------------
INSERT INTO `studentlessonrelation` VALUES (18, 1, 39);
INSERT INTO `studentlessonrelation` VALUES (19, 1, 40);
INSERT INTO `studentlessonrelation` VALUES (20, 2, 41);
INSERT INTO `studentlessonrelation` VALUES (21, 2, 42);
INSERT INTO `studentlessonrelation` VALUES (22, 3, 43);
INSERT INTO `studentlessonrelation` VALUES (23, 3, 44);
INSERT INTO `studentlessonrelation` VALUES (24, 4, 45);
INSERT INTO `studentlessonrelation` VALUES (25, 4, 46);
INSERT INTO `studentlessonrelation` VALUES (26, 8, 47);
INSERT INTO `studentlessonrelation` VALUES (27, 9, 48);
INSERT INTO `studentlessonrelation` VALUES (28, 4, 49);
INSERT INTO `studentlessonrelation` VALUES (29, 1, 50);
INSERT INTO `studentlessonrelation` VALUES (30, 1, 51);
INSERT INTO `studentlessonrelation` VALUES (31, 1, 53);
INSERT INTO `studentlessonrelation` VALUES (32, 1, 55);
INSERT INTO `studentlessonrelation` VALUES (33, 1, 56);
INSERT INTO `studentlessonrelation` VALUES (34, 1, 57);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `userUsername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userPassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userType` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userSex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userAge` int(11) UNSIGNED NOT NULL,
  `userBirthday` date NOT NULL,
  `userPhone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userEmail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userSchool` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userIntroduction` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userPictureUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '2020001', '123456', '学生', '陈晓阳', '女', 14, '2006-04-05', '18475830053', '1637698669@qq.com', '徐州市第一中学', '江苏省徐州市', '我是学生', 'resource/user/3.jpg');
INSERT INTO `user` VALUES (2, '2020002', '123456', '学生', '宋义进', '女', 15, '2005-04-12', '18475862054', '1637698669@qq.com', '徐州市第二中学', '江苏省徐州市', '我是学生', 'resource/user/2.jpg');
INSERT INTO `user` VALUES (3, '2020003', '123456', '学生', '简自豪', '男', 12, '2008-11-20', '18475869584', '1637698669@qq.com', '徐州市第三中学', '江苏省徐州市', '我是学生', 'resource/user/3.jpg');
INSERT INTO `user` VALUES (4, '2020004', '123456', '学生', '姜承禄', '男', 16, '2004-05-07', '18475869354', '1637698669@qq.com', '徐州市第四中学', '江苏省徐州市', '我是学生', 'resource/user/4.jpg');
INSERT INTO `user` VALUES (5, '1020001', '123456', '老师', '张老师', '男', 26, '1994-05-01', '15325485679', '1637698669@qq.com', '教育机器人平台', '江苏省徐州市', '我是老师', 'resource/user/1.jpg');
INSERT INTO `user` VALUES (6, '1020002', '123456', '老师', '何老师', '男', 34, '1986-07-03', '17456254869', '1637698669@qq.com', '教育机器人平台', '江苏省徐州市', '我是老师', 'resource/user/3.jpg');
INSERT INTO `user` VALUES (7, '1020003', '123456', '老师', '陈老师', '女', 34, '1986-08-05', '15475869584', '1637698669@qq.com', '教育机器人平台', '江苏省徐州市', '我是老师', 'resource/user/3.jpg');
INSERT INTO `user` VALUES (8, '2020005', '123456', '学生', '高振宁', '男', 18, '2002-10-17', '13125469542', '1637698669@qq.com', '徐州市第四中学', '江苏省徐州市', '我是学生', 'resource/user/4.jpg');
INSERT INTO `user` VALUES (9, '2020006', '123456', '学生', 'Puff', '男', 16, '2004-05-05', '14758965248', '1637698669@qq.com', '徐州市第一中学', '江苏省徐州市', '我是学生', 'resource/user/1.jpg');
INSERT INTO `user` VALUES (10, '1020004', '123456', '老师', '李老师', '男', 33, '1987-06-05', '13625487589', '1637698669@qq.com', '教育机器人平台', '江苏省徐州市', '我是老师', 'resource/user/3.jpg');
INSERT INTO `user` VALUES (11, '1020005', '123456', '老师', '明老师', '女', 33, '1987-08-04', '15484576856', '1637698669@qq.com', '教育机器人平台', '江苏省徐州市', '我是老师', 'resource/user/3.jpg');
INSERT INTO `user` VALUES (12, '1020006', '123456', '老师', '黄老师', '男', 34, '1986-04-03', '15486859675', '1637698669@qq.com', '教育机器人平台', '江苏省徐州市', '我是老师', 'resource/user/2.jpg');
INSERT INTO `user` VALUES (13, '1020007', '123456', '老师', '柯老师', '女', 34, '1987-06-09', '157856895354', '1637698669@qq.com', '教育机器人平台', '江苏省徐州市', '我是老师', 'resource/user/1.jpg');

-- ----------------------------
-- Table structure for userfocusrelation
-- ----------------------------
DROP TABLE IF EXISTS `userfocusrelation`;
CREATE TABLE `userfocusrelation`  (
  `userFocusRelationId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `userId` int(11) UNSIGNED NOT NULL,
  `targetUserId` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`userFocusRelationId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 64 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of userfocusrelation
-- ----------------------------
INSERT INTO `userfocusrelation` VALUES (56, 5, 3);
INSERT INTO `userfocusrelation` VALUES (58, 7, 5);
INSERT INTO `userfocusrelation` VALUES (59, 10, 4);
INSERT INTO `userfocusrelation` VALUES (60, 12, 2);
INSERT INTO `userfocusrelation` VALUES (61, 1, 5);
INSERT INTO `userfocusrelation` VALUES (62, 5, 7);
INSERT INTO `userfocusrelation` VALUES (63, 5, 1);

SET FOREIGN_KEY_CHECKS = 1;
