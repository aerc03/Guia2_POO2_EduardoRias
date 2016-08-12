/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.vista;

import com.sv.udb.Ctrl.PersCtrl;
import com.sv.udb.Modelos.Pers;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aerc
 */
@WebServlet(name = "PersServ", urlPatterns = {"/PersServ"})
public class PersServ extends HttpServlet {

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
        boolean esValido = request.getMethod().equals("POST");
        if(esValido)
        {
            String mens = "";
            String CRUD = request.getParameter("CursBoton");
            if(CRUD.equals("Guardar"))
            {
                Pers p = new Pers();
                p.setNomb_pers(request.getParameter("nom"));
                p.setApel_pers(request.getParameter("ape"));
                //p.setFoto(request.getContentLengthLong(""));
                p.setApel_pers(request.getParameter("cmbTipo"));
                p.setApel_pers(request.getParameter("gen"));
                p.setApel_pers(request.getParameter("nac"));
                p.setApel_pers(request.getParameter("dui"));
                p.setApel_pers(request.getParameter("nit"));
                p.setApel_pers(request.getParameter("san"));
                p.setApel_pers(request.getParameter("ubi"));
                //mens = new PersCtrl().guar(objeEqui) ? "Datos guardados" : "Datos NO guardados";
            }
            else if(CRUD.equals("Modificar"))
            {
//                Piezas pi = new Piezas();
//                pi.setCodi_piez(Integer.parseInt(request.getParameter("codi_piez")));
//                pi.setNomb_piez(request.getParameter("nomb_piez"));
//                pi.setTipo_piez(request.getParameter("tipo_piez"));
//                pi.setMarc_piez(request.getParameter("marc_piez"));
//                if(pi != null)
//                {
//                    mens = new PiezasCtrl().modi(pi) ? "Datos guardados" : "Datos NO guardados";
//                }
            }
            else if(CRUD.equals("Eliminar"))
            {
//                Piezas pi = new Piezas();
//                pi.setCodi_piez(Integer.parseInt(request.getParameter("codi_piez")));
//                pi.setNomb_piez(request.getParameter("nomb_piez"));
//                pi.setTipo_piez(request.getParameter("tipo_piez"));
//                pi.setMarc_piez(request.getParameter("marc_piez"));
//                if(pi != null)
//                {
//                    mens = new PiezasCtrl().elim(pi) ? "Datos guardados" : "Datos NO guardados";
//                }
            }
            else if(CRUD.equals("Consultar"))
            {
//                int codi_piez = Integer.parseInt(request.getParameter("codiPiezRadi") == null ? "0" : request.getParameter("codiPiezRadi"));
//                Piezas objePiez = new PiezasCtrl().cons(codi_piez);
//                if(objePiez != null)
//                {
//                    request.setAttribute("codi", objePiez.getCodi_piez());
//                    request.setAttribute("nomb", objePiez.getNomb_piez());
//                    request.setAttribute("tipo", objePiez.getTipo_piez());
//                    request.setAttribute("marc", objePiez.getMarc_piez());
//                }
            }
            request.setAttribute("mensAler", mens);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        else
        {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
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
