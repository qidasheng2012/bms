CREATE DATABASE `bms`;

USE `bms`;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_admin_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin_user`;
CREATE TABLE `tb_admin_user` (
  `admin_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '管理员主键id',
  `login_name` varchar(200) NOT NULL DEFAULT '' COMMENT '管理员登陆名称',
  `login_password` varchar(50) NOT NULL DEFAULT '' COMMENT '管理员登陆密码',
  `admin_nick_name` varchar(50) NOT NULL DEFAULT '' COMMENT '管理员显示名称',
  `locked` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否锁定 0未锁定 1已锁定无法登陆',
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin_user
-- ----------------------------
INSERT INTO `tb_admin_user` VALUES ('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin', '0');

-- ----------------------------
-- Table structure for tb_news
-- ----------------------------
DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news` (
  `news_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '新闻主键id',
  `news_title` varchar(200) NOT NULL DEFAULT '' COMMENT '标题',
  `news_category_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '新闻类型',
  `news_cover_image` varchar(200) NOT NULL DEFAULT '' COMMENT '新闻封面图片',
  `news_content` text NOT NULL COMMENT '内容',
  `news_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '发布状态 0-发布 1-草稿',
  `news_views` bigint(20) NOT NULL DEFAULT '0' COMMENT '浏览量',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已删除 0-未删除 1-已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_news
-- ----------------------------
INSERT INTO `tb_news` VALUES ('1', '基层访问', '1', 'http://localhost:28083/files/1.jpg', '<p class=\"text\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;text-indent:2em;\">\n	新华社北京2月1日电 中华民族传统节日农历春节来临之际，中共中央总书记、国家主席、中央军委主席习近平在北京看望慰问基层干部群众，考察北京冬奥会、冬残奥会筹办工作，向全国各族人民致以美好的新春祝福，祝各族人民幸福安康，祝伟大祖国繁荣吉祥。\n</p>\n<p class=\"text\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;text-indent:2em;\">\n	中共中央政治局常委、国务院副总理韩正陪同考察北京冬奥会和冬残奥会筹办工作。\n</p>\n<p class=\"text\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;text-indent:2em;\">\n	冬日的北京，阳光万里，碧空如洗。2月1日，习近平在中共中央政治局委员、北京市委书记蔡奇和市长陈吉宁陪同下，深入机关、社区、冬训中心考察调研，给基层干部群众送去党中央的关心和慰问。\n</p>\n<p align=\"center\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;\">\n	<img src=\"https://inews.gtimg.com/newsapp_bt/0/7551828141/641\" />\n</p>\n<p align=\"center\" class=\"text image_desc\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;\">\n	2月1日，中共中央总书记、国家主席、中央军委主席习近平在北京看望慰问基层干部群众，考察北京冬奥会、冬残奥会筹办工作。这是1日上午，习近平在北京市公安局，同公安英模和干警代表一一握手，向全国广大公安干警致以新春祝福。 新华社记者 谢环驰 摄\n</p>\n<p class=\"text\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;text-indent:2em;\">\n	上午，习近平首先来到北京市公安局，走进合成作战指挥中心和指挥大厅，通过大屏幕了解勤务指挥调度、巡逻警务、视频警务、区域警务合作和京津冀警务协同发展等工作情况。指挥大厅内，习近平通过视频连线一线执勤民警，向他们表示诚挚慰问，叮嘱他们注意安全、保重身体，并向全国广大公安干警拜年。在北京市公安局一层大厅，习近平同公安英模和干警代表一一握手。习近平强调，党中央十分关心过节期间全国特别是首都地区的社会稳定，为的是确保人民群众平平安安过好年。今年是新中国成立70周年，确保首都社会稳定，北京市使命光荣、责任重大、任务艰巨。要统筹推进各方面工作，坚决完成好任务，让党中央放心、让全国人民放心。\n</p>\n<p align=\"center\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;\">\n	<img src=\"https://inews.gtimg.com/newsapp_bt/0/7551828142/641\" />\n</p>\n<p align=\"center\" class=\"text image_desc\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;\">\n	2月1日，中共中央总书记、国家主席、中央军委主席习近平在北京看望慰问基层干部群众，考察北京冬奥会、冬残奥会筹办工作。这是1日上午，习近平在前门东区草厂四条胡同32号院，高兴地拿起一幅“福”字，亲自贴到门上，给这里的老街坊们拜年。 新华社记者 鞠鹏 摄\n</p>\n<p class=\"text\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;text-indent:2em;\">\n	临近春节，北京城内年味渐浓，大街小巷张灯结彩，家家户户喜迎春节。习近平来到前门东区，沿草厂四条胡同步行察看街巷风貌，听取区域规划建设、老城保护、疏解腾退、人居环境改善等情况介绍。前门东区是北京老城重要历史片区，是北京这座千年古都深厚文化底蕴的重要体现。习近平对北京开展旧城保护整治的思路和做法表示肯定。他强调，一个城市的历史遗迹、文化古迹、人文底蕴，是城市生命的一部分。文化底蕴毁掉了，城市建得再新再好，也是缺乏生命力的。要把老城区改造提升同保护历史遗迹、保存历史文脉统一起来，既要改善人居环境，又要保护历史文化底蕴，让历史文化和现代生活融为一体。老北京的一个显著特色就是胡同，要注意保留胡同特色，让城市留住记忆，让人们记住乡愁。\n</p>\n<p align=\"center\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;\">\n	<img src=\"https://inews.gtimg.com/newsapp_bt/0/7551828143/641\" />\n</p>\n<p align=\"center\" class=\"text image_desc\" style=\"font-family:&quot;font-size:16px;background-color:#FFFFFF;\">\n	2月1日，中共中央总书记、国家主席、中央军委主席习近平在北京看望慰问基层干部群众，考察北京冬奥会、冬残奥会筹办工作。这是1日上午，习近平来到前门东区草厂四条胡同看望慰问群众。 新华社记者 谢环驰 摄\n</p>', '1', '0', '1', '2019-02-03 02:14:56', '2019-02-02 22:16:48');
INSERT INTO `tb_news` VALUES ('2', '资讯管理系统', '1', 'http://localhost:28083/files/20190203_12162017.jpg', '<p class=\"introduction\" style=\"color:#555555;font-family:&quot;font-size:18px;\">\n	导语：在休闲方式上，近八成人选择泡汤养生。不同年龄人群也有自己的偏好。30岁以上偏爱洗浴汗蒸、茶馆、按摩/足疗，30岁以下偏爱网吧/电竞、桌游和酒吧。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	《恭喜发财》又在大街小巷开始响起来，提醒着我们最盛大的节日——春节就要到了。这个春节你将在哪里，和谁一起，又会如何度过呢？\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	近日，某外卖点评搜索平台发布《2019春节消费地图》（下称“报告”），基于大数据洞察了不同地域消费者不同的过年方式，一起来看看。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<span style=\"font-weight:bolder;\">春节餐桌上的C位 还是传统美食</span>\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	吃是过年头等大事。这个春节，各地的年味主食依然被传统美食主宰。北京的饺子、烤鸭，广州的煲仔饭、椰子鸡，武汉的热干面，西安的泡馍，成都的串串，华东的八宝饭，西部的腊肉……依旧是各个地方过年最火菜品。这些菜品每年都有，但大家每年对它们也都有不同的期待。\n</p>\n<div class=\"LazyLoad is-visible\" style=\"margin:0px;padding:0px;font-family:&quot;font-size:18px;\">\n	<p class=\"one-p\">\n		<img class=\"content-picture\" alt=\"\" src=\"https://inews.gtimg.com/newsapp_bt/0/7566165035/1000\" />\n	</p>\n</div>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	除了北方的饺子、南方的盆菜这些传统菜品，这个春节还有网红菜来凑热闹。《报告》显示，舒芙蕾、脏脏茶、炭火蛙锅成为2018春节期间搜索量最高的三样网红菜，相信2019它们也不会缺席。\n</p>\n<div class=\"LazyLoad\" style=\"margin:0px;padding:0px;font-family:&quot;font-size:18px;\">\n</div>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<span style=\"font-weight:bolder;\">休闲方式选什么？近八成人选择泡汤养生</span>\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	除了吃喝，春节该怎么玩？亲朋好友、同窗同事一起聚聚，休闲玩乐肯定少不了。在休闲方式上，近八成人选择泡汤养生。不同年龄人群也有自己的偏好。30岁以上偏爱洗浴汗蒸、茶馆、按摩/足疗，30岁以下偏爱网吧/电竞、桌游和酒吧。\n</p>\n<div class=\"LazyLoad\" style=\"margin:0px;padding:0px;font-family:&quot;font-size:18px;\">\n</div>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<span style=\"font-weight:bolder;\">过年去旅游 上海迪士尼很火爆</span>\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	假期出游犒劳一下自己，也成国人度假标配。大年初一聚会过后，不少国人就选择踏上旅行的征途。数据显示，2019春节景区附近酒店提前预定订单中，正月初二、初三的需求最旺。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	国内景区中，上海迪士尼、横店影视城、哈尔滨冰雪大世界成为最热景区。境外游中，中国香港、曼谷、东京成为最热目的地。东京、大阪、京都热度上升最快。\n</p>\n<div class=\"LazyLoad\" style=\"margin:0px;padding:0px;font-family:&quot;font-size:18px;\">\n</div>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	<span style=\"font-weight:bolder;\">感受传统民俗文化成“新潮流”</span>\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	当然，还有越来越多的消费者开始回归年味，逛庙会、赏花灯、看展览……传统民俗文化已经成为过年“新潮流”了。\n</p>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	《报告》显示，春节期间花灯庙会同比增速94%，展览馆增速94%，祈福地增速47%。西安-大唐芙蓉园成为全国人气最高的花灯庙会。人们赶的不只是热闹，更是体验民俗的美好，感受传统年味。\n</p>\n<div class=\"LazyLoad is-visible\" style=\"margin:0px;padding:0px;font-family:&quot;font-size:18px;\">\n	<p class=\"one-p\">\n		<img class=\"content-picture\" alt=\"\" src=\"https://inews.gtimg.com/newsapp_bt/0/7566165040/1000\" />\n	</p>\n</div>\n<p class=\"one-p\" style=\"font-family:&quot;font-size:18px;\">\n	在品质升级、服务升级的趋势下，国人对年味的定义日趋多元、个性。但比吃什么玩什么更重要的是，和谁吃和谁玩。只要与家人坐在一起，吃什么，怎么吃，去哪里，也都是年味。愿你的2019春节，被美好包围。\n</p>\n<div class=\"article-status\" style=\"margin:0px;padding:20px 0px 50px;font-family:&quot;font-size:18px;\">\n	<div style=\"margin:0px;padding:0px;\">\n	</div>\n	<div class=\"through theend\" style=\"margin:0px auto;padding:0px;text-align:center;font-family:Politica;\">\n		<span style=\"background:#FFFFFF;\">THE END</span>\n	</div>\n</div>', '1', '0', '1', '2019-02-03 12:12:07', '2019-02-03 12:12:07');
INSERT INTO `tb_news` VALUES ('3', '春节过后，宋朝人是怎么发“开工红包”的', '11', 'http://localhost:8080/files/20190212_16543993.jpg', '<img src=\"/files/20190212_16513567.jpg\" alt=\"\" />', '1', '0', '0', '2019-02-12 16:47:25', '2019-02-12 16:47:25');
INSERT INTO `tb_news` VALUES ('4', '《流浪地球》', '11', 'http://localhost:8080/files/20190212_16543993.jpg', '<p class=\"one-p\" style=\"font-family:\" font-size:18px;\"=\"\">xxx\n	</p>', '1', '0', '0', '2019-02-12 16:50:21', '2019-11-28 20:16:51');

-- ----------------------------
-- Table structure for tb_news_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_news_category`;
CREATE TABLE `tb_news_category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类别主键id',
  `category_name` varchar(200) NOT NULL DEFAULT '' COMMENT '类别名称',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已删除 0-未删除 1-已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_news_category
-- ----------------------------
INSERT INTO `tb_news_category` VALUES ('1', '体育', '0', '2019-02-02 21:51:24');
INSERT INTO `tb_news_category` VALUES ('2', '图片', '0', '2019-02-02 21:53:22');
INSERT INTO `tb_news_category` VALUES ('3', '132', '1', '2019-02-02 22:00:37');
INSERT INTO `tb_news_category` VALUES ('4', 'afdspppp', '1', '2019-02-02 22:01:01');
INSERT INTO `tb_news_category` VALUES ('5', 'dfadsf', '1', '2019-02-02 22:01:14');
INSERT INTO `tb_news_category` VALUES ('6', 'o8', '1', '2019-02-02 22:01:30');
INSERT INTO `tb_news_category` VALUES ('7', '视频', '0', '2019-02-12 01:00:13');
INSERT INTO `tb_news_category` VALUES ('8', '军事', '0', '2019-02-12 01:22:41');
INSERT INTO `tb_news_category` VALUES ('9', 'IT', '0', '2019-02-12 01:28:15');
INSERT INTO `tb_news_category` VALUES ('10', '教育', '0', '2019-02-12 01:28:29');
INSERT INTO `tb_news_category` VALUES ('11', '文化', '0', '2019-02-12 01:28:38');
INSERT INTO `tb_news_category` VALUES ('12', '社会', '1', '2019-11-28 20:00:51');
INSERT INTO `tb_news_category` VALUES ('13', 'javaee', '1', '2019-11-28 20:12:49');

-- ----------------------------
-- Table structure for tb_news_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_news_comment`;
CREATE TABLE `tb_news_comment` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论主键id',
  `news_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '关联咨询主键id',
  `commentator` varchar(200) NOT NULL DEFAULT '' COMMENT '评论人',
  `comment_body` varchar(300) NOT NULL DEFAULT '' COMMENT '评论内容',
  `comment_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '评论状态 0-未审核 1-审核通过',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已删除 0-未删除 1-已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_news_comment
-- ----------------------------
INSERT INTO `tb_news_comment` VALUES ('1', '2', 'sdfds', '评论测试', '1', '0', '2019-02-02 22:34:30');
INSERT INTO `tb_news_comment` VALUES ('2', '1', 'fads', '留言测试', '0', '0', '2019-02-03 14:35:42');
