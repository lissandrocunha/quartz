/**
 * 
 */
package quartz.job.hello;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import quartz.job.QuartzJob;

/**
 * @author LPCUNHA
 *
 */
public class Hello extends QuartzJob {

	public Hello() {
		super(Hello.class);

	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		super.getLogger().info("Iniciando Execução do Job...");
		
		System.out.println("teste");
		
		super.getLogger().info("Job executado!");
	}

}
