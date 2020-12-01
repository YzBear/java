package com.myall.mybatis.bean;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class Student implements Serializable {


    private static final long serialVersionUID = -339516038496531943L;
    private String sno;
    private String name;
    private String sex;
}
