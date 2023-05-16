package etu1773.framework.servlet;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;

import javax.print.attribute.standard.OutputDeviceAssigned;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import etu1773.framework.*;
/**
 *
 * @author itu
 */
public class FrontServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public HashMap<String,Mapping> MappingUrls=new HashMap<String,Mapping>();

    public HashMap<String, Mapping> getMappingUrls() {
        return MappingUrls;
    }

    public void setMappingUrls(HashMap<String, Mapping> mappingUrls) {
        MappingUrls = mappingUrls;
    }

    public void init() {
        String path="C:/Users/LENOVO/projets/java_Framework/main_framework";
        String packageName="src";
        Utilitaire u =new Utilitaire();
        ArrayList<Class> allclasses;
        try {
            allclasses = u.findClassesInPackage(path,packageName);
            setMappingUrls(u.findAllAnnotatedMethods(allclasses));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    
    protected String giveView(HttpServletRequest req){
        String slug =req.getPathInfo();
        Object obj=null;
        ModelView mv =new ModelView();
            if(slug!=null){
                for(Entry<String, Mapping> entry : this.getMappingUrls().entrySet() ){
                    if(entry.getKey()==slug){
                        String className=entry.getValue().getClassName();
                        mv.view=className;
                        try {
                            Class<?> clazz = Class.forName(className);
                            try {
                                obj = clazz.getDeclaredConstructor().newInstance();
                            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                                    | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        } catch (ClassNotFoundException e) {
                            // Gérer l'exception en cas de classe introuvable
                        }
                    }
                }
            }
        return mv.view;
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Utilitaire ut=new Utilitaire();

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            // out.println("<h1>Servlet FrontServlet at " + ut.getUrl(request) + "</h1>");
            init();
            String classview=giveView(request);
            RequestDispatcher dispatch =request.getRequestDispatcher(classview+".jsp");
            dispatch.forward(request,response);
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public static void main(String[] args) {
        Mapping e =new Mapping();
    }

    /** 
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
