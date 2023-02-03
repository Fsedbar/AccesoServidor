package com.daw.accesoservidor2daw.LogicaNegocio;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.daw.accesoservidor2daw.DTO.Usuario;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author lola
 */


@WebServlet(name = "SubidaArchivos", urlPatterns = {"/SubidaArchivos"})
@MultipartConfig()
public class SubidaArchivos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usu = (Usuario) request.getSession().getAttribute("usuario");
        String ruta = null;
        String asignatura = request.getParameter("asignatura");
        switch (request.getParameter("ruta")) {

            case "apache":
                ruta = "C:\\Apache24\\htdocs\\2daw\\";
                if (usu.getTipoUsuario()) {

                    switch (usu.getNombreUsuario()) {

                        case "juanma":
                            ruta += "Diseño\\Juanma";
                            break;
                        case "pedro":
                            ruta += "Clientes\\Pedro";
                            break;
                        case "lola":
                            ruta += request.getParameter("asigLola") + "\\Lola";
                            break;
                    }

                } else {
                    ruta += asignatura + "\\Alumnos";
                }
                break;

            case "tomcat":
                ruta = "C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps";
                
                //Creación usuario y sql
                
                break;
        }
        
        Part parte = request.getPart("archivo");
        parte.write(ruta+"\\"+parte.getSubmittedFileName());

        /* TODO output your page here. You may use following sample code. */
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
