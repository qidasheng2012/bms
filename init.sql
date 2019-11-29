CREATE DATABASE `bms`;

USE `bms`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类别主键id',
  `category_name` varchar(200) NOT NULL DEFAULT '' COMMENT '类别名称',
  `is_deleted` int(1) NOT NULL DEFAULT '0' COMMENT '是否已删除 0-未删除 1-已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('1', '体育', '0', '2019-11-11 11:11:11');
INSERT INTO `t_category` VALUES ('2', '图片', '0', '2019-11-11 11:11:11');
INSERT INTO `t_category` VALUES ('3', '军事', '0', '2019-11-11 11:11:11');
INSERT INTO `t_category` VALUES ('4', 'IT', '0', '2019-11-11 11:11:11');
INSERT INTO `t_category` VALUES ('5', '教育', '0', '2019-11-11 11:11:11');
INSERT INTO `t_category` VALUES ('6', '文化', '0', '2019-11-11 11:11:11');

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论主键id',
  `news_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '关联咨询主键id',
  `commentator` varchar(200) NOT NULL DEFAULT '' COMMENT '评论人',
  `comment_body` varchar(300) NOT NULL DEFAULT '' COMMENT '评论内容',
  `comment_status` int(1) NOT NULL DEFAULT '0' COMMENT '评论状态 0-未审核 1-审核通过',
  `is_deleted` int(1) NOT NULL DEFAULT '0' COMMENT '是否已删除 0-未删除 1-已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('1', '1', 'tom', '评论测试', '0', '0', '2019-11-11 11:11:11');
INSERT INTO `t_comment` VALUES ('2', '2', 'jack', '留言测试', '0', '0', '2019-11-11 11:11:11');

-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '新闻主键id',
  `news_title` varchar(200) NOT NULL DEFAULT '' COMMENT '标题',
  `news_category_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '新闻类型',
  `news_cover_image` varchar(200) NOT NULL DEFAULT '' COMMENT '新闻封面图片',
  `news_content` text NOT NULL COMMENT '内容',
  `news_status` int(1) NOT NULL DEFAULT '0' COMMENT '发布状态 0-发布 1-草稿',
  `news_views` bigint(20) NOT NULL DEFAULT '0' COMMENT '浏览量',
  `is_deleted` int(1) NOT NULL DEFAULT '0' COMMENT '是否已删除 0-未删除 1-已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES ('1', '《流浪地球》', '6', 'http://localhost:8080/files/20190212_16543993.jpg', '<p class=\"one-p\" style=\"font-family:\" font-size:18px;\"=\"\">xxx\n	</p>', '1', '1000', '0', '2019-11-11 11:11:11', '2019-11-11 11:11:11');
INSERT INTO `t_news` VALUES ('2', '《SpringBoot实战》', '4', 'http://127.0.0.1:8080/files/20191129_15052826.jpg', 'it技术实战', '1', '0', '0', '2019-11-11 11:11:11', '2019-11-11 11:11:11');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '管理员主键id',
  `user_name` varchar(200) NOT NULL DEFAULT '' COMMENT '管理员登陆名称',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '管理员登陆密码',
  `nick_name` varchar(50) NOT NULL DEFAULT '' COMMENT '管理员显示名称',
  `locked` int(1) NOT NULL DEFAULT '0' COMMENT '是否锁定 0未锁定 1已锁定无法登陆',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin', '0');
