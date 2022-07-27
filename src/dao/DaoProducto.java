
package dao;

import configuracion.Conexion;
import interfaces.Operaciones;
import java.util.List;
import modelos.Producto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;

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
            return filas > 0; // Retorna True si se realizo alguna modificacion
            
        } catch (SQLException e) {
           Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, e);
           return false; // Retorna False si Se ejecuto alguan excepcion
            
        }
    }

    @Override
    public List<Producto> consultar() {
        try {
            // Lo que me arrojara la Base de datos es un objeto tipo Result Set 
            ResultSet rs; // L instancio
            // Pasare los registros de dicho Rs a un Array que si puedo manipular con Java
            List <Producto> arregloProductos = new ArrayList<>();
            
            // Escribo el Query para seleccionar y digo que lo quiero en Orden ASCENDENTE
            sql = "SELECT codproducto,nombre,id,temperatura,valorbase FROM productos ORDER BY codproducto ASC";
            // Preparo el QUERY
            consulta = objConexion.prepareStatement(sql);
            // Ejecutamos la consulta
            rs = consulta.executeQuery();
            
            // ======== Itero con el Result Set Que me devolvio la BD ==========
            while(rs.next()){
                
                // Creo un objeto Producto
                Producto objProducto = new Producto();
                
                // Transformo esos valores de Result Set que  vienen de la base de datos
                objProducto.setCodProducto(Long.parseLong(rs.getObject(1).toString()));
                objProducto.setNombre(rs.getObject(2).toString());
                objProducto.setId(rs.getObject(3).toString());
                objProducto.setTemperatura(Double.parseDouble(rs.getObject(4).toString()));
                objProducto.setValorBase(Double.parseDouble(rs.getObject(5).toString()));
                
                // Agrego cada Producto ya creado a mi Array List 
                arregloProductos.add(objProducto); 
            }
                // Una vez todos los Objetos agregados se cierra la conexion
                objConexion.close();
                // Retorno el arreglo
                return arregloProductos;
            
            
        } catch (NumberFormatException | SQLException e) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
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
