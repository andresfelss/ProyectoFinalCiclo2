
package dao;

import configuracion.Conexion;
import interfaces.Operaciones;
import java.util.List;
import modelos.Producto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoProducto extends Conexion implements Operaciones<Producto> {
    
    private String sql;
    private PreparedStatement consulta;

    @Override
    public boolean agregar(Producto objeto) {
        try {
            // En este caso se hace querys nativas Con FRAMEWORKS como Sping usan ORMS.
            sql = "INSERT INTO productos (nombre,id,temperatura,valorbase) VALUES (?,?,?,?)";
            consulta = objConexion.prepareStatement(sql); //Preparamos la sentencia SQL para pasar los parametros
            // consulta.SetTipoVariable(ordenParametro,valor)
            consulta.setString(1, objeto.getNombre()); 
            consulta.setString(2, objeto.getId());
            consulta.setDouble(3,objeto.getTemperatura());
            consulta.setDouble(4,objeto.getValorBase());
            int filas = consulta.executeUpdate(); // ejecutamos la sentencia
            objConexion.close(); // Cerramos la conexion
            return filas > 0;
            
        } catch (SQLException e) {
           Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, e);
           return false;
            
        }
    }

    @Override
    public List<Producto> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean borrar(Producto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Producto buscar(long llavePK) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
