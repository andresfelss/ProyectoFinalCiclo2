
package dao;

import configuracion.Conexion;
import interfaces.Operaciones;
import java.util.List;
import modelos.Producto;

public class DaoProducto extends Conexion implements Operaciones<Producto> {

    @Override
    public boolean agregar(Producto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); 
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
