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
import org.nasa.robot.exceptions.InvalidDirectionException;

/**
 *
 * @author rafaelsilva
 */
public class RobotPosition {
    private final String directions = "NESW";
    private int x;
    private int y;
    private String direction;
    private Mars field;

    public RobotPosition(Mars field) {
        this.field = field;
        this.reset();
    }

    @Override
    public String toString() {
        return "("+ this.x + ", " + this.y + ", " + this.direction +")";
    }

    public String toString(int x, int y, String direction) {
        return "("+ x + ", " + y + ", " + direction +")";
    }

    public String toJson() {
        return "{"
            + "\"name\": \"" + this.toString() + "\","
            + "\"x\": \"" + this.getX() + "\","
            + "\"y\": \"" + this.getY() + "\","
            + "\"compass\": \"" + this.getDirection() + "\""
        + "}";
    }

    public void reset() {
        this.x = 0;
        this.y = 0;
        this.direction = "N";
    }

    public void setField(Mars field) {
        this.field = field;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) throws InvalidPositionException {
        if (this.positionIsAvailable(field, x, this.y)) {
            this.x = x;
        } else {
            throw new InvalidPositionException("Position " + this.toString(x, this.y, this.direction) + " is out of range");
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) throws InvalidPositionException {
        if (this.positionIsAvailable(field, this.x, y)) {
            this.y = y;
        } else {
            throw new InvalidPositionException("Position " + this.toString(this.x, y, this.direction) + " is out of range");
        }
    }

    public void incX() throws InvalidPositionException {
        this.setX(this.x + 1);
    }

    public void decX() throws InvalidPositionException {
        this.setX(this.x - 1);
    }

    public void incY() throws InvalidPositionException {
        this.setY(this.y + 1);
    }

    public void decY() throws InvalidPositionException {
        this.setY(this.y - 1);
    }

    public boolean positionIsAvailable(Mars field, int x, int y) {
        return x > -1 && y > -1 && x < field.getWidth() && y < field.getHeight();
    }

    public void move() throws InvalidPositionException {
        if (this.direction.equals("N")){
            this.incY();
        } else if (this.direction.equals("S")) {
            this.decY();
        } else if (this.direction.equals("E")) {
            this.incX();
        } else if (this.direction.equals("W")) {
            this.decX();
        }
    }

    public String getDirections() {
        return directions;
    }

    public String getDirection() {
        return this.direction;
    }

    public void validateDirection(String direction) throws InvalidDirectionException {
        if (!(this.directions.contains(direction))) {
            throw new InvalidDirectionException("Invalid '" + direction + "' direction");
        }
    }

    public void setDirection(String direction) throws InvalidDirectionException {
        this.validateDirection(direction);
        this.direction = direction;
    }
}
