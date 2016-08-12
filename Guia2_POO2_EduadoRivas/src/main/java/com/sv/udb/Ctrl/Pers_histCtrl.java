/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Ctrl;

import com.sv.udb.Modelos.Equi_comp;
import com.sv.udb.Modelos.Luga_acce;
import com.sv.udb.Modelos.Pers;
import com.sv.udb.Modelos.Pers_hist;
import com.sv.udb.Modelos.Tipo_pers;
import com.sv.udb.Modelos.UbicGeog;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aerc
 */
public class Pers_histCtrl {
    public List<Pers_hist> consTodo()
    {
        List<Pers_hist> resp = new ArrayList<>();
        Connection cn = new Conexion().getConn();
        try
        {
            String consulta = "select * from pers_hist inner join pers on pers.CODI_PERS = pers_hist.CODI_PERS inner join tipo_pers on tipo_pers.CODI_TIPO_PERS = pers_hist.CODI_TIPO_PERS inner join ubic_geog on ubic_geog.CODI_UBIC_GEOG = pers_hist.CODI_UBIC_GEOG";
            PreparedStatement cmd = cn.prepareStatement(consulta);
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {
                    resp.add(new Pers_hist(rs.getInt(1), new Pers(rs.getInt(10), rs.getString(11), rs.getString(12), rs.getBlob(13), null, rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), new UbicGeog(rs.getInt(29), rs.getString(30), rs.getInt(31), rs.getString(32), rs.getString(33), rs.getBlob(34)), rs.getString(21), rs.getString(22), rs.getInt(23)), rs.getString(3), rs.getString(4), new Tipo_pers(rs.getInt(24), rs.getString(25), rs.getString(26), rs.getString(27), rs.getBlob(28)), new UbicGeog(rs.getInt(29), rs.getString(30), rs.getInt(31), rs.getString(32), rs.getString(33), rs.getBlob(34)), rs.getString(7), rs.getString(8), rs.getBlob(9)));
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            if(cn != null)
            {
                try
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
                catch(SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        return resp;
    }
}
