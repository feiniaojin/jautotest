package com.feiniaojin.jautotest;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * TODO:Add the description of this class.
 *
 * @author: <a href=mailto:943868899@qq.com>Yujie</a>
 */
@SpringBootTest(classes = JAutoTestApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractBaseTest {
}
