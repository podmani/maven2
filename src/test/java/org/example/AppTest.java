package org.example;

import ch.qos.logback.classic.Logger;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;



/**
 * Unit test for simple App.
 */
public class AppTest


{
    private static Logger logger = (Logger) LoggerFactory.getLogger(AppTest.class);
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        logger.error("My error");
        assertTrue( true );
    }

    @Test
    void MyTest() {
        System.out.println("My test");
    }
}
