package com.szn.quartz.demo;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @description:
 * @author: sunzhaoning
 * @create: 2019/1/30 12:24 PM
 * @version: V1.0
 **/
@Slf4j
public class JobDemo extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("这里写定时任务业务逻辑。。。");
    }
}
