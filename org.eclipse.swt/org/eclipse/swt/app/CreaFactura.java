package org.eclipse.swt.app;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class CreaFactura {

	private static Connection cn;
	protected Shell shell;
	private Text NoFactura;
	private Text nom;
	private Text text_2;
	private Text dir;
	private Text telf;
	private Text email;
	private Text totalp;
	private Text iva;
	private Text totalT;
	private Text cant1, cant2, cant3, cant4, cant5, cant6, cant7, cant8;
	private Text desc1, desc2, desc3, desc4, desc5, desc6, desc7, desc8;
	private Text cost1, cost2, cost3, cost4, cost5, cost6, cost7, cost8;
	double[] costos = new double[7]; // array de double donde se guardaran los costos
	String[] descripciones = new String[7]; // array de String donde se guardaran las descripciones
	int[] cantidades = new int[7]; // array de int donde se guadaran las cantidades

	public static void main(String[] args) {
		try {
			CreaFactura window = new CreaFactura();
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
		shell.setSize(1073, 850);
		shell.setText("APP CREAR FACTURA");
		shell.setLocation(20, 20);
		shell.setLayout(new FormLayout());

		Composite composite = new Composite(shell, SWT.NONE);
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(0, 163);
		fd_composite.right = new FormAttachment(0, 1026);
		fd_composite.top = new FormAttachment(0, 10);
		fd_composite.left = new FormAttachment(0, 10);
		composite.setLayoutData(fd_composite);
		composite.setBackground(SWTResourceManager.getColor(0, 0, 0));
		composite.setForeground(SWTResourceManager.getColor(0, 0, 0));

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblNewLabel.setSize(378, 69);
		lblNewLabel.setFont(SWTResourceManager.getFont("Calibri", 42, SWT.NORMAL));
		lblNewLabel.setText("FACTURA AJC");

		Label lblFacturaId = new Label(composite, SWT.NONE);
		lblFacturaId.setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblFacturaId.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblFacturaId.setLocation(714, 0);
		lblFacturaId.setSize(168, 43);
		lblFacturaId.setFont(SWTResourceManager.getFont("Calibri", 22, SWT.NORMAL));
		lblFacturaId.setText("No. Factura:");

		NoFactura = new Text(composite, SWT.BORDER);
		NoFactura.setLocation(714, 48);
		NoFactura.setSize(230, 43);

		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_1 = new FormData();
		fd_lblNewLabel_1.bottom = new FormAttachment(0, 214);
		fd_lblNewLabel_1.right = new FormAttachment(0, 254);
		fd_lblNewLabel_1.top = new FormAttachment(0, 182);
		fd_lblNewLabel_1.left = new FormAttachment(0, 42);
		lblNewLabel_1.setLayoutData(fd_lblNewLabel_1);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.NORMAL));
		lblNewLabel_1.setText("Datos Corporativos");

		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_2 = new FormData();
		fd_lblNewLabel_2.bottom = new FormAttachment(0, 252);
		fd_lblNewLabel_2.right = new FormAttachment(0, 144);
		fd_lblNewLabel_2.top = new FormAttachment(0, 220);
		fd_lblNewLabel_2.left = new FormAttachment(0, 42);
		lblNewLabel_2.setLayoutData(fd_lblNewLabel_2);
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.NORMAL));
		lblNewLabel_2.setText("AJC S.A");

		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_3 = new FormData();
		fd_lblNewLabel_3.bottom = new FormAttachment(0, 290);
		fd_lblNewLabel_3.right = new FormAttachment(0, 440);
		fd_lblNewLabel_3.top = new FormAttachment(0, 258);
		fd_lblNewLabel_3.left = new FormAttachment(0, 42);
		lblNewLabel_3.setLayoutData(fd_lblNewLabel_3);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.NORMAL));
		lblNewLabel_3.setText("Calle Arketh y finca menor N.- 345");

		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_4 = new FormData();
		fd_lblNewLabel_4.bottom = new FormAttachment(0, 328);
		fd_lblNewLabel_4.top = new FormAttachment(0, 293);
		fd_lblNewLabel_4.left = new FormAttachment(0, 42);
		lblNewLabel_4.setLayoutData(fd_lblNewLabel_4);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.NORMAL));
		lblNewLabel_4.setText("099625124  - 0921312432");

		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_5 = new FormData();
		fd_lblNewLabel_5.bottom = new FormAttachment(0, 366);
		fd_lblNewLabel_5.right = new FormAttachment(0, 344);
		fd_lblNewLabel_5.top = new FormAttachment(0, 334);
		fd_lblNewLabel_5.left = new FormAttachment(0, 42);
		lblNewLabel_5.setLayoutData(fd_lblNewLabel_5);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.NORMAL));
		lblNewLabel_5.setText("ajc.81@outlook.com");

		Label lblNewLabel_6 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_6 = new FormData();
		fd_lblNewLabel_6.bottom = new FormAttachment(0, 201);
		fd_lblNewLabel_6.right = new FormAttachment(0, 692);
		fd_lblNewLabel_6.top = new FormAttachment(0, 169);
		fd_lblNewLabel_6.left = new FormAttachment(0, 480);
		lblNewLabel_6.setLayoutData(fd_lblNewLabel_6);
		lblNewLabel_6.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.NORMAL));
		lblNewLabel_6.setText("Datos Consumidor: ");

		Label lblNewLabel_7 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_7 = new FormData();
		fd_lblNewLabel_7.bottom = new FormAttachment(0, 239);
		fd_lblNewLabel_7.right = new FormAttachment(0, 595);
		fd_lblNewLabel_7.top = new FormAttachment(0, 207);
		fd_lblNewLabel_7.left = new FormAttachment(0, 480);
		lblNewLabel_7.setLayoutData(fd_lblNewLabel_7);
		lblNewLabel_7.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.NORMAL));
		lblNewLabel_7.setText("Nombre : ");

		Label lblNewLabel_8 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_8 = new FormData();
		fd_lblNewLabel_8.bottom = new FormAttachment(0, 266);
		fd_lblNewLabel_8.right = new FormAttachment(0, 595);
		fd_lblNewLabel_8.top = new FormAttachment(0, 234);
		fd_lblNewLabel_8.left = new FormAttachment(0, 480);
		lblNewLabel_8.setLayoutData(fd_lblNewLabel_8);
		lblNewLabel_8.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.NORMAL));
		lblNewLabel_8.setText("Direccion: ");

		Label lblNewLabel_9 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_9 = new FormData();
		fd_lblNewLabel_9.bottom = new FormAttachment(0, 304);
		fd_lblNewLabel_9.right = new FormAttachment(0, 608);
		fd_lblNewLabel_9.top = new FormAttachment(0, 272);
		fd_lblNewLabel_9.left = new FormAttachment(0, 480);
		lblNewLabel_9.setLayoutData(fd_lblNewLabel_9);
		lblNewLabel_9.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.NORMAL));
		lblNewLabel_9.setText("Telefonos: ");

		Label lblNewLabel_10 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_10 = new FormData();
		fd_lblNewLabel_10.bottom = new FormAttachment(0, 342);
		fd_lblNewLabel_10.top = new FormAttachment(0, 310);
		fd_lblNewLabel_10.left = new FormAttachment(0, 480);
		lblNewLabel_10.setLayoutData(fd_lblNewLabel_10);
		lblNewLabel_10.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.NORMAL));
		lblNewLabel_10.setText("Correo Electronico: ");

		Label lblNewLabel_11 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_11 = new FormData();
		fd_lblNewLabel_11.bottom = new FormAttachment(0, 376);
		fd_lblNewLabel_11.right = new FormAttachment(0, 638);
		fd_lblNewLabel_11.top = new FormAttachment(0, 344);
		fd_lblNewLabel_11.left = new FormAttachment(0, 480);
		lblNewLabel_11.setLayoutData(fd_lblNewLabel_11);
		lblNewLabel_11.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.NORMAL));
		lblNewLabel_11.setText("Valor a Pagar: ");

		Label lblNewLabel_12 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_12 = new FormData();
		fd_lblNewLabel_12.bottom = new FormAttachment(0, 414);
		fd_lblNewLabel_12.top = new FormAttachment(0, 382);
		fd_lblNewLabel_12.left = new FormAttachment(0, 480);
		lblNewLabel_12.setLayoutData(fd_lblNewLabel_12);
		lblNewLabel_12.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.NORMAL));
		lblNewLabel_12.setText("IVA: ");

		Label lblNewLabel_13 = new Label(shell, SWT.NONE);
		FormData fd_lblNewLabel_13 = new FormData();
		fd_lblNewLabel_13.bottom = new FormAttachment(0, 452);
		fd_lblNewLabel_13.right = new FormAttachment(0, 617);
		fd_lblNewLabel_13.top = new FormAttachment(0, 420);
		fd_lblNewLabel_13.left = new FormAttachment(0, 480);
		lblNewLabel_13.setLayoutData(fd_lblNewLabel_13);
		lblNewLabel_13.setFont(SWTResourceManager.getFont("Calibri", 16, SWT.NORMAL));
		lblNewLabel_13.setText("Valor Total: ");

		nom = new Text(shell, SWT.BORDER);
		FormData fd_nom = new FormData();
		fd_nom.bottom = new FormAttachment(0, 237);
		fd_nom.right = new FormAttachment(0, 986);
		fd_nom.top = new FormAttachment(0, 207);
		fd_nom.left = new FormAttachment(0, 716);
		nom.setLayoutData(fd_nom);

		text_2 = new Text(shell, SWT.BORDER);
		FormData fd_text_2 = new FormData();
		fd_text_2.bottom = new FormAttachment(0, 199);
		fd_text_2.right = new FormAttachment(0, 986);
		fd_text_2.top = new FormAttachment(0, 169);
		fd_text_2.left = new FormAttachment(0, 716);
		text_2.setLayoutData(fd_text_2);

		dir = new Text(shell, SWT.BORDER);
		FormData fd_dir = new FormData();
		fd_dir.bottom = new FormAttachment(0, 271);
		fd_dir.right = new FormAttachment(0, 986);
		fd_dir.top = new FormAttachment(0, 241);
		fd_dir.left = new FormAttachment(0, 716);
		dir.setLayoutData(fd_dir);

		telf = new Text(shell, SWT.BORDER);
		FormData fd_telf = new FormData();
		fd_telf.bottom = new FormAttachment(0, 309);
		fd_telf.right = new FormAttachment(0, 986);
		fd_telf.top = new FormAttachment(0, 279);
		fd_telf.left = new FormAttachment(0, 716);
		telf.setLayoutData(fd_telf);

		email = new Text(shell, SWT.BORDER);
		FormData fd_email = new FormData();
		fd_email.bottom = new FormAttachment(0, 345);
		fd_email.right = new FormAttachment(0, 986);
		fd_email.top = new FormAttachment(0, 315);
		fd_email.left = new FormAttachment(0, 716);
		email.setLayoutData(fd_email);

		totalp = new Text(shell, SWT.BORDER);
		FormData fd_totalp = new FormData();
		fd_totalp.bottom = new FormAttachment(0, 381);
		fd_totalp.right = new FormAttachment(0, 986);
		fd_totalp.top = new FormAttachment(0, 351);
		fd_totalp.left = new FormAttachment(0, 716);
		totalp.setLayoutData(fd_totalp);

		iva = new Text(shell, SWT.BORDER);
		FormData fd_iva = new FormData();
		fd_iva.bottom = new FormAttachment(0, 417);
		fd_iva.right = new FormAttachment(0, 986);
		fd_iva.top = new FormAttachment(0, 387);
		fd_iva.left = new FormAttachment(0, 716);
		iva.setLayoutData(fd_iva);

		totalT = new Text(shell, SWT.BORDER);
		FormData fd_totalT = new FormData();
		fd_totalT.bottom = new FormAttachment(0, 450);
		fd_totalT.right = new FormAttachment(0, 986);
		fd_totalT.top = new FormAttachment(0, 420);
		fd_totalT.left = new FormAttachment(0, 716);
		totalT.setLayoutData(fd_totalT);

		Composite composite_1 = new Composite(shell, SWT.NONE);
		GridLayout gl_composite_1 = new GridLayout(3, false);
		composite_1.setLayout(gl_composite_1);
		FormData fd_composite_1 = new FormData();
		fd_composite_1.bottom = new FormAttachment(lblNewLabel_13, 305, SWT.BOTTOM);
		fd_composite_1.top = new FormAttachment(lblNewLabel_13, 27);
		fd_composite_1.left = new FormAttachment(composite, 0, SWT.LEFT);
		fd_composite_1.right = new FormAttachment(100);
		composite_1.setLayoutData(fd_composite_1);

		Label lblNewLabel_14 = new Label(composite_1, SWT.NONE);
		GridData gd_lblNewLabel_14 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_14.widthHint = 224;
		lblNewLabel_14.setLayoutData(gd_lblNewLabel_14);
		lblNewLabel_14.setText("Cantidad");

		Label lblNewLabel_15 = new Label(composite_1, SWT.NONE);
		GridData gd_lblNewLabel_15 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_15.widthHint = 430;
		lblNewLabel_15.setLayoutData(gd_lblNewLabel_15);
		lblNewLabel_15.setText("Descripcion");

		Label lblNewLabel_16 = new Label(composite_1, SWT.NONE);
		GridData gd_lblNewLabel_16 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_16.widthHint = 343;
		lblNewLabel_16.setLayoutData(gd_lblNewLabel_16);
		lblNewLabel_16.setText("Costo");

		cant1 = new Text(composite_1, SWT.BORDER);
		cant1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		desc1 = new Text(composite_1, SWT.BORDER);
		desc1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		cost1 = new Text(composite_1, SWT.BORDER);
		cost1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		cant2 = new Text(composite_1, SWT.BORDER);
		cant2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		desc2 = new Text(composite_1, SWT.BORDER);
		desc2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		cost2 = new Text(composite_1, SWT.BORDER);
		cost2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		cant3 = new Text(composite_1, SWT.BORDER);
		cant3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		desc3 = new Text(composite_1, SWT.BORDER);
		desc3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		cost3 = new Text(composite_1, SWT.BORDER);
		cost3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		cant4 = new Text(composite_1, SWT.BORDER);
		cant4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		desc4 = new Text(composite_1, SWT.BORDER);
		desc4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		cost4 = new Text(composite_1, SWT.BORDER);
		cost4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		cant5 = new Text(composite_1, SWT.BORDER);
		cant5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		desc5 = new Text(composite_1, SWT.BORDER);
		desc5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		cost5 = new Text(composite_1, SWT.BORDER);
		cost5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		cant6 = new Text(composite_1, SWT.BORDER);
		cant6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		desc6 = new Text(composite_1, SWT.BORDER);
		desc6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		cost6 = new Text(composite_1, SWT.BORDER);
		cost6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		cant7 = new Text(composite_1, SWT.BORDER);
		cant7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		desc7 = new Text(composite_1, SWT.BORDER);
		desc7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		cost7 = new Text(composite_1, SWT.BORDER);
		cost7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		cant8 = new Text(composite_1, SWT.BORDER);
		cant8.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false, 1, 1));

		desc8 = new Text(composite_1, SWT.BORDER);
		desc8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		cost8 = new Text(composite_1, SWT.BORDER);
		cost8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.close();
				Menu pg1 = new Menu();
				pg1.open();
			}
		});
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.top = new FormAttachment(composite_1, 6);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("Regresar");

		Button btnIngresar = new Button(shell, SWT.NONE);
		btnIngresar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Los datos se han subido a la bas de datos!!");

				try {
					Connection cn = Conexion.getConnection();// llamar una instancia de la clase Conexion
					java.util.Date fecha0 = new java.util.Date(); // fecha until
					Date fecha = new java.sql.Date(fecha0.getTime()); // fecha mysql
					int C_id = 2;
					int id = Integer.parseInt(NoFactura.getText());
					String nombre = nom.getText();
					String direccion = dir.getText();
					int telefono = Integer.parseInt(telf.getText());
					String correo = email.getText();
					double subtotal = Double.parseDouble(totalp.getText());
					double total = Double.parseDouble(totalT.getText());
					String query1 = "INSERT INTO Factura (No_Factura, fecha, Total_sin_iva, Total_con_iva, Cliente_C_id) VALUES ('"
							+ id + "', '" + fecha + "', '" + subtotal + "', '" + total + "', '" + C_id + "');";
					for (int i = 0; i <= 7; i++) {
						String query2 = "INSERT INTO Productos(P_precio, P_desc,P_cantidad) VALUES (" + costos[i]
								+ ", '" + descripciones[i] + "', " + cantidades[i] + ");";
						Statement stm2 = cn.createStatement();
						stm2.execute(query2);
					}

					System.out.println("Factura agregada ");
					Statement stm = cn.createStatement();
					stm.executeUpdate(query1);
					System.out.println("Los datos se han subido a la bas de datos!!");
				} catch (Exception e2) {
					System.out.println("Error al conectarse a la BD ");
					e2.printStackTrace();
					System.out.println(e2.toString());
				}

			}
		});
		fd_btnNewButton.left = new FormAttachment(btnIngresar, 21);
		FormData fd_btnIngresar = new FormData();
		fd_btnIngresar.top = new FormAttachment(composite_1, 6);
		fd_btnIngresar.right = new FormAttachment(100, -117);
		btnIngresar.setLayoutData(fd_btnIngresar);
		btnIngresar.setText("Ingresar");

	}

	public int[] getCantidades() {

		this.cantidades[0] = Integer.parseInt(cant1.getText());
		this.cantidades[1] = Integer.parseInt(cant2.getText());
		this.cantidades[2] = Integer.parseInt(cant3.getText());
		this.cantidades[3] = Integer.parseInt(cant4.getText());
		this.cantidades[4] = Integer.parseInt(cant5.getText());
		this.cantidades[5] = Integer.parseInt(cant6.getText());
		this.cantidades[6] = Integer.parseInt(cant7.getText());
		this.cantidades[7] = Integer.parseInt(cant8.getText());
		return cantidades;
	}

	public double[] getCostos() {
		this.costos[0] = Double.parseDouble(cost1.getText());
		this.costos[1] = Double.parseDouble(cost2.getText());
		this.costos[2] = Double.parseDouble(cost3.getText());
		this.costos[3] = Double.parseDouble(cost4.getText());
		this.costos[4] = Double.parseDouble(cost5.getText());
		this.costos[5] = Double.parseDouble(cost6.getText());
		this.costos[6] = Double.parseDouble(cost7.getText());
		this.costos[7] = Double.parseDouble(cost8.getText());
		return costos;
	}

	public String[] getDescripciones() {
		this.descripciones[0] = desc1.getText();
		this.descripciones[1] = desc2.getText();
		this.descripciones[2] = desc3.getText();
		this.descripciones[3] = desc4.getText();
		this.descripciones[4] = desc5.getText();
		this.descripciones[5] = desc6.getText();
		this.descripciones[6] = desc7.getText();
		this.descripciones[7] = desc8.getText();
		return descripciones;
	}
}
