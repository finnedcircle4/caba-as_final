/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAO.DAOReserva;
import Model.CrudReserva;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Listar_cabanas extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        CrudReserva cr = new CrudReserva();
        String cabana = request.getParameter("cabana");
        List<DAOReserva> listacabana = cr.ListarPorCabana(cabana);

        String respuesta = "";

        if (!listacabana.isEmpty()) {
            respuesta += "<table border='1' class='tableVenta' align='center' style='display:inline-block; margin-top:20px'>"
                    + "<tr><th>RUT</th><th>NOMBRES</th><th>APELLIDOS</th><th>CANT. ACOMPAÑANTES</th>"
                    + "<th>CANT. DIAS</th><th>FECHA DE INICIO</th><th>TIPO DE CABAÑA</th></tr>";

            for (int i = 0; i < listacabana.size(); i++) {
                respuesta += elementBuilder(listacabana.get(i));
            }
            respuesta += "</table>";
            request.setAttribute("respuesta", "<div class='formulario'>" + respuesta + "</div>");
            request.getRequestDispatcher("Listar_Cabanas.jsp").forward(request, response);
        } else {
            String mensaje = "<div class='formulario'><label class=\"label-item\"><b>"
                    + "No se han encontrado elementos</b></label></div>";
            request.setAttribute("respuesta", mensaje);
            request.getRequestDispatcher("Listar_Cabanas.jsp").forward(request, response);
        }

    }

    protected String elementBuilder(DAOReserva reserva) {

        String rut = "<tr>"
                + "<td><label class=\"label-item\"><b>" + reserva.getRUT_SOLICITANTE() +"-"+ reserva.getVCH_DV_SOLICITANTE()+ "</b></label></td>";

        String nombres = "<td><label class=\"label-item\"><b>" + reserva.getVCH_NOMBRES_SOLICITANTE()
                + "</b></label></td>";
        String apellidos = "<td><label class=\"label-item\"><b>" + reserva.getVCH_APELLIDOS_SOLICITANTE()
                + "</b></label></td>";
        String cant_acom = "<td><label class=\"label-item\"><b>" + reserva.getINT_CAT_ACOM_SOLICITANTE()
                + "</b></label></td>";
        String cant_dias = "<td><label class=\"label-item\"><b>" + reserva.getINT_CAT_DIAS_SOLICITANTE()
                + "</b></label></td>";
        String fecha = "<td><label class=\"label-item\"><b>" + reserva.getDATE_FECHA_INICIO_SOLICITANTE()
                + "</b></label></td>";
        String cabana = "<td><label class=\"label-item\"><b>" + reserva.getVCH_CABANA_SOLICITANTE()
                + "</b></label></td></tr>";

        String elemento = rut + nombres + apellidos + cant_acom + cant_dias + fecha + cabana;
        return elemento;
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
