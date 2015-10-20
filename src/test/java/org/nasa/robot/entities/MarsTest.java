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
public class MarsTest {
    private Mars instance;

    public MarsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.instance = new Mars();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getWidth method, of class Mars.
     */
    @Test
    public void testGetWidth() {
        assertEquals(5, this.instance.getWidth());
    }

    /**
     * Test of getHeight method, of class Mars.
     */
    @Test
    public void testGetHeight() {
        assertEquals(5, this.instance.getHeight());
    }

    /**
     * Test of getName method, of class Mars.
     */
    @Test
    public void testGetName() {
        assertEquals("Mars", this.instance.getName());
    }

}
