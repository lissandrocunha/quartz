/**
 * 
 */
package quartz.job.hello;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author LPCUNHA
 *
 */
public class Hello implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("teste");
		
	}

	

}
