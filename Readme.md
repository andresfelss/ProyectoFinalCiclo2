# Proyecto Final Ciclo 2

# Descripcion del proyecto

De acuerdo al desarrollo de una aplicación por capas, cree un software que muestre una tabla con los datos de los Productos presentes dentro de una base de datos SQLite. El software debe permitir crear, actualizar, eliminar o consultar sobre la tabla de productos de la base de datos.

De forma **OPCIONAL**, puede crear una tabla adicional llamada Farmacias, y hacer una pestaña específica con las mismas funcionalidades CRUD que en la pestaña Productos.

![Untitled](Proyecto%20Final%20Ciclo%202%204960de01d28a47afa0617a88a7bd2877/Untitled.png)

![Untitled](Proyecto%20Final%20Ciclo%202%204960de01d28a47afa0617a88a7bd2877/Untitled%201.png)

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

![Untitled](Proyecto%20Final%20Ciclo%202%204960de01d28a47afa0617a88a7bd2877/Untitled%202.png)

Big int seria long en java VARCHAR seria String y asi con los demas campos.

---

# Conexion Base de datos con Java

## JDBC

API que nos permite la conexion a las bases de datos, con este nos podemos conectar a cualquier motor en nuestro caso sera MySQL.

Para esto tenemos que usar un **driver** - Este driver varia dependiendo del motor que estemos usando.

**Que es un driver ?** — Puente que se encarga de **conectar la aplicacion con cada motor** , Cada motor de base de datos tiene su propio Driver

![Pasos para usar JDBC](Proyecto%20Final%20Ciclo%202%204960de01d28a47afa0617a88a7bd2877/Untitled%203.png)

Pasos para usar JDBC

## Maven - Gestor de repositorios

Esta vez lo haremos Manual porque no estamos trabajando una maven aplication de momento

[https://mvnrepository.com/](https://mvnrepository.com/)

![Untitled](Proyecto%20Final%20Ciclo%202%204960de01d28a47afa0617a88a7bd2877/Untitled%204.png)

Se **descarga el .JAR** se crear una carpeta en la carpeta del proyecto en este caso libreria y se pega el .JAR ahi , luego añadimos la libreria asi:

![Untitled](Proyecto%20Final%20Ciclo%202%204960de01d28a47afa0617a88a7bd2877/Untitled%205.png)

# Crear la clase de conexion Java

Creamos un package con una clase llamada Conexion.

Importamos algunos recursos necesarios para la configuracion de la conexion.

Para conectarnos a cualquier motor de base de datos necesitamos

![Untitled](Proyecto%20Final%20Ciclo%202%204960de01d28a47afa0617a88a7bd2877/Untitled%206.png)

Parametros como: 

- Username
- Password
- Port
- Hostname
- Driver

Creamos un documento .properties donde se guardaran los datos 

![Untitled](Proyecto%20Final%20Ciclo%202%204960de01d28a47afa0617a88a7bd2877/Untitled%207.png)

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
            properties.load(new FileInputStream(new File(Dominios.RUTA_PROYECTO + "\\data\\" + nombreArchivo + ".properties")));            
        } catch (FileNotFoundException e) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, e);
        } catch(IOException e){
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, e);
            
        }
        return properties.get(valorPropiedad).toString();
    }
}
```

La clase de **conexion** debe ser **Abstracta** para que no se cree una instancia directamente si no que se herede de una clase hija

```java
package configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilidades.Propiedades;

public abstract class Conexion {
    
    private String usuario;
    private String clave;
    private String url;
    private String driver;
    protected Connection objConexion;
    
    public Conexion(){
        String nombreArchivo = "variablesBD";
        this.usuario = Propiedades.leer(nombreArchivo, "nombre_usuario").replaceAll("\"", " ");
        this.clave = Propiedades.leer(nombreArchivo, "clave_usuario").replaceAll("\"", " ");
        this.url = Propiedades.leer(nombreArchivo, "url_conexion").replaceAll("\"", " ");
        this.driver = Propiedades.leer(nombreArchivo, "driver").replaceAll("\"", " ");
        
        // LLamamos al metodo activar para activar la conexion
        activar();
    }
    
    private void activar(){
        try {
            Class.forName(driver);
            objConexion = DriverManager.getConnection(url,usuario,clave);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
```

## Creacion de Interfaz Operaciones

Esta interfaz contiene los metodos para implementar el CRUD agregar, consultar, borrar y buscar asi:

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
    
}
```

---

# Creacion de la navegacion.

Se creo un Jframe Principal con un un Menu Bar que contiene dos Menus, los cuales a su vez contiene Menu Items asi:

![Untitled](Proyecto%20Final%20Ciclo%202%204960de01d28a47afa0617a88a7bd2877/Untitled%208.png)

Ademas se crearon varios Frames secundarios los cuales se mostraran cada vez que se presione un item del Menu de navegacion, estos Frames se conocen en Java como **JInternalFrame**.

![Untitled](Proyecto%20Final%20Ciclo%202%204960de01d28a47afa0617a88a7bd2877/Untitled%209.png)

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

# DAO - PATRON DE DISEÑO

![Untitled](Proyecto%20Final%20Ciclo%202%204960de01d28a47afa0617a88a7bd2877/Untitled%2010.png)

Creacion de la clase DAO para tabla productos asi:

Vemos que esta clase hereda de Conexion debido a que neceista hacer una conexion con la base de datos e implementa la interfaz Operaciones Y recordemos que toca implementar todos los metodos de la interfaz.

```java
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
```