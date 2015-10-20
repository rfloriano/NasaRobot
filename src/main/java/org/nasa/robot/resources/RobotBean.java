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

import javax.ejb.Singleton;
import org.nasa.robot.entities.Mars;
import org.nasa.robot.entities.Robot;

/**
 *
 * @author rafaelsilva
 */
@Singleton
public class RobotBean {
    private Robot robot;

    public RobotBean() {
        this.robot = new Robot(new Mars());
    }

    public Robot getRobot() {
        return this.robot;
    }

    public String getPosition() {
        return this.robot.getPosition().toString();
    }

    public int getPositionX() {
        return this.robot.getPosition().getX();
    }

    public int getPositionY() {
        return this.robot.getPosition().getY();
    }

    public String getpositionDirection() {
        return this.robot.getPosition().getDirection().toLowerCase();
    }

    public int getFieldWidth() {
        return this.robot.getField().getWidth();
    }

    public int getFieldHeight() {
        return this.robot.getField().getHeight();
    }
}
