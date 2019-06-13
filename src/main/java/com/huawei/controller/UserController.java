package com.huawei.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huawei.entity.User;
import com.huawei.mapper.UserMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * User: yi
 * ClassName: UserController
 * Date:     2019/05/31 21:43
 */
@RequestMapping(value = "/user")
@RestController
public class UserController {

    private static  final Log log= LogFactory.getLog(UserController.class);

    @Autowired
    private UserMapper userMapper;

    private Map<String, Object> resultMap = new HashMap<>();

    @RequestMapping("/getAll")
    public String getAll() {
        try {
            List<User> users = userMapper.selectAll();
            resultMap.put("data", users);
            resultMap.put("result", true);
        } catch (Exception e) {
            resultMap.put("msg", e.getMessage());
            resultMap.put("result", false);
        }
        return JSON.toJSONString(resultMap);
    }


    @RequestMapping("/getPageInfo")
    public String getPageInfo(int pageNum, int pageRows) {
        try {
            for (int i = 0; i < 5; i++) {
                log.info("-------------getPageInfo()方法打印了----------------");
            }
            PageHelper.startPage(pageNum, pageRows);
            List<User> users = userMapper.selectAll();
            PageInfo<User> pageInfo = new PageInfo<>(users);
            resultMap.put("data", pageInfo);
            resultMap.put("result", true);

        } catch (Exception e) {
            resultMap.put("msg", e.getMessage());
            resultMap.put("result", false);
        }
        return JSON.toJSONString(resultMap);
    }

    @RequestMapping("/getUserById/{id}")
    public String getUserById(@PathVariable("id") int id) {
        try {
            resultMap.put("data", userMapper.selectByPrimaryKey(id));
            resultMap.put("result", true);
        } catch (Exception e) {
            resultMap.put("msg", e.getMessage());
            resultMap.put("result", false);
        }
        return JSON.toJSONString(resultMap);
    }

    @RequestMapping("/updateUserById")
    public String updateUserById(User user) {
        try {
            userMapper.updateByPrimaryKey(user);
            resultMap.put("result", true);
        } catch (Exception e) {
            resultMap.put("msg", e.getMessage());
            resultMap.put("result", false);
        }
        return JSON.toJSONString(resultMap);
    }

    @RequestMapping("/insertUser")
    public String insertUser(User user) {
        try {
            userMapper.insert(user);
            resultMap.put("result", true);
        } catch (Exception e) {
            resultMap.put("msg", e.getMessage());
            resultMap.put("result", false);
        }
        return JSON.toJSONString(resultMap);
    }

    @RequestMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") int id) {
        try {
            userMapper.deleteByPrimaryKey(id);
            resultMap.put("result", true);
        } catch (Exception e) {
            resultMap.put("msg", e.getMessage());
            resultMap.put("result", false);
        }
        return JSON.toJSONString(resultMap);
    }

    @RequestMapping("/deleteSelected")
    public String deleteSelected(String ids) {
        try {
            Example example = new Example(User.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andIn("id", JSON.parseArray(ids));
            userMapper.deleteByExample(example);
            resultMap.put("result", true);
        } catch (Exception e) {
            resultMap.put("msg", e.getMessage());
            resultMap.put("result", false);
        }
        return JSON.toJSONString(resultMap);
    }

    @RequestMapping("/getUserList")
    public List<Map> getUserList() {
        return userMapper.getUserList();

    }

}
