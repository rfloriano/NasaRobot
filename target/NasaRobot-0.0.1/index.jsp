<%--
 DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.

 Copyright 1997-2010 Oracle and/or its affiliates. All rights reserved.

 Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 Other names may be trademarks of their respective owners.

 The contents of this file are subject to the terms of either the GNU
 General Public License Version 2 only ("GPL") or the Common
 Development and Distribution License("CDDL") (collectively, the
 "License"). You may not use this file except in compliance with the
 License. You can obtain a copy of the License at
 http://www.netbeans.org/cddl-gplv2.html
 or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 specific language governing permissions and limitations under the
 License.  When distributing the software, include this License Header
 Notice in each file and include the License file at
 nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 particular file as subject to the "Classpath" exception as provided
 by Oracle in the GPL Version 2 section of the License file that
 accompanied this code. If applicable, add the following below the
 License Header, with the fields enclosed by brackets [] replaced by
 your own identifying information:
 "Portions Copyrighted [year] [name of copyright owner]"
 
 Contributor(s):
 
 The Original Software is NetBeans. The Initial Developer of the Original
 Software is Sun Microsystems, Inc. Portions Copyright 1997-2007 Sun
 Microsystems, Inc. All Rights Reserved.
 
 If you wish your version of this file to be governed by only the CDDL
 or only the GPL Version 2, indicate your decision by adding
 "[Contributor] elects to include this software in this distribution
 under the [CDDL or GPL Version 2] license." If you do not indicate a
 single choice of license, a recipient has the option to distribute
 your version of this file under either the CDDL, the GPL Version 2 or
 to extend the choice of license to its licensees as provided above.
 However, if you add GPL Version 2 code and therefore, elected the GPL
 Version 2 license, then the option applies only if the new code is
 made subject to such option by the copyright holder.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mars - Robotson</title>
        <link href="css/mars.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="robot" scope="application" class="org.nasa.robot.resources.RobotBean" />
        
        <p class="robot-status">Robotson position: 
            <span class="position">
                <jsp:getProperty name="robot" property="position" />
            </span>
            <span class="error"></span>
        </p>
        <form class="send-command" name="send-command" action="/NasaRobot/rest/mars/" method="POST">
            <input class="upper" type="text" name="command" value="" />
            <input type="submit" value="send" name="send" />
        </form>
        
        <div class="map map-w-<jsp:getProperty name="robot" property="fieldWidth" /> map-h-<jsp:getProperty name="robot" property="fieldHeight" />">
            <div class="robot robot-l-<jsp:getProperty name="robot" property="positionX" /> robot-b-<jsp:getProperty name="robot" property="positionY" /> robot-c-<jsp:getProperty name="robot" property="positionDirection" />"></div>
        </div>
        
        <script src="js/libs/jquery/jquery.js" type="text/javascript"></script>
        <script src="js/mars-client.js" type="text/javascript"></script>
    </body>
</html>
