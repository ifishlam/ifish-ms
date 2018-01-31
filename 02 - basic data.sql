INSERT INTO `system_property` (`active`, `key`, `value`, `remark`) VALUES
  ('+', 'ver_api', '0.0.1', 'API Version')
  , ('+', 'ver_sys', '0.0.2', 'system version');


INSERT INTO `security_role` (`active`, `intl_id`, `name`, `remark`) VALUES
  , ('+', 'ROLE_HOMUSR', 'Home User', 'System Init');
  ('+', 'ROLE_SYSADM', 'System Admin User', 'System Init')


INSERT INTO `security_user_role` (`active`, `security_user_id`, `security_role_id`, `remark`) VALUES
  ('+', 1, 1, 'System Init')
  , ('+', 1, 2, 'System Init')
  , ('+', 2, 2, 'System Init');