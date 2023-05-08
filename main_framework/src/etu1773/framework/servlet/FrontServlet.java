package etu1773.framework.servlet;

import etu1773.framework.*;
import java.util.*;
import java.util.Map.Entry;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.print.attribute.standard.OutputDeviceAssigned;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontServlet extends HttpServlet {

    public HashMap<String,Mapping> MappingUrls;

    public HashMap<String, Mapping> getMappingUrls() {
        return MappingUrls;
    }

    public void setMappingUrls(HashMap<String, Mapping> mappingUrls) {
        MappingUrls = mappingUrls;
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello World!</h1>");
        out.println("</body></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public void init() throws Exception {
        String path="C:/Users/LENOVO/projets/java_Framework/main_framework";
        String packageName="src";
        Utilitaire u =new Utilitaire();
        ArrayList<Class> allclasses=u.findClassesInPackage(path,packageName);
        setMappingUrls(u.findAllAnnotatedMethods(allclasses));
    }

    public void destroy() {
        
    }

    public static void main(String[] args) {
        FrontServlet fs =new FrontServlet();
        try {
        fs.init();
            for (Entry<String, Mapping> entry : fs.MappingUrls.entrySet()) {
                System.out.println("Url : " + entry.getKey() + ", ClassName : " + entry.getValue().getClassName() +", MethodName :"+entry.getValue().getMethod() +"");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}