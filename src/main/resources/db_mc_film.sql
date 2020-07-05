/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : db_mc_film

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 05/07/2020 22:27:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mc_film
-- ----------------------------
DROP TABLE IF EXISTS `mc_film`;
CREATE TABLE `mc_film`  (
  `uid` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '电影 id',
  `film_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '影片 原名',
  `film_chi_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '影片 中文名',
  `film_release_date` date NOT NULL COMMENT '影片 上映日期',
  `film_duration` int(11) NOT NULL COMMENT '影片 时长',
  `film_imdb` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '影片 imdb 编号',
  `film_douban` float(3, 1) NULL DEFAULT NULL COMMENT '影片 豆瓣评分',
  `film_introduce` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '影片 介绍',
  `film_country_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '影片 国家 id',
  `film_language_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '影片 语言 id',
  `film_type_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '影片 类型 id',
  `film_poster_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '影片 海报链接 uid',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mc_film
-- ----------------------------
INSERT INTO `mc_film` VALUES ('1278342168301391873', '泣きたい私は猫をかぶる', '想哭的我戴上了猫', '2020-06-28', 104, 'tt123456', 6.5, '绰号“无限”的少女美代（志田未来 配音）从不掩饰对少年日之出（花江夏树 配音）的好感，她在一次祭典上获得了可以变成猫的面具，并以此来接近日之出。随着交流的深入，美代越来越陷入作为猫与日之出接触的状态，并最终无法变回人类，而此时，日之出也发现了自己对于美代的感情，他发现真相后，展开了帮助美代从猫变回人类的冒险……', '22222222-5255-41A7-BAC3-1345790A3153', '7777', '4444', '', NULL, NULL);
INSERT INTO `mc_film` VALUES ('1278342290334666754', '泣きたい', '想哭', '2020-06-27', 104, 'tt123456', 6.5, '绰号“无限”的少女美代（志田未来 配音）从不掩饰对少年日之出（花江夏树 配音）的好感，她在一次祭典上获得了可以变成猫的面具，并以此来接近日之出。随着交流的深入，美代越来越陷入作为猫与日之出接触的状态，并最终无法变回人类，而此时，日之出也发现了自己对于美代的感情，他发现真相后，展开了帮助美代从猫变回人类的冒险……', 'E41A1307-C1A7-4AF6-9AAA-0BBE98DB5188', '45678912-5255-41A7-BAC3-1345790A3152', '4444', '', NULL, NULL);
INSERT INTO `mc_film` VALUES ('3ACCBFF6-8461-410D-8A91-E1206CA3E3AA', '海獣の子供', '海兽之子', '2020-06-28', 111, 'tt9850064', 6.6, '偶遇到神秘少年“海”（石桥阳彩配）和“空”（浦上晟周配）的这个炎炎夏天，是琉花（芦田爱菜配）暑期的正式开始。天真无邪的“海”，看透一切的“空”，海洋馆里发光的鱼群，对琉花来说都像是一场浪漫的约定如期而至。', 'E41A1307-C1A7-4AF6-9AAA-0BBE98DB5188', '7777', '4444', '', NULL, NULL);
INSERT INTO `mc_film` VALUES ('3FA6EF11-D11A-4070-A86A-D5FA35A868EE', '小可爱', '陈可', '1999-01-31', 18, 'tt1314', 10.0, '温柔可爱善良大方贤惠', '22222222-5255-41A7-BAC3-1345790A3153', '66666666-5255-41A7-BAC3-1345790A3152', '60E9B837-5255-41A7-BAC3-1345790A3152', '', NULL, NULL);
INSERT INTO `mc_film` VALUES ('41382390-18E0-49C2-9FF3-6DA37EA7BF46', '泣きたい', '想哭', '2020-06-28', 104, 'tt123456', 6.5, '绰号“无限”的少女美代（志田未来 配音）从不掩饰对少年日之出（花江夏树 配音）的好感，她在一次祭典上获得了可以变成猫的面具，并以此来接近日之出。随着交流的深入，美代越来越陷入作为猫与日之出接触的状态，并最终无法变回人类，而此时，日之出也发现了自己对于美代的感情，他发现真相后，展开了帮助美代从猫变回人类的冒险……', '3333', '45678912-5255-41A7-BAC3-1345790A3152', '4444', '', NULL, NULL);
INSERT INTO `mc_film` VALUES ('68FDB902-AA7E-4B0D-9792-746901E3B01F', 'santi', '三体', '2020-06-26', 123, 'tt1234', 6.4, '这是一个借鉴', '44444444-5255-41A7-BAC3-1345790A3152', '66666666-5255-41A7-BAC3-1345790A3152', '7779B837-5255-41A7-BAC3-1345790A3152', '', '2020-07-02 21:47:02', NULL);
INSERT INTO `mc_film` VALUES ('A5FFE4F6-6794-4712-858F-1DCD0701A250', 'your name', '你的名字', '2016-04-03', 120, 'tt456789', 6.8, '这是一部新海诚的电影', '3333', '7777', '4444', '', NULL, NULL);
INSERT INTO `mc_film` VALUES ('AACDA429-DB46-48FA-B153-D444DA93E45B', 'avenger', '复仇者', '2020-07-10', 130, 'tt1134564', 0.0, 'qwerqwrqwrwq', '44444444-5255-41A7-BAC3-1345790A3152', '45678912-5255-41A7-BAC3-1345790A3152', '6DE9B837-5255-41A7-BAC3-1345790A3152', '', NULL, NULL);
INSERT INTO `mc_film` VALUES ('C81236EE-46B7-4CF0-B7D2-7BEDA074C8DF', '少年的你', '', '2020-06-28', 135, 'tt9586294', 8.3, '陈念（周冬雨 饰）是一名即将参加高考的高三学生，同校女生胡晓蝶（张艺凡 饰）的跳楼自杀让她的生活陷入了困顿之中。胡晓蝶死后，陈念遭到了以魏莱（周也 饰）为首的三人组的霸凌，魏莱虽然表面上看来是乖巧的优等生，实际上却心思毒辣，胡晓蝶的死和她有着千丝万缕的联系。\n　　一次偶然中，陈念邂逅了名为小北（易烊千玺 饰）的小混混，随着时间的推移，心心相惜的两人之间产生了真挚的感情。小北答应陈念在暗中保护她免受魏莱的欺凌，没想到这一决定引发了一连串的连锁反应。负责调查胡晓蝶死因的警官郑易（尹昉 饰）隐隐察觉到校园里的古怪气氛，可他的调查却屡屡遭到校方的阻挠。', '22222222-5255-41A7-BAC3-1345790A3153', '66666666-5255-41A7-BAC3-1345790A3152', '60E9B837-5255-41A7-BAC3-1345790A3152', '', NULL, NULL);
INSERT INTO `mc_film` VALUES ('DED6AC73-4BAB-4958-98F1-687DB845215D', 'We Bare Bears: The Movie', '咱们裸熊：电影版', '2020-06-28', 69, 'tt10474606', 7.6, '三藩湾区的日常，竟成为熊熊们“犯罪”的证据，\n　　熊熊们只好踏上一场艰难的隐藏熊类身份的冒险。\n　　灰灰能否找到熊弟的新居？白熊能否活出清“白”？\n　　胖达能否找出以前笑话它的女孩子们所在的群聊？\n　　动作片元素亦有体现，无论是追逐戏和封闭空间，\n　　还是与大脚怪查理的碰面，无不深入人心……\n　　CN出品，万众瞩目的神剧新篇，多刷也值得！', '44444444-5255-41A7-BAC3-1345790A3152', '45678912-5255-41A7-BAC3-1345790A3152', '4444', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for mc_film_country
-- ----------------------------
DROP TABLE IF EXISTS `mc_film_country`;
CREATE TABLE `mc_film_country`  (
  `uid` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `film_country` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '国家/地区',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `country`(`film_country`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mc_film_country
-- ----------------------------
INSERT INTO `mc_film_country` VALUES ('22222222-5255-41A7-BAC3-1345790A3153', '中国', '2020-07-05 21:04:20', '2020-07-05 21:04:21');
INSERT INTO `mc_film_country` VALUES ('44444444-5255-41A7-BAC3-1345790A3152', '美国', NULL, NULL);
INSERT INTO `mc_film_country` VALUES ('55555555-5255-41A7-BAC3-1345790A3152', '韩国', NULL, NULL);
INSERT INTO `mc_film_country` VALUES ('5CA22EA7-38B1-448E-A910-8612FC8CF697', '泰国', NULL, NULL);
INSERT INTO `mc_film_country` VALUES ('6DABA6FB-5C5F-4AEB-B824-B4B5698E9850', '日本', '2020-07-05 21:04:32', NULL);
INSERT INTO `mc_film_country` VALUES ('8B29278C-6ED7-4D97-98FD-83A5D5474624', '印度', NULL, NULL);

-- ----------------------------
-- Table structure for mc_film_language
-- ----------------------------
DROP TABLE IF EXISTS `mc_film_language`;
CREATE TABLE `mc_film_language`  (
  `uid` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `film_language` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mc_film_language
-- ----------------------------
INSERT INTO `mc_film_language` VALUES ('45678912-5255-41A7-BAC3-1345790A3152', '英语', NULL, NULL);
INSERT INTO `mc_film_language` VALUES ('66666666-5255-41A7-BAC3-1345790A3152', '汉语', NULL, NULL);
INSERT INTO `mc_film_language` VALUES ('7777', '日语', NULL, NULL);
INSERT INTO `mc_film_language` VALUES ('7DE9B837-5555-41A7-BAC3-1345790A3152', '韩语', NULL, NULL);

-- ----------------------------
-- Table structure for mc_film_poster
-- ----------------------------
DROP TABLE IF EXISTS `mc_film_poster`;
CREATE TABLE `mc_film_poster`  (
  `uid` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `poster_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '海报名称',
  `poster_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '海报 url',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mc_film_poster
-- ----------------------------
INSERT INTO `mc_film_poster` VALUES ('7DE9B837-5255-41A7-BAC3-1345790B3183', '天气之子', 'https://img9.doubanio.com/view/photo/l/public/p2566595195.webp', '2020-06-30 13:58:29', NULL);

-- ----------------------------
-- Table structure for mc_film_torrent
-- ----------------------------
DROP TABLE IF EXISTS `mc_film_torrent`;
CREATE TABLE `mc_film_torrent`  (
  `uid` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '磁力uid',
  `torrent_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '种子名称',
  `torrent_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '种子url',
  `torrent_magnet` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '磁力链接',
  `film_id` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电影id',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mc_film_torrent
-- ----------------------------
INSERT INTO `mc_film_torrent` VALUES ('12345468-5255-41A7-BAC3-1345790A315280', 'avengers.endgame.2019.2160p.bluray.x265.10bit.sdr.dts-hd.ma.truehd.7.1.atmos-swtyblz.torrent', 'http://locaclhost:8080/', 'magreihkdnksfkdlsjfkldsf', '1278342168301391873', '2020-06-30 11:29:11', '2020-07-05 21:05:58');
INSERT INTO `mc_film_torrent` VALUES ('ABCDABCD-5255-41A7-BAC3-1345790A315280', 'godzilla.king.of.the.monsters.2019.2160p.bluray.x265.10bit.sdr.dts-hd.ma.truehd.7.1.atmos-swtyblz', 'http://', 'magnet:?xt=urn:btih:a7c18ffc0a6a87a426f9eeac99f4c57582c16061', '1278342290334666754', '2020-06-30 11:29:17', NULL);

-- ----------------------------
-- Table structure for mc_film_type
-- ----------------------------
DROP TABLE IF EXISTS `mc_film_type`;
CREATE TABLE `mc_film_type`  (
  `uid` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `film_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of mc_film_type
-- ----------------------------
INSERT INTO `mc_film_type` VALUES ('4444', '动画', NULL, NULL);
INSERT INTO `mc_film_type` VALUES ('50E9B837-5255-41A7-BAC3-1345790A3152', '恐怖', NULL, NULL);
INSERT INTO `mc_film_type` VALUES ('60E9B837-5255-41A7-BAC3-1345790A3152', '爱情', NULL, NULL);
INSERT INTO `mc_film_type` VALUES ('6DE9B837-5255-41A7-BAC3-1345790A3152', '科幻', NULL, NULL);
INSERT INTO `mc_film_type` VALUES ('7779B837-5255-41A7-BAC3-1345790A3152', '科幻', NULL, NULL);
INSERT INTO `mc_film_type` VALUES ('7DE91237-5255-41A7-BAC3-1345790A3152', '剧场版', NULL, NULL);
INSERT INTO `mc_film_type` VALUES ('7DE9B837-5255-41A7-BAC3-1345790A3152', '惊悚', NULL, NULL);

-- ----------------------------
-- Table structure for mc_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `mc_sys_user`;
CREATE TABLE `mc_sys_user`  (
  `uid` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '管理员id',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nickname` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '昵称',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '介绍',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`uid`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mc_sys_user
-- ----------------------------
INSERT INTO `mc_sys_user` VALUES ('00000000-0000-0000-0000-000000000000', 'admin', '21232f297a57a5a743894a0e4a801fc3', '程浦江', 'http://5b0988e595225.cdn.sohucs.com/q_70,c_zoom,w_640/images/20190101/3f15616528194351992b5beb1af64050.jpeg', '我是一个程序员', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
