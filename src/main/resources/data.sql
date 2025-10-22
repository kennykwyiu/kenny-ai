-- 匯出 KennyAi 的資料庫結構
DROP DATABASE IF EXISTS `KennyAi`;
CREATE DATABASE IF NOT EXISTS `KennyAi`;
USE `KennyAi`;

-- 匯出 表 KennyAi.course 結構
DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
                                        `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主鍵',
                                        `name` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '學科名稱',
    `edu` int NOT NULL DEFAULT '0' COMMENT '學歷背景要求：0-無，1-初中，2-高中、3-大專、4-本科以上',
    `type` varchar(50) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '課程類型：程式設計、設計、自媒體、其他',
    `price` bigint NOT NULL DEFAULT '0' COMMENT '課程價格',
    `duration` int unsigned NOT NULL DEFAULT '0' COMMENT '學習時長，單位：天',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='學科表';

-- 正在匯出表 KennyAi.course 的資料：~7 rows（大約）
DELETE FROM `course`;
INSERT INTO `course` (`id`, `name`, `edu`, `type`, `price`, `duration`) VALUES
                                                                            (1, 'JavaEE', 4, '程式設計', 21999, 108),
                                                                            (2, '鴻蒙應用開發', 3, '程式設計', 20999, 98),
                                                                            (3, 'AI人工智慧', 4, '程式設計', 24999, 100),
                                                                            (4, 'Python大數據開發', 4, '程式設計', 23999, 102),
                                                                            (5, '跨境電商', 0, '自媒體', 12999, 68),
                                                                            (6, '新媒體營運', 0, '自媒體', 10999, 61),
                                                                            (7, 'UI設計', 2, '設計', 11999, 66);

-- 匯出 表 KennyAi.course_reservation 結構
DROP TABLE IF EXISTS `course_reservation`;
CREATE TABLE IF NOT EXISTS `course_reservation` (
                                                    `id` int NOT NULL AUTO_INCREMENT,
                                                    `course` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '預約課程',
    `student_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '學生姓名',
    `contact_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '聯絡方式',
    `school` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '預約校區',
    `remark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '備註',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 正在匯出表 KennyAi.course_reservation 的資料：~0 rows（大約）
DELETE FROM `course_reservation`;
INSERT INTO `course_reservation` (`id`, `course`, `student_name`, `contact_info`, `school`, `remark`) VALUES
    (1, '新媒體營運', '張三豐', '13899762348', '廣東校區', '安排一個好點的老師');

-- 匯出 表 KennyAi.school 結構
DROP TABLE IF EXISTS `school`;
CREATE TABLE IF NOT EXISTS `school` (
                                        `id` int unsigned NOT NULL AUTO_INCREMENT COMMENT '主鍵',
                                        `name` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '校區名稱',
    `city` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '校區所在城市',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='校區表';

-- 正在匯出表 KennyAi.school 的資料：~0 rows（大約）
DELETE FROM `school`;
INSERT INTO `school` (`id`, `name`, `city`) VALUES
                                                (1, '昌平校區', '北京'),
                                                (2, '順義校區', '北京'),
                                                (3, '杭州校區', '杭州'),
                                                (4, '上海校區', '上海'),
                                                (5, '南京校區', '南京'),
                                                (6, '西安全校區', '西安'); -- 如果不需要「全」，請改回 '西安校區'
INSERT INTO `school` (`id`, `name`, `city`) VALUES
                                                (7, '鄭州校區', '鄭州'),
                                                (8, '廣東校區', '廣東'),
                                                (9, '深圳校區', '深圳');