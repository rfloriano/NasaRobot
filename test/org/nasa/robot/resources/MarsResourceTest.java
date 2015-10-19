/*
 * The MIT License
 *
 * Copyright 2015 rafaelsilva.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
     * Test of getGreeting method, of class MarsResource.
     */
    @Test
    public void testGetGreeting() throws Exception {
        System.out.println("getGreeting");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        MarsResource instance = (MarsResource)container.getContext().lookup("java:global/classes/MarsResource");
//        String expResult = "";
//        String result = instance.getGreeting();
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessage method, of class MarsResource.
     */
    @Test
    public void sendMessage() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        MarsResource instance = (MarsResource)container.getContext().lookup("java:global/classes/MarsResource");
        String data = "{\"name\": \"Robotson\",\"position\": {\"name\": \"(0, 2, N)\",\"x\": \"0\",\"y\": \"2\",\"compass\": \"W\"}}";
        Response expResult = Response.ok(data, MediaType.APPLICATION_JSON).build();
        Response result = instance.sendMessage("MML");
        assertEquals(expResult.getStatus(), result.getStatus());
        assertEquals(expResult.toString(), result.toString());
        container.close();
    }

    /**
     * Test of status method, of class MarsResource.
     * @throws java.lang.Exception
     */
    @Test
    public void testStatus() throws Exception {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        MarsResource instance = (MarsResource)container.getContext().lookup("java:global/classes/MarsResource");
        String data = "{\"name\": \"Robotson\",\"position\": {\"name\": \"(0, 0, N)\",\"x\": \"0\",\"y\": \"0\",\"compass\": \"N\"}}";
        Response expResult = Response.ok(data, MediaType.APPLICATION_JSON).build();
        Response result = instance.status();
        assertEquals(expResult.getStatus(), result.getStatus());
        assertEquals(expResult.toString(), result.toString());
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
        assertEquals(expResult.toString(), result.toString());
        container.close();
    }

}
