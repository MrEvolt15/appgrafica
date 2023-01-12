package org.eclipse.swt.app;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import com.mysql.cj.result.Row;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class app{
	
	
	protected Shell shell;
	private Text usuariofield;
	private Text passfield;
	static Statement stm = null;
	static ResultSet rs = null;
	
	
	public static void main(String[] args) {
		try {
			app window = new app();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setModified(true);
		shell.setSize(466, 439);
		shell.setLocation(20, 20);
		shell.setText("LOG IN");
		shell.setLayout(null);
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBounds(0, 0, 448, 390);
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 70, 20);
		lblNewLabel.setText("Usuario: ");
		
		usuariofield = new Text(composite, SWT.BORDER);
		usuariofield.setBounds(135, 10, 213, 26);
		
		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setBounds(10, 36, 81, 20);
		lblNewLabel_1.setText("Contraseña: ");
		
		passfield = new Text(composite, SWT.BORDER | SWT.PASSWORD);
		passfield.setBounds(135, 42, 213, 26);
		
		Button btnLogin = new Button(composite, SWT.NONE);
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				shell.close();
			}
		});
		btnLogin.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				Connection cn = Conexion.getConnection();// llamada a una instancia de Conexion
				String usuario = usuariofield.getText();
				String pass=null;
				try {
					stm = cn.createStatement();
					rs =stm.executeQuery("SELECT C_password FROM Cliente WHERE C_nombre="+"'"+usuario+"'");
					rs.next();
					pass = rs.getString(1);
										
					System.out.println(pass);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				if (pass.equals(passfield.getText())) {
					shell.close();
					Menu pg1 = new Menu();
					pg1.open();
				}
				
								
			}
		});
		btnLogin.setBounds(46, 133, 90, 30);
		btnLogin.setText("Login");

	}
}
