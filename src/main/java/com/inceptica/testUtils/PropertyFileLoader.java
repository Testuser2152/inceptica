package com.inceptica.testUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @name : PropertyFileLoader
 * @author Sandeep
 * @description reads the config properties file and returns the specific value
 *
 */
public class PropertyFileLoader {

	private static final Logger logger = Logger.getLogger(PropertyFileLoader.class);

	private static PropertyFileLoader configInstance = null;
	private Properties configProperties;

	/**
	 * This is used to load the property file based on input
	 * 
	 * @param path
	 *            path of the property file
	 * @throws IOException
	 */
	protected PropertyFileLoader(String filePath) throws IOException {

		if (filePath.contains("configurations")) {
			try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
				configProperties = new Properties();
				configProperties.load(reader);
				logger.info("loaded the property file");
			} catch (IOException e) {
				logger.error("IOException:: PropertyFileLoader:: " + e.getMessage());
			}
		}
	}

	public static PropertyFileLoader getConfigInstance() {
		if (configInstance == null) {
			try {
				configInstance = new PropertyFileLoader("src\\test\\resource\\configurations.properties");
			} catch (IOException ioe) {
				logger.error("getConfigInstance :: IOException :: " + ioe.getMessage());
			} catch (Exception ex) {
				logger.error("getConfigInstance :: Exception :: " + ex.getMessage());
			}
		}
		return configInstance;
	}

	public String getConfigValue(String key) {
		if (configProperties.getProperty(key) != null)
			return configProperties.getProperty(key);
		else
			throw new RuntimeException(key + " not specified in the Configuration.properties file.");
	}

	public void loadFile(String filePath) {
		logger.info("Into Config file reader");
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			configProperties = new Properties();
			configProperties.load(reader);
			reader.close();
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException:: loadFile:: properties not found " + filePath);
			throw new RuntimeException("Configuration.properties not found at " + filePath);
		} catch (IOException e) {
			logger.error("IOException:: loadFile:: " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @name : getWebDriverWait
	 * @description get the webdriver wait, from the property of webdriverwait
	 * @return - int
	 */
	public int getWebDriverWait() {
		String webdriverwait = configProperties.getProperty("webdriverwait");
		if (webdriverwait != null)
			return Integer.parseInt(webdriverwait);
		else
			throw new RuntimeException("webdriverwait not specified in the Configuration.properties file.");
	}

	/**
	 * @name : getPause
	 * @description get the pause time, from the property of pause
	 * @return - long
	 */
	public long getPause() {
		String pause = configProperties.getProperty("pause");
		if (pause != null)
			return Long.parseLong(pause);
		else
			throw new RuntimeException("pause not specified in the Configuration.properties file.");
	}

	/**
	 * @name : getPageLoadPause
	 * @description get the page load pause time, from the property of pageloadpause
	 * @return - long
	 */
	public long getPageLoadPause() {
		String pageloadpause = configProperties.getProperty("pageloadpause");
		if (pageloadpause != null)
			return Long.parseLong(pageloadpause);
		else
			throw new RuntimeException("pageloadpause not specified in the Configuration.properties file.");
	}

	public String getqaURL() {
		String driverPath = configProperties.getProperty("qaURL");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException("qa url in the Configuration.properties file.");
	}
}
