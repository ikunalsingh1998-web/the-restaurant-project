package com.kunal.restaurant.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import com.kunal.restaurant.Services.UserDBService;

@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer, DisposableBean {
	
	@Autowired
	UserDBService userDBService;

	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

		// executor.scheduleAtFixedRate(() -> {
		// Task to be executed periodically
		// System.out.println("Task executed at: " + new Date());
		// }, 0, 1, TimeUnit.MINUTES); // Execute the task every minute

		taskRegistrar.addCronTask(() -> {
			System.out.println("This is a Scheduler Message!!!!!");
		}, "0 0 */5 * * *");

		taskRegistrar.addTriggerTask(() -> {
				System.out.println("Scheduler Logic");
		}, new CronTrigger("0 0 0 * * ?")); // Execute at midnight every day
	}

	@Override
	public void destroy() throws Exception {
		if (executor != null) {
			executor.shutdownNow();
		}
	}

}
