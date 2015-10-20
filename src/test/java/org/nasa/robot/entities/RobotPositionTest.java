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

import org.nasa.robot.entities.Mars;
import org.nasa.robot.entities.RobotPosition;
import org.nasa.robot.exceptions.InvalidPositionException;
import org.nasa.robot.exceptions.InvalidDirectionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
public class RobotPositionTest {
    private RobotPosition instance;
    private Mars field;

    public RobotPositionTest() {
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
        this.instance = new RobotPosition(field);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class RobotPosition.
     */
    @Test
    public void testToString() throws InvalidPositionException, InvalidDirectionException {
        assertEquals("(0, 0, N)", this.instance.toString());

        this.instance.setX(3);
        this.instance.setY(2);
        this.instance.setDirection("S");
        assertEquals("(3, 2, S)", this.instance.toString());

        assertEquals("(5, 2, F)", this.instance.toString(5, 2, "F"));
    }

    /**
     * Test of getX method, of class RobotPosition.
     */
    @Test
    public void testGetX() {
        int expResult = 0;
        int result = this.instance.getX();
        assertEquals(expResult, result);
    }

    /**
     * Test of setX method, of class RobotPosition.
     */
    @Test
    public void testSetX() throws InvalidPositionException {
        assertEquals(0, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        this.instance.setX(4);
        assertEquals(4, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        try {
          this.instance.setX(5);
          fail("Should have thrown InvalidMessageException but did not!");
        } catch( final InvalidPositionException e ) {
          final String msg = "Position (5, 0, N) is out of range";
          assertEquals(msg, e.getMessage());
        }
    }

    /**
     * Test of getY method, of class RobotPosition.
     */
    @Test
    public void testGetY() {
        int expResult = 0;
        int result = this.instance.getY();
        assertEquals(expResult, result);
    }

    /**
     * Test of setY method, of class RobotPosition.
     */
    @Test
    public void testSetY() throws InvalidPositionException {
        assertEquals(0, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        this.instance.setY(4);
        assertEquals(0, this.instance.getX());
        assertEquals(4, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        try {
          this.instance.setY(5);
          fail("Should have thrown InvalidMessageException but did not!");
        } catch( final InvalidPositionException e ) {
          final String msg = "Position (0, 5, N) is out of range";
          assertEquals(msg, e.getMessage());
        }
    }

    /**
     * Test of incX method, of class RobotPosition.
     */
    @Test
    public void testIncX() throws InvalidPositionException {
        assertEquals(0, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        this.instance.incX();
        assertEquals(1, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        this.instance.incX();
        assertEquals(2, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        this.instance.setX(4);
        try {
          this.instance.incX();
          fail("Should have thrown InvalidMessageException but did not!");
        } catch( final InvalidPositionException e ) {
          final String msg = "Position (5, 0, N) is out of range";
          assertEquals(msg, e.getMessage());
        }
        assertEquals(4, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("N", this.instance.getDirection());
    }

    /**
     * Test of decX method, of class RobotPosition.
     */
    @Test
    public void testDecX() throws Exception {
        assertEquals(0, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        try {
          this.instance.decX();
          fail("Should have thrown InvalidMessageException but did not!");
        } catch( final InvalidPositionException e ) {
          final String msg = "Position (-1, 0, N) is out of range";
          assertEquals(msg, e.getMessage());
        }

        assertEquals(0, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        this.instance.setX(4);
        this.instance.decX();
        assertEquals(3, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("N", this.instance.getDirection());
    }

    /**
     * Test of incY method, of class RobotPosition.
     */
    @Test
    public void testIncY() throws InvalidPositionException {
        assertEquals(0, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        this.instance.incY();
        assertEquals(0, this.instance.getX());
        assertEquals(1, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        this.instance.incY();
        assertEquals(0, this.instance.getX());
        assertEquals(2, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        this.instance.setY(4);
        try {
          this.instance.incY();
          fail("Should have thrown InvalidMessageException but did not!");
        } catch( final InvalidPositionException e ) {
          final String msg = "Position (0, 5, N) is out of range";
          assertEquals(msg, e.getMessage());
        }
        assertEquals(0, this.instance.getX());
        assertEquals(4, this.instance.getY());
        assertEquals("N", this.instance.getDirection());
    }

    /**
     * Test of decY method, of class RobotPosition.
     */
    @Test
    public void testDecY() throws InvalidPositionException {
        assertEquals(0, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        try {
          this.instance.decY();
          fail("Should have thrown InvalidMessageException but did not!");
        } catch( final InvalidPositionException e ) {
          final String msg = "Position (0, -1, N) is out of range";
          assertEquals(msg, e.getMessage());
        }
        assertEquals(0, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        this.instance.setY(4);
        this.instance.decY();
        assertEquals(0, this.instance.getX());
        assertEquals(3, this.instance.getY());
        assertEquals("N", this.instance.getDirection());
    }

    /**
     * Test of move method, of class RobotPosition.
     */
    @Test
    public void testMove() throws Exception {
        assertEquals(0, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        this.instance.move();
        assertEquals(0, this.instance.getX());
        assertEquals(1, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        this.instance.move();
        assertEquals(0, this.instance.getX());
        assertEquals(2, this.instance.getY());
        assertEquals("N", this.instance.getDirection());

        this.instance.setDirection("S");
        this.instance.move();
        assertEquals(0, this.instance.getX());
        assertEquals(1, this.instance.getY());
        assertEquals("S", this.instance.getDirection());

        this.instance.move();
        assertEquals(0, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("S", this.instance.getDirection());

        this.instance.setDirection("E");
        this.instance.move();
        assertEquals(1, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("E", this.instance.getDirection());

        this.instance.move();
        assertEquals(2, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("E", this.instance.getDirection());

        this.instance.setDirection("W");
        this.instance.move();
        assertEquals(1, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("W", this.instance.getDirection());

        this.instance.move();
        assertEquals(0, this.instance.getX());
        assertEquals(0, this.instance.getY());
        assertEquals("W", this.instance.getDirection());
    }

    /**
     * Test of getDirections method, of class RobotPosition.
     */
    @Test
    public void testGetDirections() {
        assertEquals("NESW", this.instance.getDirections());
    }

    /**
     * Test of getDirection method, of class RobotPosition.
     */
    @Test
    public void testGetDirection() {
        assertEquals("N", this.instance.getDirection());
    }

    /**
     * Test of setDirection method, of class RobotPosition.
     */
    @Test
    public void testSetDirection() throws Exception {
        try {
          this.instance.setDirection("F");
          fail("Should have thrown InvalidMessageException but did not!");
        } catch( final InvalidDirectionException e ) {
          assertEquals("Invalid 'F' direction", e.getMessage());
        }
        assertEquals("N", this.instance.getDirection());

        this.instance.setDirection("S");
        assertEquals("S", this.instance.getDirection());
    }

    /**
     * Test of validateDirection method, of class RobotPosition.
     */
    @Test
    public void testValidateDirection() {
        Mars field = new Mars();
        RobotPosition instance = new RobotPosition(field);
        try {
          this.instance.validateDirection("F");
          fail("Should have thrown InvalidMessageException but did not!");
        } catch( final InvalidDirectionException e ) {
          assertEquals("Invalid 'F' direction", e.getMessage());
        }
    }

    /**
     * Test of validateDirection method, of class RobotPosition.
     */
    @Test
    public void testValidateDirectionWithValid() throws Exception {
        this.instance.validateDirection("S");
    }

    private Mars lookupMarsBeanBean() {
        try {
            Context c = new InitialContext();
            return (Mars) c.lookup("java:global/NasaRobot/MarsBean!org.nasa.robot.MarsBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private Mars lookupMarsBeanBean1() {
        try {
            Context c = new InitialContext();
            return (Mars) c.lookup("java:global/NasaRobot/MarsBean!org.nasa.robot.MarsBean");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
