package org.aric.rose.hello.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstSlt extends HttpServlet {
    public void service(HttpServletRequest request,
                        HttpServletResponse response)
            throws ServletException, java.io.IOException {
        //RequestDispatcher rd = request.getRequestDispatcher("views/index.jsp");
        //rd.forward(request, response);
    }
}