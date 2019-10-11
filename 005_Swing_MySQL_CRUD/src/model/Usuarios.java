package model;

public class Usuarios
{
	private int id;
	private String nombre, password, estado;

	public Usuarios(int idP, String nombreP, String password, String estadoP)
	{
	     this.id = idP;
	     this.nombre = nombreP;
	     this.password = password;
	     this.estado = estadoP;
	}

	public int getId()
	{
	  return id;  
	}
	
	public String getNombre()
	{
	  return nombre;  
	}

	public String getPassword()
	{
	  return password;  
	}

	public String getEstado()
	{
	  return estado;  
	}
}
