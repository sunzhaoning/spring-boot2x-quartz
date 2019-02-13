package com.szn.quartz.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 定时任务实体
 * @author: sunzhaoning
 * @create: 2019/1/30 11:57 AM
 * @version: V1.0
 **/
@Data
public class JobInfoModel implements Serializable {

    private static final long serialVersionUID = -8054692082716173379L;

    private int id = 0;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务分组
     */
    private String jobGroup;

    /**
     * 任务描述
     */
    private String jobDescription;

    /**
     * 任务状态
     */
    private String jobStatus;

    /**
     * 任务表达式
     */
    private String cronExpression;

    /**
     * 创建时间
     */
    private String createTime;
}
