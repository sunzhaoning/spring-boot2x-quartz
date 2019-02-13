package com.szn.quartz.service;

import com.szn.quartz.model.JobInfoModel;
import org.quartz.SchedulerException;

import java.util.List;

/**
 * @description: 定时任务service
 * @author: sunzhaoning
 * @create: 2019/1/30 11:56 AM
 * @version: V1.0
 **/
public interface JobService {

    /**
     * 定时任务列表
     * @return
     */
    List<JobInfoModel> list();

    /**
     * 新增定时任务
     * @param info
     */
    void addJob(JobInfoModel info);

    /**
     * 修改定时任务
     * @param info
     */
    void edit(JobInfoModel info);

    /**
     * 删除任务
     * @param jobName
     * @param jobGroup
     */
    void delete(String jobName, String jobGroup);

    /**
     * 暂停定时任务
     * @param jobName
     * @param jobGroup
     */
    void pause(String jobName, String jobGroup);

    /**
     * 重新开始任务
     * @param jobName
     * @param jobGroup
     */
    void resume(String jobName, String jobGroup);

    /**
     * 验证是否存在
     * @param jobName
     * @param jobGroup
     * @return
     * @throws SchedulerException
     */
    boolean checkExists(String jobName, String jobGroup)throws SchedulerException;
}
