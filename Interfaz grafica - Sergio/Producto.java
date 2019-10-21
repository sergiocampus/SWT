package application;

import java.time.LocalDate;

import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.DoubleProperty;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Producto
{
    private final StringProperty nombre;
    private final IntegerProperty unidades;
    private final DoubleProperty precio;
    private final ObjectProperty<LocalDate> fechaFabricacion;

    public Producto() 
    {
        this(null, 0, 0, null);
    }
    
    public Producto(String nombre, int unidades, double precio, LocalDate fechaFabricacion)
    {
        this.nombre = new SimpleStringProperty(nombre);
        this.unidades = new SimpleIntegerProperty(unidades);
        this.precio = new SimpleDoubleProperty(precio);
        this.fechaFabricacion = new SimpleObjectProperty<LocalDate>(fechaFabricacion);
    }
    
    //Nombre
    public String getNombre()
    {
        return nombre.get();
    }

    public void setNombre(String nombre)
    {
        this.nombre.set(nombre);
    }
    
    public StringProperty nombreProperty()
    {
        return nombre;
    }
    
    //Unidades
    public int getUnidades()
    {
        return unidades.get();
    }

    public void setUnidades(int unidades)
    {
        this.unidades.set(unidades);
    }
    
    public IntegerProperty unidadesProperty()
    {
        return unidades;
    }
    
    //Precio
    public double getPrecio()
    {
        return precio.get();
    }

    public void setPrecio(double precio)
    {
        this.precio.set(precio);
    }
    
    public DoubleProperty precioProperty()
    {
        return precio;
    }

    //Fecha
    public LocalDate getFecha()
    {
        return fechaFabricacion.get();
    }

    public void setFecha(LocalDate fechaFabricacion)
    {
        this.fechaFabricacion.set(fechaFabricacion);
    }
    
    public ObjectProperty<LocalDate> fechaProperty()
    {
        return fechaFabricacion;
    }
}