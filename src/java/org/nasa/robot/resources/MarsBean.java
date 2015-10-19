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

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.nasa.robot.exceptions.InvalidDirectionException;
import org.nasa.robot.exceptions.InvalidMessageException;
import org.nasa.robot.exceptions.InvalidPositionException;
import org.nasa.robot.entities.RobotPosition;

/**
 *
 * @author rafaelsilva
 */
@Stateless
public class MarsBean {
    @EJB RobotBean singleton;

    @GET
    @Produces("text/html")
    public String getIndex() {
        return "<html><body><h1>Robot position "+ this.getPosition().toString() +"</h1></body></html>";
    }

    public RobotPosition getPosition() {
        return this.singleton.getRobot().getPosition();
    }

    public Response sendMessage(String msg) {
        try {
            this.singleton.getRobot().receiveMessage(msg);
        } catch (InvalidMessageException ex) {
            Logger.getLogger(MarsBean.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        } catch (InvalidDirectionException ex) {
            Logger.getLogger(MarsBean.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        } catch (InvalidPositionException ex) {
            Logger.getLogger(MarsBean.class.getName()).log(Level.SEVERE, null, ex);
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
        return this.getStatus();
    }

    public Response reset() {
        this.singleton.getRobot().reset();
        return this.getStatus();
    }

    public Response getStatus() {
        String json = this.singleton.getRobot().toJson();
        return Response.ok(json, MediaType.APPLICATION_JSON).build();
    }
}
