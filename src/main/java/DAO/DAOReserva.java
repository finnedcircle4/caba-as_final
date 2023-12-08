package DAO;

import java.sql.Date;

public class DAOReserva {

    private int _RUT_SOLICITANTE;
    private String _VCH_DV_SOLICITANTE;
    private String _VCH_NOMBRES_SOLICITANTE;
    private String _VCH_APELLIDOS_SOLICITANTE;
    private int _INT_CAT_ACOM_SOLICITANTE;
    private int _INT_CAT_DIAS_SOLICITANTE;
    private Date _DATE_FECHA_INICIO_SOLICITANTE;
    private String _VCH_CABANA_SOLICITANTE;
    
    public DAOReserva() {
    }

    public DAOReserva(int _RUT_SOLICITANTE, String _VCH_DV_SOLICITANTE, String _VCH_NOMBRES_SOLICITANTE, String _VCH_APELLIDOS_SOLICITANTE, int _INT_CAT_ACOM_SOLICITANTE, int _INT_CAT_DIAS_SOLICITANTE, Date _DATE_FECHA_INICIO_SOLICITANTE, String _VCH_CABANA_SOLICITANTE) {
        this._RUT_SOLICITANTE = _RUT_SOLICITANTE;
        this._VCH_DV_SOLICITANTE = _VCH_DV_SOLICITANTE;
        this._VCH_NOMBRES_SOLICITANTE = _VCH_NOMBRES_SOLICITANTE;
        this._VCH_APELLIDOS_SOLICITANTE = _VCH_APELLIDOS_SOLICITANTE;
        this._INT_CAT_ACOM_SOLICITANTE = _INT_CAT_ACOM_SOLICITANTE;
        this._INT_CAT_DIAS_SOLICITANTE = _INT_CAT_DIAS_SOLICITANTE;
        this._DATE_FECHA_INICIO_SOLICITANTE = _DATE_FECHA_INICIO_SOLICITANTE;
        this._VCH_CABANA_SOLICITANTE = _VCH_CABANA_SOLICITANTE;
    }

    public int getRUT_SOLICITANTE() {
        return _RUT_SOLICITANTE;
    }

    public void setRUT_SOLICITANTE(int _RUT_SOLICITANTE) {
        this._RUT_SOLICITANTE = _RUT_SOLICITANTE;
    }

    public String getVCH_DV_SOLICITANTE() {
        return _VCH_DV_SOLICITANTE;
    }

    public void setVCH_DV_SOLICITANTE(String _VCH_DV_SOLICITANTE) {
        this._VCH_DV_SOLICITANTE = _VCH_DV_SOLICITANTE;
    }

    public String getVCH_NOMBRES_SOLICITANTE() {
        return _VCH_NOMBRES_SOLICITANTE;
    }

    public void setVCH_NOMBRES_SOLICITANTE(String _VCH_NOMBRES_SOLICITANTE) {
        this._VCH_NOMBRES_SOLICITANTE = _VCH_NOMBRES_SOLICITANTE;
    }

    public String getVCH_APELLIDOS_SOLICITANTE() {
        return _VCH_APELLIDOS_SOLICITANTE;
    }

    public void setVCH_APELLIDOS_SOLICITANTE(String _VCH_APELLIDOS_SOLICITANTE) {
        this._VCH_APELLIDOS_SOLICITANTE = _VCH_APELLIDOS_SOLICITANTE;
    }

    public int getINT_CAT_ACOM_SOLICITANTE() {
        return _INT_CAT_ACOM_SOLICITANTE;
    }

    public void setINT_CAT_ACOM_SOLICITANTE(int _INT_CAT_ACOM_SOLICITANTE) {
        this._INT_CAT_ACOM_SOLICITANTE = _INT_CAT_ACOM_SOLICITANTE;
    }

    public int getINT_CAT_DIAS_SOLICITANTE() {
        return _INT_CAT_DIAS_SOLICITANTE;
    }

    public void setINT_CAT_DIAS_SOLICITANTE(int _INT_CAT_DIAS_SOLICITANTE) {
        this._INT_CAT_DIAS_SOLICITANTE = _INT_CAT_DIAS_SOLICITANTE;
    }

    public Date getDATE_FECHA_INICIO_SOLICITANTE() {
        return _DATE_FECHA_INICIO_SOLICITANTE;
    }

    public void setDATE_FECHA_INICIO_SOLICITANTE(Date _DATE_FECHA_INICIO_SOLICITANTE) {
        this._DATE_FECHA_INICIO_SOLICITANTE = _DATE_FECHA_INICIO_SOLICITANTE;
    }

    public String getVCH_CABANA_SOLICITANTE() {
        return _VCH_CABANA_SOLICITANTE;
    }

    public void setVCH_CABANA_SOLICITANTE(String _VCH_CABANA_SOLICITANTE) {
        this._VCH_CABANA_SOLICITANTE = _VCH_CABANA_SOLICITANTE;
    }
    
    

    public Boolean ValidaSubida(int rut, String dvrut, String nombres, String apellidos, int cant_acom, int cant_dias, Date fecha, String cabana) {
        Boolean isValid = true;
        
        if (rut > 0) {
            setRUT_SOLICITANTE(rut);
        } else {
            return false;
        }
        
        if (!dvrut.isEmpty()) {
            setVCH_DV_SOLICITANTE(dvrut);
        } else {
            return false;
        }
        
         if (!nombres.isEmpty()) {
            setVCH_NOMBRES_SOLICITANTE(nombres);
        } else {
            return false;
        }
          if (!apellidos.isEmpty()) {
            setVCH_APELLIDOS_SOLICITANTE(apellidos);
        } else {
            return false;
        }
          
        if (cant_acom > 0) {
            setINT_CAT_ACOM_SOLICITANTE(cant_acom);
        } else {
            return false;
        }
        if (cant_dias > 0) {
            setINT_CAT_DIAS_SOLICITANTE(cant_dias);
        } else {
            return false;
        }
        
        if (fecha != null) {
            setDATE_FECHA_INICIO_SOLICITANTE(fecha);
        } else {
            return false;
        }
        
        if (!cabana.isEmpty()) {
            setVCH_CABANA_SOLICITANTE(cabana);
        } else {
            return false;
        }

        return isValid;
    }
}
