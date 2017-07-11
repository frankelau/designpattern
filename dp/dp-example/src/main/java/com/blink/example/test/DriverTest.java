package com.blink.example.test;

import com.blink.example.pojo.ICar;
import com.blink.example.pojo.IDriver;
import com.blink.example.pojo.impl.Driver;
import junit.framework.TestCase;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Test;

public class DriverTest extends TestCase {
    Mockery context = new JUnit4Mockery();

    @Test
    public void testDriver() {
        final ICar car = context.mock(ICar.class);
        IDriver driver = new Driver(car);
        context.checking(new Expectations(){{
            oneOf(car).run();
        }
        });
        driver.driver();
    }
}
