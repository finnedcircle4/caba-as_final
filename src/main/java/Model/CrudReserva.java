package Model;

import DAO.DAOReserva;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class CrudReserva {

    Conexion conexion = new Conexion();

    public String CrearReserva(DAOReserva reserva) throws SQLException {
        Connection conec;
        PreparedStatement pst;
        String query = "INSERT INTO TBL_RESERVA VALUES (?,?,?,?,?,?,?,?)";
        String respuesta;

        try {
            Class.forName(conexion.getDriver());
            conec = (Connection) DriverManager.getConnection(conexion.getUrl(),
                    conexion.getUsuario(), conexion.getPassword());

            pst = (PreparedStatement) conec.prepareStatement(query);
            
            pst.setInt(1, reserva.getRUT_SOLICITANTE());
            pst.setString(2, reserva.getVCH_DV_SOLICITANTE());
            pst.setString(3, reserva.getVCH_NOMBRES_SOLICITANTE());
            pst.setString(4, reserva.getVCH_APELLIDOS_SOLICITANTE());
            pst.setInt(5, reserva.getINT_CAT_ACOM_SOLICITANTE());
            pst.setInt(6, reserva.getINT_CAT_DIAS_SOLICITANTE());
            pst.setDate(7, reserva.getDATE_FECHA_INICIO_SOLICITANTE());
            pst.setString(8, reserva.getVCH_CABANA_SOLICITANTE());

            respuesta = Integer.toString(pst.executeUpdate());
        } catch (SQLException | ClassNotFoundException ex) {
            respuesta = ex.getMessage();
        }
        return respuesta;
    }

    public List<DAOReserva> ListarTodos() {
        Connection connection;
        PreparedStatement pst;
        String query = "SELECT * FROM TBL_RESERVA";
        ResultSet rs;

        List<DAOReserva> listaReservas = new ArrayList<>();

        try {
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(),
                    conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);

            rs = pst.executeQuery();
            while (rs.next()) {
                DAOReserva reserva = new DAOReserva();
                reserva.setRUT_SOLICITANTE(rs.getInt("RUT_SOLICITANTE"));
                reserva.setVCH_DV_SOLICITANTE(rs.getString("VCH_DV_SOLICITANTE"));
                reserva.setVCH_NOMBRES_SOLICITANTE(rs.getString("VCH_NOMBRES_SOLICITANTE"));
                reserva.setVCH_APELLIDOS_SOLICITANTE(rs.getString("VCH_APELLIDOS_SOLICITANTE"));
                reserva.setINT_CAT_ACOM_SOLICITANTE(rs.getInt("INT_CAT_ACOM_SOLICITANTE"));
                reserva.setINT_CAT_DIAS_SOLICITANTE(rs.getInt("INT_CAT_DIAS_SOLICITANTE"));
                reserva.setDATE_FECHA_INICIO_SOLICITANTE(rs.getDate("DATE_FECHA_INICIO_SOLICITANTE"));
                reserva.setVCH_CABANA_SOLICITANTE(rs.getString("VCH_CABANA_SOLICITANTE"));

                listaReservas.add(reserva);
            }
            rs.close();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.getMessage();
        }
        return listaReservas;
    }

    public List<DAOReserva> ListarPorCabana(String cabana) {
        Connection connection;
        PreparedStatement pst;
        String query = "SELECT * FROM TBL_RESERVA WHERE VCH_CABANA_SOLICITANTE = '" + cabana + "'";
        ResultSet rs;

        List<DAOReserva> listaCabanas = new ArrayList<>();

        try {
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(),
                    conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);

            rs = pst.executeQuery();
            while (rs.next()) {
                DAOReserva reserva = new DAOReserva();
                reserva.setRUT_SOLICITANTE(rs.getInt("RUT_SOLICITANTE"));
                reserva.setVCH_DV_SOLICITANTE(rs.getString("VCH_DV_SOLICITANTE"));
                reserva.setVCH_NOMBRES_SOLICITANTE(rs.getString("VCH_NOMBRES_SOLICITANTE"));
                reserva.setVCH_APELLIDOS_SOLICITANTE(rs.getString("VCH_APELLIDOS_SOLICITANTE"));
                reserva.setINT_CAT_ACOM_SOLICITANTE(rs.getInt("INT_CAT_ACOM_SOLICITANTE"));
                reserva.setINT_CAT_DIAS_SOLICITANTE(rs.getInt("INT_CAT_DIAS_SOLICITANTE"));
                reserva.setDATE_FECHA_INICIO_SOLICITANTE(rs.getDate("DATE_FECHA_INICIO_SOLICITANTE"));
                reserva.setVCH_CABANA_SOLICITANTE(rs.getString("VCH_CABANA_SOLICITANTE"));

                listaCabanas.add(reserva);
            }
            rs.close();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.getMessage();
        }
        return listaCabanas;
    }

    public Boolean Disponibilidad(String cabana, Date fecha_reserva) {
        
        Boolean isDisponible = true;
        Connection connection;
        PreparedStatement pst;
        String query = "SELECT * FROM TBL_RESERVA WHERE VCH_CABANA_SOLICITANTE = '" + cabana + "'";
        ResultSet rs;

        List<DAOReserva> list = new ArrayList<>();

        try {
            Class.forName(conexion.getDriver());
            connection = (Connection) DriverManager.getConnection(conexion.getUrl(),
                    conexion.getUsuario(), conexion.getPassword());
            pst = connection.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {
                DAOReserva reserva = new DAOReserva();
                reserva.setRUT_SOLICITANTE(rs.getInt("RUT_SOLICITANTE"));
                reserva.setVCH_DV_SOLICITANTE(rs.getString("VCH_DV_SOLICITANTE"));
                reserva.setVCH_NOMBRES_SOLICITANTE(rs.getString("VCH_NOMBRES_SOLICITANTE"));
                reserva.setVCH_APELLIDOS_SOLICITANTE(rs.getString("VCH_APELLIDOS_SOLICITANTE"));
                reserva.setINT_CAT_ACOM_SOLICITANTE(rs.getInt("INT_CAT_ACOM_SOLICITANTE"));
                reserva.setINT_CAT_DIAS_SOLICITANTE(rs.getInt("INT_CAT_DIAS_SOLICITANTE"));
                reserva.setDATE_FECHA_INICIO_SOLICITANTE(rs.getDate("DATE_FECHA_INICIO_SOLICITANTE"));
                reserva.setVCH_CABANA_SOLICITANTE(rs.getString("VCH_CABANA_SOLICITANTE"));

                list.add(reserva);
            }
            rs.close();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.getMessage();
        }

        for (int i = 0; i < list.size(); i++) {

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(list.get(i).getDATE_FECHA_INICIO_SOLICITANTE());
            calendar.add(Calendar.DAY_OF_YEAR, list.get(i).getINT_CAT_DIAS_SOLICITANTE());
            java.util.Date fecha_f = calendar.getTime();

            Date fecha_inicio = list.get(i).getDATE_FECHA_INICIO_SOLICITANTE();
            Date fecha_fin = new Date(fecha_f.getTime());

            if ((fecha_reserva.after(fecha_inicio) | fecha_reserva.equals(fecha_inicio))
                    & (fecha_reserva.before(fecha_fin) | fecha_reserva.equals(fecha_fin))) {
                isDisponible = false;
                break;
            }
        }
        return isDisponible;
    }
    
    public Boolean cantidad(int cantidad,String cabana){
        Boolean isOk = true;
        int cabanaValue=0;
        if(cabana.equals("Pequena") ){
            cabanaValue = 4;
            if(cantidad+1 > cabanaValue){
                isOk = false;
            }
        }
        if(cabana.equals("Mediana") ){
            cabanaValue = 8;
            if(cantidad+1 > cabanaValue){
                isOk = false;
            }
        }
        if(cabana.equals("Grande") ){
            cabanaValue = 12;
            if(cantidad+1 > cabanaValue){
                isOk = false;
            }
        }

         return isOk;
    }

}
