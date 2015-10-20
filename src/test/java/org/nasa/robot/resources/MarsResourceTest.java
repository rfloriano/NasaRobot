/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nasa.robot.resources;

import javax.ejb.embeddable.EJBContainer;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rafaelsilva
 */
public class MarsResourceTest {
    
    public MarsResourceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sendMessage method, of class MarsResource.
     */
    @Test
    public void testSendMessage() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        MarsResource instance = (MarsResource)container.getContext().lookup("java:global/classes/MarsResource");
        String data = "{\"name\": \"Robotson\",\"position\": {\"name\": \"(0, 2, W)\",\"x\": \"0\",\"y\": \"2\",\"compass\": \"W\"}}";
        Response expResult = Response.ok(data, MediaType.APPLICATION_JSON).build();
        Response result = instance.sendMessage("MML");
        assertEquals(expResult.getStatus(), result.getStatus());
        assertEquals(expResult.getEntity().toString(), result.getEntity().toString());
        container.close();
    }

    /**
     * Test of status method, of class MarsResource.
     */
    @Test
    public void testStatus() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        MarsResource instance = (MarsResource)container.getContext().lookup("java:global/classes/MarsResource");
        String data = "{\"name\": \"Robotson\",\"position\": {\"name\": \"(0, 0, N)\",\"x\": \"0\",\"y\": \"0\",\"compass\": \"N\"}}";
        Response expResult = Response.ok(data, MediaType.APPLICATION_JSON).build();
        Response result = instance.status();
        assertEquals(expResult.getStatus(), result.getStatus());
        assertEquals(expResult.getEntity().toString(), result.getEntity().toString());
        container.close();
    }

    /**
     * Test of reset method, of class MarsResource.
     */
    @Test
    public void testReset() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        MarsResource instance = (MarsResource)container.getContext().lookup("java:global/classes/MarsResource");
        String data = "{\"name\": \"Robotson\",\"position\": {\"name\": \"(0, 0, N)\",\"x\": \"0\",\"y\": \"0\",\"compass\": \"N\"}}";
        Response expResult = Response.ok(data, MediaType.APPLICATION_JSON).build();
        Response result = instance.reset();
        assertEquals(expResult.getStatus(), result.getStatus());
        assertEquals(expResult.getEntity().toString(), result.getEntity().toString());
        container.close();
    }
    
}
