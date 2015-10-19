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
package org.nasa.robot.entities;

import org.nasa.robot.entities.RobotPosition;
import org.nasa.robot.entities.Mars;
import org.nasa.robot.entities.Robot;
import javax.ejb.embeddable.EJBContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.nasa.robot.exceptions.InvalidDirectionException;
import org.nasa.robot.exceptions.InvalidMessageException;
import org.nasa.robot.exceptions.InvalidPositionException;

/**
 *
 * @author rafaelsilva
 */
public class RobotTest {
    private Robot instance;
    private Mars field;

    public RobotTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.field = new Mars();
        this.instance = new Robot(this.field);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of reset method, of class Robot.
     */
    @Test
    public void testReset() throws InvalidPositionException, InvalidDirectionException {
        assertEquals(0, instance.getPosition().getX());
        assertEquals(0, instance.getPosition().getY());
        assertEquals("N", instance.getPosition().getDirection());

        instance.getPosition().setX(3);
        assertEquals(3, instance.getPosition().getX());

        instance.getPosition().setY(3);
        assertEquals(3, instance.getPosition().getY());

        instance.getPosition().setDirection("W");
        assertEquals("W", instance.getPosition().getDirection());

        this.instance.reset();
        assertEquals(0, instance.getPosition().getX());
        assertEquals(0, instance.getPosition().getY());
        assertEquals("N", instance.getPosition().getDirection());
    }

    /**
     * Test of getField method, of class Robot.
     */
    @Test
    public void testGetField() {
        assertEquals(this.field, instance.getField());
    }

    /**
     * Test of setField method, of class Robot.
     */
    @Test
    public void testSetField() {
        Mars myField = new Mars(10, 10);
        this.instance.setField(myField);
        assertEquals(myField, instance.getField());
    }

    /**
     * Test of rotateLeft method, of class Robot.
     */
    @Test
    public void testRotateLeft() throws Exception {
        assertEquals("N", this.instance.getPosition().getDirection());

        this.instance.rotateLeft();
        assertEquals("W", this.instance.getPosition().getDirection());

        this.instance.rotateLeft();
        assertEquals("S", this.instance.getPosition().getDirection());

        this.instance.rotateLeft();
        assertEquals("E", this.instance.getPosition().getDirection());

        this.instance.rotateLeft();
        assertEquals("N", this.instance.getPosition().getDirection());
    }

    /**
     * Test of rotateRight method, of class Robot.
     */
    @Test
    public void testRotateRight() throws Exception {
        assertEquals("N", this.instance.getPosition().getDirection());

        this.instance.rotateRight();
        assertEquals("E", this.instance.getPosition().getDirection());

        this.instance.rotateRight();
        assertEquals("S", this.instance.getPosition().getDirection());

        this.instance.rotateRight();
        assertEquals("W", this.instance.getPosition().getDirection());

        this.instance.rotateRight();
        assertEquals("N", this.instance.getPosition().getDirection());
    }

    /**
     * Test of receiveMessage method, of class Robot.
     */
    @Test
    public void testRobotStartWithInitialPositon() throws Exception {
        RobotPosition result = this.instance.getPosition();
        assertEquals(0, result.getX());
        assertEquals(0, result.getY());
        assertEquals("N", result.getDirection());
    }

    /**
     * Test of receiveMessage method, of class Robot.
     */
    @Test
    public void testReceiveMessage() throws Exception {
        String message = "MML";
        boolean result = this.instance.receiveMessage(message);
        assertEquals(true, result);

        RobotPosition position = this.instance.getPosition();
        assertEquals(0, position.getX());
        assertEquals(2, position.getY());
        assertEquals("W", position.getDirection());

        this.instance.reset();
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
        assertEquals("N", position.getDirection());

        message = "MMRMMRMMRMM";
        result = this.instance.receiveMessage(message);
        assertEquals(true, result);
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
        assertEquals("W", position.getDirection());
    }

    /**
     * Test of receiveMessage method, of class Robot.
     */
    @Test
    public void testReceiveInvalidMessage() throws Exception {
        String message = "RERROR";
        try {
          this.instance.receiveMessage(message);
          fail("Should have thrown InvalidMessageException but did not!");
        } catch( final InvalidMessageException e ) {
          final String msg = "Invalid 'E' instruction";
          assertEquals(msg, e.getMessage());
        }
    }

    /**
     * Test of validateMessage method, of class Robot.
     */
    @Test
    public void testValidateMessageWithInvalidMsg() throws Exception {
        String message = "ERROR";
        try {
          this.instance.validateMessage(message);
          fail("Should have thrown InvalidMessageException but did not!");
        } catch( final InvalidMessageException e ) {
          final String msg = "Invalid 'E' instruction";
          assertEquals(msg, e.getMessage());
        }
    }

    /**
     * Test of validateMessage method, of class Robot.
     */
    @Test
    public void testValidateMessageWithValid() throws Exception {
        String message = "LRMMRLMRL";
        this.instance.validateMessage(message);
    }

}
