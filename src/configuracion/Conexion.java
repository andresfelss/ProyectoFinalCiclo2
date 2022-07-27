
package configuracion;

// Imports para la conexion
import java.sql.Connection;
import java.sql.DriverManager;
import utilidades.Propiedades;
//Imports para Exepciones
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class Conexion {
    
    private String usuario;
    private String clave;
    private String url;
    private String driver;
    protected Connection objConexion;
    
    public Conexion(){
        // Nombre del Archivo .properties
        String nombreArchivo = "variablesBD";
        // Definimos las variables que necesitamos
        this.usuario = Propiedades.leer(nombreArchivo, "nombre_usuario").replaceAll("\"", "");
        this.clave = Propiedades.leer(nombreArchivo, "clave_usuario").replaceAll("\"", "");
        this.url = Propiedades.leer(nombreArchivo, "url_conexion").replaceAll("\"", "");
        this.driver = Propiedades.leer(nombreArchivo, "driver").replaceAll("\"", "");
        
        // LLamamos al metodo activar para activar la conexion
        activar();
    }
    
    private void activar(){
        try {
            Class.forName(driver); // Linea necesaria para saber que driver de un motor de BD estamos usando
            objConexion = DriverManager.getConnection(url,usuario,clave); // De esta forma obtenemos la conexion
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
