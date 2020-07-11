package org.doraemon.component.uid.impl;


import org.doraemon.component.junit.DoraemonJunitTest;
import org.doraemon.component.uid.UidGenerator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2020-07-11 23:44
 */
public class DefaultUidGeneratorTest extends DoraemonJunitTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultUidGeneratorTest.class);

    @Inject
    @Named("defaultUidGenerator")
    private UidGenerator defaultUidGenerator;

    @Inject
    @Named("cachedUidGenerator")
    private UidGenerator cachedUidGenerator;

    @Test
    public void getUID() throws Exception {
        LOGGER.info("getUID: {}", defaultUidGenerator.getUID());
    }

    @Test
    public void parseUID() throws Exception {
        LOGGER.info("parseUID: {}", defaultUidGenerator.parseUID(defaultUidGenerator.getUID()));
    }

    @Test
    public void getUID_01() throws Exception {
        for (int i = 0; i < 100; i++) {
            LOGGER.info("getUID: {}", cachedUidGenerator.getUID());
        }
    }

    @Test
    public void parseUID_01() throws Exception {
        LOGGER.info("parseUID: {}", cachedUidGenerator.parseUID(defaultUidGenerator.getUID()));
    }
}
