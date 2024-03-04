/*
 Navicat Premium Data Transfer

 Source Server         : aoyu-mysql
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : software_library

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 03/12/2023 19:59:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `category_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类名称',
  `category_alias` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分类别名',
  `create_user` int UNSIGNED NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_category_user`(`create_user` ASC) USING BTREE,
  CONSTRAINT `fk_category_user` FOREIGN KEY (`create_user`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (4, 'fd', 'fd', 6, '2023-11-22 20:32:13', '2023-11-22 20:32:13');
INSERT INTO `category` VALUES (6, 'fd', 'fd', 5, '2023-11-23 17:44:30', '2023-11-23 17:44:30');
INSERT INTO `category` VALUES (7, '编程', 'code', 5, '2023-11-27 12:19:05', '2023-11-27 12:19:05');

-- ----------------------------
-- Table structure for software
-- ----------------------------
DROP TABLE IF EXISTS `software`;
CREATE TABLE `software`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '软件ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '软件名称',
  `size` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '软件大小',
  `version` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '软件版本',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NOT NULL COMMENT '添加时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  `category_id` int UNSIGNED NULL DEFAULT NULL COMMENT '关联的分类ID',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '软件状态',
  `download_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_software_category`(`category_id` ASC) USING BTREE,
  CONSTRAINT `fk_software_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of software
-- ----------------------------
INSERT INTO `software` VALUES (2, '个同约日形', '10m', 'Excepteur occaecat nisi commodo', '更步小长干还东出族设技身话见。权准快林住形格第关住儿人用器可结四。相于住天标指法须局验收本化学今太。单团规空达说统五生特己响系指它白离。京消动公或近步五太最身目口数表压。候转查问感战划说者切较领属得年住代。', 'http://dummyimage.com/100x100', '2023-11-23 15:27:53', '2023-11-23 15:27:53', 4, 'Lorem magna in aute', 'http://zxb.uy/cidulwpmm');
INSERT INTO `software` VALUES (3, '么厂应命农地根', '234', 'laborum', '观格加称万持不照须品两基和派前。还金头图众计列使天多政海华百算观。支线活公计标展半候切选发度完组家。', 'http://dummyimage.com/100x1qqq00', '2023-11-23 15:29:22', '2023-11-23 15:29:22', NULL, 'no', 'http://hlailmgj.as/meuu');
INSERT INTO `software` VALUES (4, '装转一素', '100MB', '1.2.1', '程从将铁且二史代据压体单群条总总维。种色重革去化经自土特观必约目至并由。院地题定五阶支越出出阶满难形。南回因化段按再了七关而志之书前制。', 'http://dummyimage.com/100x100', '2023-11-23 17:40:18', '2023-11-23 17:40:18', 6, '未破解', 'http://kdecurumv.wf/rgmqf');
INSERT INTO `software` VALUES (5, '出政比院', '100MB', '1.3.1', '强线理对米指北会农对对而社历花先。素思相当龙论难样斯火业按。术指团院布三下火细据别门化进便。二道做面收属离设己物十八。', 'http://dummyimage.com/100x100', '2023-11-23 17:40:26', '2023-11-23 17:40:26', 4, '已破解', 'http://rahbulfij.ug/cplxg');
INSERT INTO `software` VALUES (6, '出政比院', '100MB', '1.3.1', '强线理对米指北会农对对而社历花先。素思相当龙论难样斯火业按。术指团院布三下火细据别门化进便。二道做面收属离设己物十八。', 'http://dummyimage.com/100x100', '2023-11-23 17:41:21', '2023-11-23 17:41:21', 4, '已破解', 'http://rahbulfij.ug/cplxg');
INSERT INTO `software` VALUES (7, '出政比院', '100MB', '1.3.1', '强线理对米指北会农对对而社历花先。素思相当龙论难样斯火业按。术指团院布三下火细据别门化进便。二道做面收属离设己物十八。', 'http://dummyimage.com/100x100', '2023-11-23 18:07:17', '2023-11-23 18:07:17', 4, '已破解', 'http://rahbulfij.ug/cplxg');
INSERT INTO `software` VALUES (8, 'chrome', '107MB', '1.7.0', '根工品八生儿所十时公条深里当。事治统物何准元西提过内况效。可东因国统近物己五节养过口角段合。反路对发线空料下业内采结。强由品计立那问院满济队说部在过复。写图计交果经高动研压重确克。', 'http://dummyimage.com/100x100', '2023-11-23 18:07:57', '2023-11-23 18:07:57', 7, '免费', 'http://ctpwywdn.br/gfurtogo');
INSERT INTO `software` VALUES (9, '出政比院', '100MB', '1.3.1', '强线理对米指北会农对对而社历花先。素思相当龙论难样斯火业按。术指团院布三下火细据别门化进便。二道做面收属离设己物十八。', 'http://dummyimage.com/100x100', '2023-11-23 18:13:03', '2023-11-23 18:13:03', 4, '已破解', 'http://rahbulfij.ug/cplxg');
INSERT INTO `software` VALUES (10, '属么要划', '107MB', '1.7.0', '根工品八生儿所十时公条深里当。事治统物何准元西提过内况效。可东因国统近物己五节养过口角段合。反路对发线空料下业内采结。强由品计立那问院满济队说部在过复。写图计交果经高动研压重确克。', 'http://dummyimage.com/100x100', '2023-11-23 18:13:27', '2023-11-23 18:13:27', 7, '免费', 'http://ctpwywdn.br/gfurtogo');
INSERT INTO `software` VALUES (11, 'apifox', '107MB', '1.8.0', '根工品八生儿所十时公条深里当。事治统物何准元西提过内况效。可东因国统近物己五节养过口角段合。反路对发线空料下业内采结。强由品计立那问院满济队说部在过复。写图计交果经高动研压重确克。', 'http://dummyimage.com/100x100', '2023-11-26 23:27:05', '2023-11-26 23:27:05', 7, '免费', 'http://rahbulfij.ug/cplxg');
INSERT INTO `software` VALUES (12, '出政fdsf比院', '100MB', '1.3.1', '强线理对米指北会农对对而社历花先。素思相当龙论难样斯火业按。术指团院布三下火细据别门化进便。二道做面收属离设己物十八。', 'http://dummyimage.com/100x100', '2023-11-27 12:33:40', '2023-11-27 12:33:40', 4, '已破解', 'http://rahbulfij.ug/cplxg');
INSERT INTO `software` VALUES (13, 'clash', '100MB', '1.3.1', '强线理对米指北会农对对而社历花先。素思相当龙论难样斯火业按。术指团院布三下火细据别门化进便。二道做面收属离设己物十八。', 'http://dummyimage.com/100x100', '2023-11-27 12:34:01', '2023-11-27 12:34:01', 4, '免费', 'http://rahbulfij.ug/cplxg');
INSERT INTO `software` VALUES (14, 'idea', '17MB', '1.3.1', '根工品八生儿所十时公条深里当。事治统物何准元西提过内况效。可东因国统近物己五节养过口角段合。反路对发线空料下业内采结。强由品计立那问院满济队说部在过复。写图计交果经高动研压重确克。', 'http://dummyimage.com/100x100', '2023-11-27 12:37:18', '2023-11-27 12:37:18', 4, '免费', 'http://fdsfsffffffffffff.br/gfurtogo');
INSERT INTO `software` VALUES (15, 'pycharm', '100MB', '1.3.1', '', '', '2023-11-27 12:51:37', '2023-11-27 12:51:37', 4, '已破解', '');
INSERT INTO `software` VALUES (16, 'pycharm', '100MB', '1.3.1', NULL, '', '2023-11-27 12:59:24', '2023-11-27 12:59:24', 4, '已破解', '');
INSERT INTO `software` VALUES (17, 'pycharm', '100MB', '1.3.1', NULL, '', '2023-11-27 13:01:03', '2023-11-27 13:01:03', 4, '已破解', '');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `nickname` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '昵称',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `user_pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (4, 'wjfsdkfk', '$2a$10$/A5B1v3cygX3Oglsr6WllOr5q/BIRxPNF9r1ciANpAqawd7DRhL5K', NULL, NULL, NULL, '2023-11-15 20:45:59', '2023-11-15 20:45:59');
INSERT INTO `user` VALUES (5, 'aoyu', '$2a$10$UitRAG9rglsb1VhnYDXu8.Djd3bigpwMskD3RrD3IqZ5pgxst9CxS', 'admin', 'aoyu3399@gmail.com', 'http://fdshjfsj.con', '2023-11-15 21:28:51', '2023-11-27 16:48:09');
INSERT INTO `user` VALUES (6, 'user01', '$2a$10$dOpdOcuNyA/RaktKRGbUi.IyKK3uTHsT174ly2MKTgxTkBFISFQ9.', NULL, NULL, NULL, '2023-11-20 16:55:09', '2023-11-20 16:55:09');
INSERT INTO `user` VALUES (7, 'user2', '$2a$10$ZvJv1WcEsgDAHSMy7VuVHOxWOc2c3f80t0ay6rtCsVF1I8llrZ7UW', NULL, NULL, NULL, '2023-11-22 20:23:30', '2023-11-22 20:23:30');
INSERT INTO `user` VALUES (8, 'user3', '$2a$10$8TIXVCQ8y6FwmOP/HrgICO5RbAyqliTBdnrVwU3AvLCyUBjMqp7xK', NULL, NULL, NULL, '2023-11-22 20:36:02', '2023-11-22 20:36:02');
INSERT INTO `user` VALUES (10, 'user4', '$2a$10$noevAURONbzrva64Kf3s8u9iPXq5R4ySHUXytYexgRDhbUUWfpVQa', NULL, NULL, NULL, '2023-11-26 23:21:31', '2023-11-26 23:21:31');
INSERT INTO `user` VALUES (11, 'user5', '$2a$10$vJ7aTd6YerpfPNdgbSEBW.ayxLNLnh1yTEFDZB/k9bQQtFCA1AqbS', NULL, NULL, NULL, '2023-11-27 14:50:20', '2023-11-27 14:50:20');

SET FOREIGN_KEY_CHECKS = 1;
