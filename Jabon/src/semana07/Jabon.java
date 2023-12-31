package semana07;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

public class Jabon extends JFrame implements ActionListener {

	// Declaraci�n de variables
	private static final long serialVersionUID = 9206324162700448001L;
	private JPanel contentPane;
	private JLabel lblMarca;
	private JLabel lblCantidad;
	private JComboBox<String> cboMarca;
	private JTextField txtCantidad;
	private JButton btnProcesar;
	private JButton btnBorrar;
	private JScrollPane scpScroll;
	private JTextArea txtS;

	// Lanza la aplicaci�n
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jabon frame = new Jabon();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crea la GUI
	public Jabon() {
		setTitle("Jabon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 233);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(10, 11, 47, 14);
		contentPane.add(lblMarca);

		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(10, 36, 47, 14);
		contentPane.add(lblCantidad);

		cboMarca = new JComboBox<String>();
		cboMarca.setModel(new DefaultComboBoxModel<String>(new String[] {"Palmolive Tripack", "Nivea Tripack", "Rexona Tripack", "Neko Tripack"}));
		cboMarca.setBounds(67, 8, 125, 20);
		contentPane.add(cboMarca);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(67, 33, 125, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);

		btnProcesar = new JButton("Procesar");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(335, 7, 89, 23);
		contentPane.add(btnProcesar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		btnBorrar.setBounds(335, 32, 89, 23);
		contentPane.add(btnBorrar);

		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 61, 414, 123);
		contentPane.add(scpScroll);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 12));
		scpScroll.setViewportView(txtS);
	}

	// Direcciona eventos de tipo ActionEvents
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBorrar) {
			actionPerformedBtnBorrar(arg0);
		}
		if (arg0.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(arg0);
		}
	}

	// Procesa la pulsaci�n del bot�n Borrar
	protected void actionPerformedBtnBorrar(ActionEvent arg0) {
		txtCantidad.setText("");
		txtS.setText("");
		cboMarca.setSelectedIndex(0);
		txtCantidad.requestFocus();
	}

	// Procesa la pulsaci�n del bot�n Procesar
	protected void actionPerformedBtnProcesar(ActionEvent arg0) {
		
		double pre,impC,impD,impP;
		int marca,cant,obs;
		
		cant=Integer.parseInt(txtCantidad.getText());
		marca = cboMarca.getSelectedIndex();
		
		if (marca==0){pre=5.2;}
		else if (marca==1){pre=8.2;}
		else if (marca ==2){pre=8.5;}
		else if (marca ==3){pre=6.5;}
		else {pre = 7.4;}
		
		impC=pre*cant;
		
		if (cant >= 18){impD=impC*0.125;}
		else if (cant >= 12 && cant <18){impD=impC*0.1;}
		else if (cant >= 6 && cant < 12){impD= impC*0.075;}
		else {impD= impC;}		
				
		impP=impC-impD;
		
		
		if (cant<12){obs=2*cant;}
		else if (cant>=12 && cant<24){obs=4*cant;}
		else if (cant>=24 && cant<36 ){obs=1*cant;}
		else {obs=2*cant;}


		txtS.setText("**JABON** \n");
		
		i("IMPORTE DE COMPRA    : "+decimalFormat(impC)+ "\n");
		i("IMPORTE DE DESCUENTO : "+decimalFormat(impD)+ "\n");
		i("IMPORTE DE PAGAR     : "+decimalFormat(impP)+ "\n");
		i("OBSEQUIO             : "+ obs);
	
	
	
	
	}
	
	
	
	
	
	
	public String decimalFormat(double p) {
		return String.format("%.2f",p);
	}
	public void i (String s) {
		txtS.append(s +"\n");
	}
}