INSERT INTO `Sys_Permission` VALUES ('2', '1', '用户添加', '1', '0/1', 'userInfo:add', 'button', 'userInfo/userAdd');
INSERT INTO `Sys_Permission` VALUES ('3', '1', '用户删除', '1', '0/1', 'userInfo:del', 'button', 'userInfo/userDel');

INSERT INTO `Sys_Role_Permission` VALUES ('1', '1');
INSERT INTO `Sys_Role_Permission` VALUES ('1', '2');

INSERT INTO `Sys_User_Role` VALUES ('1', '1');
INSERT INTO `Sys_User_Role` VALUES ('1', '2');

INSERT INTO `User_Info` VALUES ('1', '管理员', 'admin',
'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '0');

INSERT INTO `Sys_Role` VALUES ('1', '1', '管理员', 'admin');
INSERT INTO `Sys_Role` VALUES ('2', '1', 'VIP会员', 'vip');