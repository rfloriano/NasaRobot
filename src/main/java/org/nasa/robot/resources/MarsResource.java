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

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author rafaelsilva
 */
@Stateless
@Path("/mars")
public class MarsResource {

    @EJB MarsBean mars;

    /**
     * Retrieves representation of an instance of org.nasa.robot.MarsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getGreeting() {
        return this.mars.getIndex();
    }

    /**
     * POST method for updating an instance of MarsResource
     * @param msg
     * @return an HTTP response with content of the updated or created resource.
     */
    @Path("{msg}")
    @POST
    @Produces("text/json")
    public Response sendMessage(@PathParam("msg") String msg) {
        return this.mars.sendMessage(msg);
    }

    /**
     * GET method for get status an instance of MarsResource
     * @return an HTTP response with content of the updated or created resource.
     */
    @Path("status")
    @GET
    @Produces("text/json")
    public Response status() {
        return this.mars.getStatus();
    }

    /**
     * GET method for get status an instance of MarsResource
     * @return an HTTP response with content of the updated or created resource.
     */
    @Path("reset")
    @POST
    @Produces("text/json")
    public Response reset() {
        return this.mars.reset();
    }
}
