package com.szn.quartz.demo;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * @description:
 * @author: sunzhaoning
 * @create: 2019/1/30 3:49 PM
 * @version: V1.0
 **/
@Slf4j
public class JobTest implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("----------》》》这里写定时任务业务逻辑。。。");
    }
}
