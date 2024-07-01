package org.wedonttrack.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.wedonttrack.utils.CommonUtils;
import org.wedonttrack.utils.Constants;

import java.util.Properties;
import java.util.Random;

public class WiremockData {
    private static final Logger LOGGER = LogManager.getLogger(WiremockData.class);

    public Properties properties = new Properties();

    public WiremockData() {
        LOGGER.info("Creating global parameters");
        CommonUtils commonUtils = new CommonUtils();
        properties.put("random id: ", commonUtils.generateRandomUUID());

        LOGGER.info("Loading properties into PropertiesManager");

        this.loadProperties();
    }

    public void loadProperties(){
        PropertiesManager.loadProperties(this.properties);
    }

    public void addParameter(String key, String value){
        LOGGER.info("Loading parameter: [{}] : [{}]", key, value);
        this.properties.put(key, value);
    }

    public void addParameters(Properties properties){
        this.properties.putAll(properties);
    }

}