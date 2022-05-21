package com.lagou.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "user")
public class User implements Serializable {

    @Id //对应的是注解id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //设置主键的生成策略
    /**
     * GenerationType.IDENTITY  底层数据库得支持主键的自动增长，比如MySQL
     * GenerationType.SEQUENCE  底层数据库是Oracle，用序列值来生成主键
     * GenerationType.TABLE     会生成一张表，从这张表中取值来生成主键
     * GenerationType.AUTO      根据底层数据库，自动选择一个主键生成策略
     */
    private Integer id;
    /**
     * 用这个 tk.mybatis 框架，得属性名和字段名一致，如果不一致，可以用
     * @Column(name = "XXX")注解，@Column不指定name，默认属性的驼峰命名对应表字段的“_"，
     * 比如：parentId对应表字段parent_id。
     */
    private String username;

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                '}';
//    }
        //表示用户关联的订单
//    private List<Order> orderList = new ArrayList<>();
////
//    //表示用户关联的角色
//    private List<Role> roleList = new ArrayList<>();
//
//    public List<Order> getOrderList() {
//        return orderList;
//    }
//
//    public void setOrderList(List<Order> orderList) {
//        this.orderList = orderList;
//    }
////
//    public List<Role> getRoleList() {
//        return roleList;
//    }
//
//    public void setRoleList(List<Role> roleList) {
//        this.roleList = roleList;
//    }
//


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
//                ", orderList=" + orderList +
//                ", roleList=" + roleList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
