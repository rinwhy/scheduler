package com.solvd.scheduler.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * SqlSessionUtil provides methods for managing the SqlSessionFactory
 *
 * Sets the MyBatis configuration file and properties
 */
public class SqlSessionUtil {
    private final static Logger LOGGER = LogManager.getLogger(SqlSessionUtil.class);
    private final static String MYBATIS_CONFIG = "mybatis_config.xml";

    public SqlSessionFactory getSessionFactory(){
        Properties props = PropertiesUtil.getProperties();
        try(InputStream stream = Resources.getResourceAsStream(MYBATIS_CONFIG);){
            return new SqlSessionFactoryBuilder().build(stream,props);
        } catch (IOException e) {
            LOGGER.error("File not found.");
            throw new RuntimeException(e);
        }
    }
}
