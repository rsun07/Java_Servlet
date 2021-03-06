package pers.xiaoming.javaweb;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("\n\nRunning Servlet:");

        ServletContext context = request.getServletContext();

        String contextNamespace = context.getInitParameter("namespace");
        System.out.println("Context Init param, namespace : " + contextNamespace);

        String contextAttr = (String) context.getAttribute("filter_attr");
        String requestAttr = (String) request.getAttribute("filter_attr");
        System.out.println("Filter context attribute, servlet_attr : " + contextAttr);
        System.out.println("Filter request attribute, servlet_attr : " + requestAttr);

        context.setAttribute("servlet_attr", "servlet_context_attr");
        request.setAttribute("servlet_attr", "servlet_request_attr");
    }
}
