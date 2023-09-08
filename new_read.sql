/*
 Navicat Premium Data Transfer

 Source Server         : score
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : new_read

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 08/09/2023 10:56:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for browse
-- ----------------------------
DROP TABLE IF EXISTS `browse`;
CREATE TABLE `browse`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(0) NOT NULL COMMENT '人员id',
  `essay_id` int(0) NOT NULL COMMENT '文宝id',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '浏览时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 66 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of browse
-- ----------------------------
INSERT INTO `browse` VALUES (1, 4, 1, '2023-07-30 12:31:12');
INSERT INTO `browse` VALUES (2, 4, 1, '2023-07-30 12:31:41');
INSERT INTO `browse` VALUES (3, 4, 1, '2023-07-30 12:31:47');
INSERT INTO `browse` VALUES (4, 4, 1, '2023-07-30 13:49:21');
INSERT INTO `browse` VALUES (5, 4, 1, '2023-07-30 13:49:33');
INSERT INTO `browse` VALUES (6, 4, 1, '2023-07-30 13:49:54');
INSERT INTO `browse` VALUES (7, 4, 1, '2023-07-30 13:53:25');
INSERT INTO `browse` VALUES (8, 4, 1, '2023-07-30 13:55:42');
INSERT INTO `browse` VALUES (9, 4, 1, '2023-07-30 13:55:47');
INSERT INTO `browse` VALUES (10, 4, 1, '2023-07-30 14:28:14');
INSERT INTO `browse` VALUES (11, 4, 1, '2023-07-30 14:29:03');
INSERT INTO `browse` VALUES (12, 4, 1, '2023-07-30 14:29:14');
INSERT INTO `browse` VALUES (13, 4, 1, '2023-07-30 14:29:19');
INSERT INTO `browse` VALUES (14, 4, 1, '2023-07-30 14:33:00');
INSERT INTO `browse` VALUES (15, 4, 1, '2023-07-30 14:33:04');
INSERT INTO `browse` VALUES (16, 4, 1, '2023-07-30 17:14:12');
INSERT INTO `browse` VALUES (17, 4, 1, '2023-07-30 17:15:37');
INSERT INTO `browse` VALUES (18, 4, 4, '2023-07-30 18:39:38');
INSERT INTO `browse` VALUES (19, 4, 4, '2023-07-30 18:42:48');
INSERT INTO `browse` VALUES (20, 4, 4, '2023-07-30 18:43:11');
INSERT INTO `browse` VALUES (21, 4, 4, '2023-07-30 18:52:52');
INSERT INTO `browse` VALUES (22, 4, 2, '2023-07-30 19:07:58');
INSERT INTO `browse` VALUES (23, 4, 3, '2023-07-30 19:08:27');
INSERT INTO `browse` VALUES (24, 4, 4, '2023-07-30 19:36:25');
INSERT INTO `browse` VALUES (25, 4, 4, '2023-07-30 22:21:49');
INSERT INTO `browse` VALUES (26, 4, 5, '2023-07-31 12:17:23');
INSERT INTO `browse` VALUES (27, 4, 5, '2023-07-31 12:17:45');
INSERT INTO `browse` VALUES (28, 4, 5, '2023-07-31 12:19:47');
INSERT INTO `browse` VALUES (29, 4, 5, '2023-07-31 12:26:12');
INSERT INTO `browse` VALUES (30, 4, 6, '2023-07-31 13:13:01');
INSERT INTO `browse` VALUES (31, 4, 7, '2023-07-31 13:53:17');
INSERT INTO `browse` VALUES (32, 4, 7, '2023-07-31 14:12:07');
INSERT INTO `browse` VALUES (33, 4, 7, '2023-07-31 14:12:09');
INSERT INTO `browse` VALUES (34, 4, 7, '2023-07-31 14:12:32');
INSERT INTO `browse` VALUES (35, 4, 7, '2023-07-31 14:13:02');
INSERT INTO `browse` VALUES (42, 1, 8, '2023-08-04 11:48:01');
INSERT INTO `browse` VALUES (43, 4, 8, '2023-08-04 11:48:31');
INSERT INTO `browse` VALUES (44, 4, 8, '2023-08-04 11:49:03');
INSERT INTO `browse` VALUES (47, 1, 2, '2023-08-04 16:09:16');
INSERT INTO `browse` VALUES (48, 1, 2, '2023-08-04 17:33:45');
INSERT INTO `browse` VALUES (49, 1, 2, '2023-08-04 17:33:52');
INSERT INTO `browse` VALUES (50, 1, 2, '2023-08-04 18:18:16');
INSERT INTO `browse` VALUES (51, 1, 7, '2023-08-04 18:27:13');
INSERT INTO `browse` VALUES (52, 1, 8, '2023-08-14 16:05:21');
INSERT INTO `browse` VALUES (53, 4, 7, '2023-08-26 19:43:14');
INSERT INTO `browse` VALUES (54, 1, 2, '2023-08-26 20:28:07');
INSERT INTO `browse` VALUES (55, 1, 7, '2023-08-26 20:32:36');
INSERT INTO `browse` VALUES (56, 1, 9, '2023-08-26 20:44:49');
INSERT INTO `browse` VALUES (57, 1, 8, '2023-08-26 21:03:34');
INSERT INTO `browse` VALUES (58, 4, 7, '2023-08-27 13:39:17');
INSERT INTO `browse` VALUES (59, 4, 7, '2023-08-27 13:40:35');
INSERT INTO `browse` VALUES (60, 4, 7, '2023-08-27 13:46:48');
INSERT INTO `browse` VALUES (61, 4, 7, '2023-08-28 14:56:03');
INSERT INTO `browse` VALUES (62, 1, 9, '2023-08-28 14:56:28');
INSERT INTO `browse` VALUES (63, 1, 8, '2023-08-28 14:56:36');
INSERT INTO `browse` VALUES (64, 1, 8, '2023-08-28 14:57:51');
INSERT INTO `browse` VALUES (65, 1, 9, '2023-08-28 16:42:15');
INSERT INTO `browse` VALUES (66, 1, 7, '2023-08-30 16:03:21');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `user_id` int(0) NOT NULL COMMENT '人员id',
  `essay_id` int(0) NOT NULL COMMENT '文宝Id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '评论内容',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  `status` int(0) NULL DEFAULT NULL COMMENT '状态    ',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1, 4, 1, '评论内容', '2023-07-28 10:49:06', 1);
INSERT INTO `comment` VALUES (2, 1, 1, 'Ant Design, a design language for background applications, is refined by Ant UED Team', '2023-06-14 12:14:51', 1);
INSERT INTO `comment` VALUES (3, 2, 1, '1双方都', '2023-01-24 11:22:32', 1);
INSERT INTO `comment` VALUES (4, 4, 1, '发的事实上事实上事实上是撒是撒是撒是撒是撒是撒是撒是撒是撒是撒飒飒飒', '2023-07-28 17:02:27', NULL);
INSERT INTO `comment` VALUES (5, 4, 7, '确实不错！！！', '2023-07-31 14:12:31', 1);
INSERT INTO `comment` VALUES (6, 1, 8, '美的一匹', '2023-08-04 10:43:48', 1);
INSERT INTO `comment` VALUES (7, 1, 8, '666666', '2023-08-04 10:43:58', 1);
INSERT INTO `comment` VALUES (8, 1, 8, '不错,已收藏', '2023-08-04 11:48:01', 1);
INSERT INTO `comment` VALUES (9, 4, 8, '加油!效果会越来越好', '2023-08-04 11:49:03', 1);

-- ----------------------------
-- Table structure for friend
-- ----------------------------
DROP TABLE IF EXISTS `friend`;
CREATE TABLE `friend`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '关注ID',
  `user_id` int(0) NOT NULL COMMENT '人员Id',
  `friend_id` int(0) NOT NULL COMMENT '好友ID',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '关注时间',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态  //1关注   2删除  3拉黑',
  `status_time` datetime(0) NULL DEFAULT NULL COMMENT '状态变更时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of friend
-- ----------------------------
INSERT INTO `friend` VALUES (1, 1, 2, '2023-08-04 13:45:48', '-1', '2023-08-30 15:35:36');
INSERT INTO `friend` VALUES (2, 4, 1, '2023-07-29 11:16:05', '1', '2023-07-29 11:16:05');

-- ----------------------------
-- Table structure for publish
-- ----------------------------
DROP TABLE IF EXISTS `publish`;
CREATE TABLE `publish`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标题',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '描述',
  `img` varchar(2555) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图片',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '内容',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  `user_id` int(0) NOT NULL COMMENT '人员ID',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of publish
-- ----------------------------
INSERT INTO `publish` VALUES (2, '美好生活,从文玩开始', '美美哒', 'http://localhost:8866/upload/1691115928265.jpeg', '紫金鼠是一种稀有的菩提，皇后葵（金山葵）的果实种子，我国的福建，两广，海南均有产，此树为外来品种，热带风景树。\n紫金鼠经过盘玩后容易变色包浆呈现颜色紫中泛红，红中带金。紫金鼠在佛教通常作为念珠使用，藏传佛教中的财神就是以手抓紫金鼠的形象而出现的。因此传统认为，紫金鼠可以招来财富，故而紫金鼠又名招财鼠，有着招财进宝的美好寓意。', '2023-08-04 10:42:59', 2, NULL);
INSERT INTO `publish` VALUES (7, '保养常识', '一些简单的保养知识', 'http://localhost:8866/upload/1690781028670.webp', ' 第一 、一定要带着洗澡，洗澡水和各种化学品对文玩特别有好处。\n            洗完之后清清爽爽，干干净净，仿佛焕发了新的生命。\n\n第二、大冬天从外面回家，一定要佩戴着进暖气房，尤其是橄榄核这种东西一定要经历一冷一热。这样你才能体会什么叫真金不怕火炼。\n\n第三、大汗手不怕直接上手，尤其是木头特别喜汗，脸上，鼻子上那些油啊，汗啊，敞开了蹭上包浆特别快，\n\n第四、颗宝石都不怕磕磕碰碰，跟你们讲宝石的硬度特别高，铁锤的锤不坏，佩戴个珠宝就不能下厨房了吗？惯的毛病。\n\n第五、记得要随处摆放，丢就丢了千金散尽还复来，时刻换新才能有新鲜感。\n\n大家一定要记住文玩嘛，想怎么玩就怎么玩，花自己的钱难道还要别人来教我吗？你会怎么对待自己的文玩了？把你的盘玩心得在评论区分享一下，让大家相互学习一下。', '2023-07-31 13:53:08', 4, NULL);
INSERT INTO `publish` VALUES (8, '这种小众的文玩你玩过么', '紫金鼠盘玩效果还是不错的--招财~招财~~~', 'http://localhost:8866/upload/1691115928265.jpeg', '紫金鼠是一种稀有的菩提，皇后葵（金山葵）的果实种子，我国的福建，两广，海南均有产，此树为外来品种，热带风景树。\n紫金鼠经过盘玩后容易变色包浆呈现颜色紫中泛红，红中带金。紫金鼠在佛教通常作为念珠使用，藏传佛教中的财神就是以手抓紫金鼠的形象而出现的。因此传统认为，紫金鼠可以招来财富，故而紫金鼠又名招财鼠，有着招财进宝的美好寓意。', '2023-08-04 10:27:19', 1, NULL);
INSERT INTO `publish` VALUES (9, '噢噢!努力!小核桃!奥利给~~~', '盘玩一个月,看看我玩的怎么样', 'http://localhost:8866/upload/1691116065374.jpeg', '先刷再戴手套盘,一个星期左右,然后才上手.\n感觉还是不错的', '2023-08-04 10:41:48', 1, NULL);
INSERT INTO `publish` VALUES (10, '美图秀秀,哈哈哈', '没毛病', 'http://localhost:8866/upload/1691116943788.jpeg,http://localhost:8866/upload/1691116954677.jpeg', '就是这么666', '2023-08-04 10:42:59', 1, NULL);

-- ----------------------------
-- Table structure for publish_details
-- ----------------------------
DROP TABLE IF EXISTS `publish_details`;
CREATE TABLE `publish_details`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(0) NOT NULL COMMENT '人员Id',
  `essay_id` int(0) NOT NULL COMMENT '文章ID',
  `like_time` datetime(0) NULL DEFAULT NULL COMMENT '点赞时间',
  `is_like` int(0) NULL DEFAULT NULL COMMENT '是否点赞',
  `is_collect` int(0) NULL DEFAULT NULL COMMENT '是否收藏',
  `collect_time` datetime(0) NULL DEFAULT NULL COMMENT '收藏时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of publish_details
-- ----------------------------
INSERT INTO `publish_details` VALUES (1, 4, 1, '2023-07-28 16:51:38', 1, 1, '2023-07-28 10:09:59');
INSERT INTO `publish_details` VALUES (10, 4, 7, '2023-07-31 14:12:09', 1, NULL, NULL);
INSERT INTO `publish_details` VALUES (11, 1, 8, '2023-08-04 10:43:27', 1, 1, '2023-08-04 10:43:26');
INSERT INTO `publish_details` VALUES (12, 1, 2, '2023-08-04 17:33:52', 1, NULL, NULL);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名称',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `login_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '登录账号',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '性别',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '个性签名',
  `rules` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '管理员Admin', '123456', 'admin', '616439834@qq.com', '13100000011', '男', 'https://randomuser.me/api/portraits/men/54.jpg', '我的管理员,有事请联系', 'admin', NULL, '1');
INSERT INTO `user` VALUES (2, 'Fagerland', '123qwe', '222222', '616439834@qq.com', '13200000002', '女', 'https://randomuser.me/api/portraits/women/36.jpg', '溜达溜达', NULL, NULL, '-1');
INSERT INTO `user` VALUES (4, '郭123', '123qwe', '123456', '616439834@qq.com', '13100010001', '男', 'https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png', '哦哦哦', NULL, NULL, '1');

SET FOREIGN_KEY_CHECKS = 1;
