package com.zlsoft.timing;


import com.zlsoft.service.TvDatasourceFormatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import javax.annotation.Resource;
import java.util.*;

@Configuration
@EnableScheduling
public class CompleteScheduleConfig implements SchedulingConfigurer {


    @Autowired
    private TvDatasourceFormatService tvDatasourceFormatService;
 
    /**
     * 执行定时任务.
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        Runnable task = new Runnable() {

            @Override

            public void run() {
                // 逻辑代码
                System.out.println("执行刷新");
                //tvDatasourceFormatService.timingUpdate();

            }

        };

        Trigger trigger = new Trigger() {

            @Override

            public Date nextExecutionTime(TriggerContext triggerContext) {

                //2.1 从数据库获取执行周期
                Map<String, String> refresh_interval = tvDatasourceFormatService.getTimingTime("refresh_interval");
                System.out.println("refresh_interval          " + refresh_interval.get("parameter_value"));
                String cron = "";
                if (refresh_interval.get("comments").contains("秒")) {
                    if (60 >= Integer.parseInt(refresh_interval.get("parameter_value"))) {
                        cron = "0/" + refresh_interval.get("parameter_value") + " * * * * ?";
                    } else {
                        int mina = Integer.parseInt(refresh_interval.get("parameter_value")) / 60;

                        cron = "0 0/" + mina + " * * * ?";
                    }
                }
                System.out.println(cron);

                CronTrigger trigger = new CronTrigger(cron);

                Date nextExec = trigger.nextExecutionTime(triggerContext);

                return nextExec;

            }

        };

        taskRegistrar.addTriggerTask(task, trigger);

    }
}