package com.example.springbootehcache.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = -339516038496531944L;
    private String sno;
    private String sname;
    @JsonIgnore//忽略不显示
    private String ssex;
    @JsonProperty("bth")//取别名
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")//格式化
    private Date  date;
}
