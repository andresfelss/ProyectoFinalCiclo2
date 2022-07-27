
package interfaces;
import java.util.List;


// <T> Genericos Puede llegar cualquier tipo de objeto como producto categoria etc

public interface Operaciones<T> {
    
    // Metodo para agregar registros a las base de datos
    
    public boolean agregar(T objeto);
    
    public List<T> consultar();
    
    public boolean borrar(T objeto);
    
    public T buscar(long llavePK);
    
    public boolean actualizar (T objeto);
    
}
