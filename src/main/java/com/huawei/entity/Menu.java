package com.huawei.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * User: yi
 * ClassName: Menu
 * Date:     2019/06/04 21:10
 */
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "menuName")
    private String menuName;
    @Column(name = "pid")
    private Integer pid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public static Map<String, Object> menuToMap(Menu menu) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", menu.getId());
        map.put("name", menu.getMenuName());
        map.put("pId", menu.getPid());
        map.put("open", true);
        return map;
    }
}
