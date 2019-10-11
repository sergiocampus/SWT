package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;

import config.Conexion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login {

	private JFrame frmAccesoADatos;
	private JTextField textFieldUser;
	private JTextField textFieldContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmAccesoADatos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAccesoADatos = new JFrame();
		frmAccesoADatos.setTitle("Acceso a datos");
		frmAccesoADatos.setBounds(100, 100, 450, 133);
		frmAccesoADatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccesoADatos.getContentPane().setLayout(null);
		frmAccesoADatos.setResizable(false);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(10, 11, 90, 14);
		frmAccesoADatos.getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(10, 36, 90, 14);
		frmAccesoADatos.getContentPane().add(lblContrasea);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(110, 10, 314, 20);
		frmAccesoADatos.getContentPane().add(textFieldUser);
		textFieldUser.setColumns(10);
		
		textFieldContra = new JPasswordField();
		textFieldContra.setBounds(110, 35, 314, 20);
		frmAccesoADatos.getContentPane().add(textFieldContra);
		textFieldContra.setColumns(10);
		
		JButton btnAcceder= new JButton("Acceder");
		btnAcceder.setBounds(10, 66, 200, 27);
		frmAccesoADatos.getContentPane().add(btnAcceder);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(220, 66, 204, 27);
		frmAccesoADatos.getContentPane().add(btnSalir);
		
		//Listeners
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acceder();
			}
		});
		
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAccesoADatos.dispose();
			}
		});
	}
	
	private void acceder()
	{
		Connection conn = new Conexion().conectar();
		
		try
		{
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?"); //Nombre tablas en mayus
			ps.setString(1, textFieldUser.getText());
			ps.setString(2, textFieldContra.getText());
			
			ResultSet rs = ps.executeQuery(); //Ejecutar la select
			
			//System.out.println(rs.next());
			
			if(rs.next())
			{
				Principal p = new Principal();
				p.frmPrincipal.setVisible(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Error de login");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
