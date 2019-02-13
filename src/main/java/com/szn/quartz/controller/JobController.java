package com.szn.quartz.controller;

import com.alibaba.fastjson.JSON;
import com.szn.quartz.model.JobInfoModel;
import com.szn.quartz.model.ResultModel;
import com.szn.quartz.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 定时任务控制器
 * @author: sunzhaoning
 * @create: 2019/1/30 11:55 AM
 * @version: V1.0
 **/
@RestController
@RequestMapping(value = {"/job"})
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping(value = {"/list"})
    public String list() {
        Map<String, Object> map = new HashMap<>();
        List<JobInfoModel> infos = jobService.list();
        map.put("rows", infos);
        map.put("total", infos.size());
        return JSON.toJSONString(infos);
    }

    /**
     * 添加
     *
     * @param info
     * @return
     */
    @PostMapping(value = {"add"})
    public ResultModel add(@RequestBody JobInfoModel info) {
        try {
            if (info.getId() == 0) {
                jobService.addJob(info);
            } else {
                jobService.edit(info);
            }
        } catch (Exception e) {
            return new ResultModel(500, e.getMessage(), info);
        }
        return new ResultModel(200, "添加成功", info);
    }

    /**
     * 修改
     * @param info
     * @return
     */
    @PostMapping(value = {"update"})
    public ResultModel update(@RequestBody JobInfoModel info) {
        try {
            jobService.edit(info);
        } catch (Exception e) {
            return new ResultModel(500, e.getMessage(), info);
        }
        return new ResultModel(200, "修改成功", info);
    }

    /**
     * 暂停
     *
     * @param jobName
     * @param jobGroup
     * @return
     */
    @PostMapping(value = {"pause/{jobName}/{jobGroup}"})
    public ResultModel pause(@PathVariable String jobName, @PathVariable String jobGroup) {
        try {
            jobService.pause(jobName, jobGroup);
        } catch (Exception e) {
            return new ResultModel(500, e.getMessage(), jobName + "," + jobGroup);
        }
        return new ResultModel(200, "暂停成功", jobName + "," + jobGroup);
    }

    /**
     * 删除任务
     *
     * @param jobName
     * @param jobGroup
     * @return
     */
    @PostMapping(value = {"del/{jobName}/{jobGroup}"})
    public ResultModel delete(@PathVariable String jobName, @PathVariable String jobGroup) {
        try {
            jobService.delete(jobName, jobGroup);
        } catch (Exception e) {
            return new ResultModel(500, e.getMessage(), jobName + "," + jobGroup);
        }
        return new ResultModel(200, "删除成功", jobName + "," + jobGroup);
    }

    /**
     * 重新启动
     *
     * @param jobName
     * @param jobGroup
     * @return
     */
    @PostMapping(value = {"resume/{jobName}/{jobGroup}"})
    public ResultModel resume(@PathVariable String jobName, @PathVariable String jobGroup) {
        try {
            jobService.resume(jobName, jobGroup);
        } catch (Exception e) {
            return new ResultModel(500, e.getMessage(), jobName + "," + jobGroup);
        }
        return new ResultModel(200, "恢复成功", jobName + "," + jobGroup);
    }
}
