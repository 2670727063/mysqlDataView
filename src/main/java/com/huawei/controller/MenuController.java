package com.huawei.controller;

import com.alibaba.fastjson.JSON;
import com.huawei.entity.Menu;
import com.huawei.entity.User;
import com.huawei.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: yi
 * ClassName: MenuController
 * Date:     2019/06/04 21:15
 */
@RequestMapping(value = "/menu")
@RestController
public class MenuController {
    @Autowired
    private MenuMapper menuMapper;

    private Map<String, Object> resultMap = new HashMap<>();

    @RequestMapping("/getAll")
    public String getAll() {
        try {
            List<Menu> menus = menuMapper.selectAll();
            ArrayList<Map<String, Object>> list = new ArrayList<>();
            for (Menu menu : menus) {
                list.add(Menu.menuToMap(menu));
            }
            resultMap.put("data", list);
            resultMap.put("result", true);
        } catch (Exception e) {
            resultMap.put("msg", e.getMessage());
            resultMap.put("result", false);
        }
        return JSON.toJSONString(resultMap);
    }


}
