package com.huawei.mapper;

import com.huawei.entity.User;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: yi
 * ClassName: UserMapper
 * Date:     2019/05/31 21:43
 */
public interface UserMapper extends Mapper<User>, MySqlMapper<User> {

    public ArrayList<Map> getUserList();
}
