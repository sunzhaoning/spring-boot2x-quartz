package com.szn.quartz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultModel implements Serializable {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 描述
     */
    private String description;

    /**
     * 相应数据
     */
    private Object data;


}