package com.zlsoft.timing;


import com.zlsoft.service.TvDatasourceFormatService;
import com.zlsoft.configurer.socket.service.WebSocketServer;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;
@Configuration
@Log4j
@EnableScheduling
public class CompleteScheduleConfig implements SchedulingConfigurer {


    @Resource
    private TvDatasourceFormatService tvDatasourceFormatService;


    private String refresh_interval;
    /**
     * 执行定时任务.
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        Runnable task = new Runnable() {

            @Override

            public void run() {
                // 逻辑代码
                log.info("执行刷新");
                tvDatasourceFormatService.timingUpdate();
                try {
                    WebSocketServer.sendInfo("更新",null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        };

        Trigger trigger = new Trigger() {

            @Override

            public Date nextExecutionTime(TriggerContext triggerContext) {

                //2.1 从数据库获取执行周期
                if (StringUtils.isBlank(refresh_interval)) {
                    Map<String, String> stringStringMap = tvDatasourceFormatService.getTimingTime("refresh_interval");
                    log.info("refresh_interval          " + stringStringMap.get("parameter_value"));
                    if (stringStringMap.get("comments").contains("秒")) {
                        if (60 >= Integer.parseInt(stringStringMap.get("parameter_value"))) {
                            refresh_interval = "0/" + stringStringMap.get("parameter_value") + " * * * * ?";
                        } else {
                            int mina = Integer.parseInt(stringStringMap.get("parameter_value")) / 60;

                            refresh_interval = "0 0/" + mina + " * * * ?";
                        }
                    }
                }

                log.info(refresh_interval);

                CronTrigger trigger = new CronTrigger(refresh_interval);

                Date nextExec = trigger.nextExecutionTime(triggerContext);

                return nextExec;

            }

        };

        taskRegistrar.addTriggerTask(task, trigger);

    }
}