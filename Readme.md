# Proyecto Final Ciclo 2

# Descripcion del proyecto

De acuerdo al desarrollo de una aplicación por capas, cree un software que muestre una tabla con los datos de los Productos presentes dentro de una base de datos SQLite. El software debe permitir crear, actualizar, eliminar o consultar sobre la tabla de productos de la base de datos.

![Untitled](Proyecto%20Final%20Ciclo%202%20adbc83fa201d4a1e8d769a2369c9a306/Untitled.png)

![Untitled](Proyecto%20Final%20Ciclo%202%20adbc83fa201d4a1e8d769a2369c9a306/Untitled%201.png)

![Untitled](Proyecto%20Final%20Ciclo%202%20adbc83fa201d4a1e8d769a2369c9a306/Untitled%202.png)

# Modelos

Este modelo intenta fundir la orientación a objetos con el modelo de base de datos relacional. Como muchos de los lenguajes de programación actuales, como Java, son orientados a objetos, una estrecha integración entre los dos podría proporcionar una relativamente sencilla abstracción a los desarrolladores que programan en lenguajes orientados a objetos y que también necesitan *programar* en SQL. 

Esta integración, además, debería casi eliminar la necesidad de una constante traslación entre las tablas de la base de datos y las estructuras del lenguaje orientado a objetos, que es una tarea muy ardua.

```java
public class Producto {
    
    private long codProducto;
    private String nombre;
    private String id;
    private double temperatura;
    private double valorBase;
    
    // =========================== Constructores ===============================
    
    public Producto() {
    }

    // =========================== Getters y Setters ===========================
    public long getCodProducto() {
        return codProducto;
    }
    public void setCodProducto(long codProducto) {
        this.codProducto = codProducto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getTemperatura() {
        return temperatura;
    }
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
    public double getValorBase() {
        return valorBase;
    }
    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }
}
```

Los Modelos son la **representacion de Una tabla en una base de datos**, Por ejemplo el modelo de la tabla productos el cual tiene columnas como temperatura,valorbase nombre , id etc.

![Untitled](Proyecto%20Final%20Ciclo%202%20adbc83fa201d4a1e8d769a2369c9a306/Untitled%203.png)

Big int seria long en java VARCHAR seria String y asi con los demas campos.

---

# Conexion Base de datos con Java

## JDBC

API que nos permite la conexion a las bases de datos, con este nos podemos conectar a cualquier motor en nuestro caso sera MySQL.

Para esto tenemos que usar un **driver** - Este driver varia dependiendo del motor que estemos usando.

**Que es un driver ?** — Puente que se encarga de **conectar la aplicacion con cada motor** , Cada motor de base de datos tiene su propio Driver

![Pasos para usar JDBC](Proyecto%20Final%20Ciclo%202%20adbc83fa201d4a1e8d769a2369c9a306/Untitled%204.png)

Pasos para usar JDBC

## Maven - Gestor de repositorios

Esta vez lo haremos Manual porque no estamos trabajando una maven aplication de momento

[https://mvnrepository.com/](https://mvnrepository.com/)

![Untitled](Proyecto%20Final%20Ciclo%202%20adbc83fa201d4a1e8d769a2369c9a306/Untitled%205.png)

Se **descarga el .JAR** se crear una carpeta en la carpeta del proyecto en este caso libreria y se pega el .JAR ahi , luego añadimos la libreria asi:

![Untitled](Proyecto%20Final%20Ciclo%202%20adbc83fa201d4a1e8d769a2369c9a306/Untitled%206.png)

# Crear la clase de conexion Java

Creamos un package con una clase llamada Conexion.

Importamos algunos recursos necesarios para la configuracion de la conexion.

Para conectarnos a cualquier motor de base de datos necesitamos

![Untitled](Proyecto%20Final%20Ciclo%202%20adbc83fa201d4a1e8d769a2369c9a306/Untitled%207.png)

Parametros como: 

- Username
- Password
- Port
- Hostname
- Driver

Creamos un documento .properties donde se guardaran los datos 

![Untitled](Proyecto%20Final%20Ciclo%202%20adbc83fa201d4a1e8d769a2369c9a306/Untitled%208.png)

```java
nombre_usuario ="root"
clave_usuario="admin"
url_conexion="jdbc:mysql://localhost:3306/proyectofinaldb"
driver="com.mysql.cl.jdbc.Driver"
```

Creamos una clase Propiedades cual su principal funcion es tener un metodo que lea un archivo .properties y pida el valor de la propiedad y me lo retorne automaticamente asi:

```java
package utilidades;

import configuracion.Dominios;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Propiedades {
    
    public static String leer(String nombreArchivo, String valorPropiedad){
        Properties properties = new Properties();
        
        try {
						// Cargamos el archivo 
            properties.load(new FileInputStream(new File(Dominios.RUTA_PROYECTO + "\\data\\" + nombreArchivo + ".properties")));            
        } catch (FileNotFoundException e) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, e);
        } catch(IOException e){
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, e);
            
        }
				// Valor en properties.get(NombreVaribale) Me retorna el valor de la variable y la convierto a String
        return properties.get(valorPropiedad).toString();
    }
}
```

La clase de **conexion** debe ser **Abstracta** para que no se cree una instancia directamente si no que se herede de una clase hija

```java
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
```

## Creacion de Interfaz Operaciones

Esta interfaz contiene los metodos para implementar el CRUD agregar, consultar, borrar y actualizar asi:

```java
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
```

---

# Creacion de la navegacion.

Se creo un Jframe Principal con un un Menu Bar que contiene dos Menus, los cuales a su vez contiene Menu Items asi:

![Untitled](Proyecto%20Final%20Ciclo%202%20adbc83fa201d4a1e8d769a2369c9a306/Untitled%209.png)

Ademas se crearon varios Frames secundarios los cuales se mostraran cada vez que se presione un item del Menu de navegacion, estos Frames se conocen en Java como **JInternalFrame**.

![Untitled](Proyecto%20Final%20Ciclo%202%20adbc83fa201d4a1e8d769a2369c9a306/Untitled%2010.png)

En cuanto a la logica para que cada vez que presionemos un item del menu aparezaca el respectivo JInternalFrame tenemos:

Creamos una funcion la cual tendra la funcion de agregar el JinternalFrame a nuestra ventana Principal

```java
private void agregarVentanaPanel(JInternalFrame ventana){
// Si tiene elementos el panel que los remueva
        if (ventanaPrincipal.getComponentCount()>0) {
            ventanaPrincipal.removeAll();  
        }
        ventanaPrincipal.add(ventana);             
    }
```

En la funcion del evento Se agrega la siguiente logica:

```java
private void jMenuItemAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {                                                  
				// Declaramos variable
        AcercaDe ventanaAcercaDe;
        // Instanciamos una ventana de AcercaDe
        ventanaAcercaDe = new AcercaDe();
        // la Agregamos al panel principal y la mostramos
        agregarVentanaPanel(ventanaAcercaDe);
        ventanaAcercaDe.show();
    }
```

## **Panel Administrar**

![Untitled](Proyecto%20Final%20Ciclo%202%20adbc83fa201d4a1e8d769a2369c9a306/Untitled%2011.png)

## Logica del Panel Administrar

```java
package Formularios;

import dao.DaoProducto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Producto;

public class AdministrarProductos extends javax.swing.JInternalFrame {

    private final String columns[] = {"Codigo", "Nombre" , "Referencia" , "Temperatura", "Valor Base"};
    private final DefaultTableModel miTablita = new DefaultTableModel(columns,0);
    
    // ==================== Constructor ========================================
    public AdministrarProductos() {
        initComponents();
        cargarDatosTabla();
    }
    
    // ============= Metodo para Limpioar cajas ================================
    private void limpiarCajas(){
        TextCodigoAdmin.setText("");
        TextNombreAdmin.setText("");
        TextRefAdmin.setText("");
        TextTempAdmin.setText("");
        TextValorlBaseAdmin.setText("");
    }
    
    // ============= Metodo para cargar Registros en Tabla  ====================
    private void cargarDatosTabla(){
        // definimos variables
        List<Producto> arregloProductos;
        DaoProducto objDaoProductos;
        
        // Creamoslos objetos
        objDaoProductos = new DaoProducto();
        // llamamos al metodo consultar
        arregloProductos = objDaoProductos.consultar();
        // Para cada objeto de tipo producto asgino el atributo a la columna correspondiente.
        arregloProductos.forEach(producto -> {
           Object[] fila = new Object[5];
           fila[0] = producto.getCodProducto();
           fila[1] = producto.getNombre();
           fila[2] = producto.getId();
           fila[3] = producto.getTemperatura();
           fila[4] = producto.getValorBase();
           // Añado la fola
           miTablita.addRow(fila);        
        });
        // Aplico la tabla
        tablaProductosAdmin.setModel(miTablita);
    }

    // ============== Metodo para Limpar todos los registros de la tabla =======
    private void limpiarTabla(){
        for (int i = 0; i < tablaProductosAdmin.getRowCount(); i++) {
            miTablita.removeRow(i);
            i-=1;
        }
    }
// ========================= Logica de los eventos Botones =======================

// ============= Evento Click en una fila de la tabla  =====================    
    private void tablaProductosAdminMouseClicked(java.awt.event.MouseEvent evt) {                                                 
        
        // Obtengo el indice de la fila seleccionada por el Mouse
        Integer filaSeleccionada = tablaProductosAdmin.getSelectedRow();
        Long codProducto;
        String nombreProducto,referenciaProducto;
        Double tempProducto,valorBaseProducto;
        
        // Obtengo los valores con getValueAt Y LO seteo a Text field correspondiente
        codProducto = Long.parseLong(miTablita.getValueAt(filaSeleccionada, 0).toString());
        TextCodigoAdmin.setText(codProducto.toString());
        
        nombreProducto = miTablita.getValueAt(filaSeleccionada,1).toString();
        TextNombreAdmin.setText(nombreProducto);
        
        referenciaProducto = miTablita.getValueAt(filaSeleccionada,2).toString();
        TextRefAdmin.setText(referenciaProducto);
        
        tempProducto = Double.parseDouble(miTablita.getValueAt(filaSeleccionada, 3).toString());
        TextTempAdmin.setText(tempProducto.toString());
        
        valorBaseProducto = Double.parseDouble(miTablita.getValueAt(filaSeleccionada, 4).toString());
        TextValorlBaseAdmin.setText(valorBaseProducto.toString());
        
        
    }                                                
    
    
    // ======================== Evento Eliminar ================================
    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // Definimos las variables
        Long codProducto;
        DaoProducto objDaoProducto;
        Producto objProducto;
        
        // Capturamos valores de las cajas
        codProducto = Long.parseLong(TextCodigoAdmin.getText());
        
        // Creacion de objetos
        objDaoProducto = new DaoProducto();
        objProducto = new Producto();
        
        objProducto.setCodProducto(codProducto);
        
        // LLamos el DAO Elimanr
        if (objDaoProducto.borrar(objProducto)) {
            JOptionPane.showMessageDialog(PanelAdministrar, "Registro Borrado Correctamente");
            limpiarTabla();
            cargarDatosTabla();
            limpiarCajas();
            
        } else {
            JOptionPane.showMessageDialog(PanelAdministrar, "Ocurrio un error");
        }
        
        
        
        
    }                                           

    // ======================== Evento Actualizar ==============================
    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
        String cajaNombre,cajaReferencia;
        Double cajaTemperatura, cajaValorBase;
        Long cajaCodProducto;
        
        // Instanciamos los clases DAO y nuestro modelo Producto
        DaoProducto objDaoProducto;
        Producto objProducto;
        
        // Capturamos la informacion de las cajas
        cajaNombre = TextNombreAdmin.getText();
        cajaReferencia = TextRefAdmin.getText();
        cajaTemperatura = Double.parseDouble(TextTempAdmin.getText());
        cajaValorBase = Double.parseDouble(TextValorlBaseAdmin.getText());
        cajaCodProducto = Long.parseLong(TextCodigoAdmin.getText());
        
        if (cajaNombre.isEmpty() || cajaReferencia.isEmpty() || cajaTemperatura == 0 || cajaValorBase == 0) {
            JOptionPane.showMessageDialog(PanelAdministrar, "Todos los valores son obligatorios");
        }else{
            // Creacion de objetos
            objDaoProducto = new DaoProducto();
            objProducto = new Producto();
            
            // Pasamos los atributos a Producto
            objProducto.setNombre(cajaNombre);
            objProducto.setId(cajaReferencia);
            objProducto.setTemperatura(cajaTemperatura);
            objProducto.setValorBase(cajaValorBase);
            objProducto.setCodProducto(cajaCodProducto);
            
            if (objDaoProducto.actualizar(objProducto)) { // Recordemos que agregar retorna un booleano si es TRUE se agrego correctamente
                JOptionPane.showMessageDialog(PanelAdministrar, "Registro Actualizado Correctamente");
                limpiarCajas(); // Limpio los text fields
                limpiarTabla(); // Limpio la tabla
                cargarDatosTabla(); // Vuelvo a cargar los datos de la tabla actualizados
            } else {
                JOptionPane.showMessageDialog(PanelAdministrar, "Error: El registro no pudo ser Actualizado");
                limpiarCajas();
            }
                   
        }

    }
```

# DAO - PATRON DE DISEÑO

![Untitled](Proyecto%20Final%20Ciclo%202%20adbc83fa201d4a1e8d769a2369c9a306/Untitled%2012.png)

Creacion de la clase DAO para tabla productos asi:

Vemos que esta clase hereda de Conexion debido a que necesita hacer una conexion con la base de datos e implementa la interfaz Operaciones Y recordemos que toca implementar todos los metodos de la interfaz.

```java
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
        try {
            sql ="DELETE FROM productos WHERE codproducto=?";
            consulta = objConexion.prepareStatement(sql);
            consulta.setLong(1, objeto.getCodProducto());
            int filas  = consulta.executeUpdate();
            objConexion.close();
            return filas > 0;
        } catch (SQLException e) {
            Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public Producto buscar(long llavePK) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean actualizar(Producto objeto) {
        try {
            
            sql = "UPDATE productos SET nombre=?,id=?,temperatura=?,valorbase=? WHERE codproducto=?";
            consulta = objConexion.prepareStatement(sql); //Preparamos la sentencia SQL para pasar los parametros
            // consulta.SetTipoVariable(ordenParametro,valor)
            consulta.setString(1, objeto.getNombre()); 
            consulta.setString(2, objeto.getId());
            consulta.setDouble(3,objeto.getTemperatura());
            consulta.setDouble(4,objeto.getValorBase());
            consulta.setLong(5,objeto.getCodProducto());
            
            int filas = consulta.executeUpdate(); // ejecutamos la sentencia
            objConexion.close(); // Cerramos la conexion
            return filas > 0; // Retorna True si se realizo alguna modificacion
            
        } catch (SQLException e) {
           Logger.getLogger(DaoProducto.class.getName()).log(Level.SEVERE, null, e);
           return false; // Retorna False si Se ejecuto alguan excepcion
            
        }
    }
    
}
```
