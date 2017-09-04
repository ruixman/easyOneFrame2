INSERT INTO `new_frame`.`t_sys_dept_info` (`id`, `create_time`, `creater_id`, `creater_name`, `dept_code`, `flag`, `name`, `p_id`, `update_time`, `updater_id`, `updater_name`)
 VALUES ('1', '2017-09-04 09:40:51', '01', '01', '001', '1', '总公司', 'root', '2017-09-04 09:41:27', '1', '1');

INSERT INTO `new_frame`.`t_sys_user_info` (`uid`, `login_name`, `mobile`, `name`, `password`, `sex`, `state`, `dept_id`)
VALUES ('1', '1', '1', '1', '123', '男', '0', '1');

INSERT INTO `new_frame`.`t_sys_user_info` (`uid`, `login_name`, `mobile`, `name`, `password`, `sex`, `state`, `dept_id`)
VALUES ('2', 'admin', '1', '1', '123', '男', '0', '1');

INSERT INTO `t_Sys_Role` VALUES ('1', '1', '管理员', 'admin');
INSERT INTO `t_Sys_Role` VALUES ('2', '1', 'VIP会员', 'vip');

INSERT INTO `t_Sys_Permission` VALUES ('2', '1', '用户添加', '1', '0/1', 'userInfo:add', 'button', 'userInfo/userAdd');
INSERT INTO `t_Sys_Permission` VALUES ('3', '1', '用户删除', '1', '0/1', 'userInfo:del', 'button', 'userInfo/userDel');


INSERT INTO `t_Sys_User_Role` VALUES ('1', '1');
INSERT INTO `t_Sys_User_Role` VALUES ('1', '2');

INSERT INTO `t_Sys_Role_Permission` VALUES ('1', '1');
INSERT INTO `t_Sys_Role_Permission` VALUES ('1', '2');
