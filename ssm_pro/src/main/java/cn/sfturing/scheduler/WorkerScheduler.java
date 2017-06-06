package cn.sfturing.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WorkerScheduler {
	 @Scheduled(cron = "0 0/2 * * * ?")
	 public void createWorkTime(){
		 System.out.println("计时器****************************************************");
	 }
}
