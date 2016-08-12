 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.Ctrl;

import com.sv.udb.Modelos.TipoDocu;
import com.sv.udb.Modelos.UbicGeog;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aerc
 */
 
public class UbicGeogCtrl {
        
    public List<UbicGeog> consTodo()
    {
       List<UbicGeog> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("Select * from ubic_geog");
            ResultSet rs = cmd.executeQuery();
            while(rs.next())
            {   
                resp.add(new UbicGeog(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5), rs.getBlob(6)));
            }
        }
        catch(Exception err)
        {
            err.printStackTrace();
            System.out.print(err);
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
    
}
