package com.example.springbootswagger.domain;

import com.alibaba.excel.annotation.ExcelProperty;

//
public class UserErr extends User {
    @ExcelProperty(value = "失败原因")
    protected String remark;
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
