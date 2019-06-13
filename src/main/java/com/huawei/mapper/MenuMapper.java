package com.huawei.mapper;

import com.huawei.entity.Menu;
import com.huawei.entity.User;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * User: yi
 * ClassName: MenuMapper
 * Date:     2019/06/04 21:15
 */
public interface MenuMapper extends Mapper<Menu>, MySqlMapper<Menu> {
}
