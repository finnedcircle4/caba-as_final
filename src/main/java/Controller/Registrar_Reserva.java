package Controller;

import DAO.DAOReserva;
import Model.CrudReserva;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registrar_Reserva extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String mensaje = "";
        String insertaReserva;
        try {

            DAOReserva reserva = validacionUsuario(request);
            if (reserva != null) {
                CrudReserva cr = new CrudReserva();
                
                if (cr.cantidad(reserva.getINT_CAT_ACOM_SOLICITANTE(), reserva.getVCH_CABANA_SOLICITANTE())) {
                    
                    if (cr.Disponibilidad(reserva.getVCH_CABANA_SOLICITANTE(), reserva.getDATE_FECHA_INICIO_SOLICITANTE())) {
                        
                        insertaReserva = cr.CrearReserva(reserva);
                        mensaje += insertaReserva;
                        if (Integer.parseInt(insertaReserva) != 0) {
                            mensaje = "Reserva grabada con éxito";
                        }
                    } else {
                        mensaje = "No existe disponibilidad para la fecha seleccionada.";

                    }
                }else{
                    mensaje = "La cantidad de asistentes excede la capacidad de la cabaña solicitada.";
                }

            } else {
                mensaje = "Error al generar reserva, intente nuevamente y compruebe que los datos sean correctos.";
            }

        } catch (NumberFormatException | ParseException ex) {
            mensaje = "Rut ya tiene reservada una cabaña. Intente con otro rut.";
        }

        request.setAttribute("respuesta", mensaje);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    protected DAOReserva validacionUsuario(HttpServletRequest request) throws ParseException {
        DAOReserva reserva = new DAOReserva();

        reserva.setRUT_SOLICITANTE(Integer.parseInt(request.getParameter("rut")));
        reserva.setVCH_DV_SOLICITANTE(request.getParameter("dv"));
        reserva.setVCH_NOMBRES_SOLICITANTE(request.getParameter("nombres"));
        reserva.setVCH_APELLIDOS_SOLICITANTE(request.getParameter("apellidos"));
        reserva.setINT_CAT_ACOM_SOLICITANTE(Integer.parseInt(request.getParameter("acom")));
        reserva.setINT_CAT_DIAS_SOLICITANTE(Integer.parseInt(request.getParameter("dias")));
        reserva.setVCH_CABANA_SOLICITANTE(request.getParameter("cabana"));
        String fechastring = request.getParameter("fecha");
        SimpleDateFormat fechaformat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaparse = fechaformat.parse(fechastring);
        reserva.setDATE_FECHA_INICIO_SOLICITANTE(new Date(fechaparse.getTime()));

        return reserva;

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Registrar_Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Registrar_Reserva.class.getName()).log(Level.SEVERE, null, ex);
        }
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
