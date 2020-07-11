package org.doraemon.component.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @description: 描述
 * @author: fengwenping
 * @date: 2020-07-11 23:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext-test.xml"})
public class DoraemonJunitTest {

    @Before
    public void before() {

    }

    @After
    public void after() {

    }
}
