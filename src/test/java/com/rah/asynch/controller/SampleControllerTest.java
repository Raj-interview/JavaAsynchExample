package com.rah.asynch.controller;

import com.rah.asynch.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public class SampleControllerTest {

    @Inject private SampleController sampleController;

    @Test
    public void testSystemHealth() throws Exception{
        boolean isGoogleSearchAlive = sampleController.isAlive();
        assertFalse(isGoogleSearchAlive);
        Thread.sleep(2000);
        isGoogleSearchAlive = sampleController.isAlive();
        assertTrue(isGoogleSearchAlive);
    }
}
