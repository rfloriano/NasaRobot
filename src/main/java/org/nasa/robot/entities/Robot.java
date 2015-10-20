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

import org.nasa.robot.exceptions.InvalidPositionException;
import org.nasa.robot.exceptions.InvalidMessageException;
import org.nasa.robot.exceptions.InvalidDirectionException;

/**
 *
 * @author rafaelsilva
 */
public class Robot {
    private static final String NAME = "Robotson";
    private Mars field;
    private final RobotPosition position;

    public Robot(Mars field) {
        this.field = field;
        this.position = new RobotPosition(field);
    }

    public void reset() {
        this.position.reset();
    }

    public Mars getField() {
        return field;
    }

    public void setField(Mars field) {
        this.field = field;
        this.position.setField(this.field);
    }

    public void rotateLeft() throws InvalidDirectionException {
        String directions = this.position.getDirections();
        String currentDirection = this.position.getDirection();
        int index = directions.indexOf(currentDirection);
        if (index == 0) {
            index = directions.length();
        }
        index--;
        this.position.setDirection(Character.toString(directions.charAt(index)));
    }

    public void rotateRight() throws InvalidDirectionException {
        String directions = this.position.getDirections();
        String currentDirection = this.position.getDirection();
        int index = directions.indexOf(currentDirection);
        if (index == directions.length() - 1) {
            index = 0;
        } else {
            index++;
        }
        this.position.setDirection(Character.toString(directions.charAt(index)));
    }

    public RobotPosition getPosition() {
        return this.position;
    }

    public boolean receiveMessage(String message) throws InvalidMessageException, InvalidDirectionException, InvalidPositionException {
        for (char cmd: message.toCharArray()) {
            switch (cmd) {
                case 'L':
                    this.rotateLeft();
                    break;
                case 'R':
                    this.rotateRight();
                    break;
                case 'M':
                    this.position.move();
                    break;
                default:
                    throw new InvalidMessageException("Invalid '" + cmd + "' instruction");
            }
        }
        return true;
    }

    public String toJson() {
        return "{"
            + "\"name\": \"" + this.NAME + "\","
            + "\"position\": " + this.position.toJson()
        + "}";
    }

}
