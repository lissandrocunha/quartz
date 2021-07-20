package quartz.core;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import quartz.job.hello.Hello;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;

public class QuartzManager {

    public static void main(String[] args) {

        try {      	
        	// define the job and tie it to our HelloJob class
        	  JobDetail job = JobBuilder.newJob(Hello.class)
        			  					.withIdentity("Hello", "group1")
        			  					.build();

        	  // Trigger the job to run now, and then repeat every 40 seconds
        	  Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
        			  						  .startNow()        	            
        			  						  .build();

        	
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
           
            // and start it off
            scheduler.start();

            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);
            
            //scheduler.shutdown();

        } catch (SchedulerException se) {
            se.printStackTrace();
        }
    }
}