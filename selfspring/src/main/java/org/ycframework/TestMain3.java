package org.ycframework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: mavenProject
 * @description:
 * @author: Joker
 * @create: 2023-07-27 14:47
 */
public class TestMain3 {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(TestMain3.class);
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");
    }
}
