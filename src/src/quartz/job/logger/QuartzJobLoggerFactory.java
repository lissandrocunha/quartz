package quartz.job.logger;

import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class QuartzJobLoggerFactory extends PropertyConfigurator {

	public static Logger getLogger(Class<? extends Object> classToLog, Properties configLogger) {

		Logger logger = null;

		logger = Logger.getLogger(classToLog);

		logger.setLevel(Level.toLevel(configLogger.getProperty("Level")));

		return logger;
	}

}
