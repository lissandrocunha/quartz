/**
 * 
 */
package quartz.job;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.quartz.Job;

import quartz.job.logger.QuartzJobLoggerFactory;

/**
 * @author LPCUNHA
 *
 */
public abstract class QuartzJob implements Job {

	private Object classObject;
	private Properties configFile;
	private static Logger logger;

	public QuartzJob(Object classType) {
		classObject = classType;
		SetJobConfigurations();
	}

	private void SetJobConfigurations() {
		SetConfigFile();
		SetLoggerConfiguration(classObject, configFile);
	}

	private void SetConfigFile() {

		String pathJobConfigFile = "./";
		Properties configPropertyFile = new Properties();

		try {
			String executionPath = System.getProperty("user.dir");
			pathJobConfigFile = String.format("%s/src/%s/config.properties", executionPath.replace("\\", "/"),
					this.getClass().getPackageName().replace(".", "/"));
			configPropertyFile.load(new FileInputStream(pathJobConfigFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		configFile = configPropertyFile;
	}

	private void SetLoggerConfiguration(Object classType, Properties configFile) {
		Properties configLogger = new Properties();

		configLogger.setProperty("Level",
				configLogger == null || configFile.getProperty("job.logger.level").isBlank() ? "ERROR"
						: configFile.getProperty("job.logger.level"));

		logger = QuartzJobLoggerFactory.getLogger(classType.getClass(), configLogger);
	}

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return logger;
	}

}
