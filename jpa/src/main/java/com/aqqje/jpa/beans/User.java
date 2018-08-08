package com.aqqje.jpa.beans;

import javax.persistence.*;

@Entity // jpa 表明一个实体类
@Table(name = "tbl_user") // 对应映射数据表
public class User {

    @Id // 主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自行增长
    private Integer id;
    @Column(name ="uname") // 数据表 -> 列
    private String name;
    @Column
    private String pwd;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
