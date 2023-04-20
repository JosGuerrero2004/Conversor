package conversor.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import conversor.controller.MonedaController;

import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView {

	private JFrame frmConversor;
	private JTextField txtMoneda1;
	private JTextField txtMonedaResult;
	private JTextField txtValor1;
	private JTextField txtValorResult;
	private JButton btnCambioMoneda;
	private JButton btnCambioTemp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frmConversor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
		configurarAccionesDelFormulario();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConversor = new JFrame();
		frmConversor.setBackground(new Color(119, 136, 153));
		frmConversor.setTitle("Conversor");
		frmConversor.setResizable(false);
		frmConversor.setBounds(100, 100, 587, 423);
		frmConversor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tpnMain = new JTabbedPane(JTabbedPane.TOP);
		tpnMain.setBackground(new Color(119, 136, 153));
		frmConversor.getContentPane().add(tpnMain, BorderLayout.CENTER);
		
		JPanel panMonedas = new JPanel();
		panMonedas.setBackground(new Color(192, 192, 192));
		tpnMain.addTab("Monedas", null, panMonedas, null);
		panMonedas.setLayout(null);
		
		JPanel panTemperatura = new JPanel();
		panTemperatura.setBackground(new Color(192, 192, 192));
		tpnMain.addTab("Temperatura", null, panTemperatura, null);
		panTemperatura.setLayout(null);
		
		/*
		 * *TextFields
		 */
		txtMoneda1 = new JTextField();
		txtMoneda1.setFont(new Font("Hack", Font.PLAIN, 28));
		txtMoneda1.setEditable(false);
		txtMoneda1.setBounds(229, 101, 228, 41);
		txtMoneda1.setText("0.00");
		panMonedas.add(txtMoneda1);
		txtMoneda1.setColumns(10);
		
		txtMonedaResult = new JTextField();
		txtMonedaResult.setText("0.00");
		txtMonedaResult.setFont(new Font("Hack", Font.PLAIN, 28));
		txtMonedaResult.setColumns(10);
		txtMonedaResult.setBounds(229, 249, 228, 41);
		panMonedas.add(txtMonedaResult);
		
		txtValor1 = new JTextField();
		txtValor1.setText("0.00");
		txtValor1.setFont(new Font("Hack", Font.PLAIN, 28));
		txtValor1.setEditable(false);
		txtValor1.setColumns(10);
		txtValor1.setBounds(229, 102, 228, 41);
		panTemperatura.add(txtValor1);
		
		txtValorResult = new JTextField();
		txtValorResult.setText("0.00");
		txtValorResult.setFont(new Font("Hack", Font.PLAIN, 28));
		txtValorResult.setColumns(10);
		txtValorResult.setBounds(229, 250, 228, 41);
		panTemperatura.add(txtValorResult);
		
		/**
		 * labels
		 */
		JLabel lblIngresaLaCantidad = new JLabel("Ingresa la cantidad a convertir");
		lblIngresaLaCantidad.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIngresaLaCantidad.setLabelFor(txtMoneda1);
		lblIngresaLaCantidad.setBounds(186, 50, 228, 28);
		panMonedas.add(lblIngresaLaCantidad);
		
		JLabel lblIngreseElValor = new JLabel("Ingrese el valor a convertir");
		lblIngreseElValor.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIngreseElValor.setBounds(201, 50, 201, 28);
		panTemperatura.add(lblIngreseElValor);
		
		/**
		 * ComboBox
		 */
		JComboBox<Object> cmbMonedaConvertir = new JComboBox<Object>();
		cmbMonedaConvertir.setFont(new Font("Hack", Font.PLAIN, 28));
		cmbMonedaConvertir.setBounds(115, 101, 111, 41);
		panMonedas.add(cmbMonedaConvertir);
		
		JComboBox<Object> cmbMonedaResult = new JComboBox<Object>();
		cmbMonedaResult.setFont(new Font("Hack", Font.PLAIN, 28));
		cmbMonedaResult.setBounds(115, 249, 111, 41);
		panMonedas.add(cmbMonedaResult);
		
		JComboBox<Object> cmbMagnitudConvertir = new JComboBox<Object>();
		cmbMagnitudConvertir.setFont(new Font("Hack", Font.PLAIN, 28));
		cmbMagnitudConvertir.setBounds(115, 102, 111, 41);
		panTemperatura.add(cmbMagnitudConvertir);
		
		JComboBox<Object> cmbMagnitudResult = new JComboBox<Object>();
		cmbMagnitudResult.setFont(new Font("Hack", Font.PLAIN, 28));
		cmbMagnitudResult.setBounds(115, 250, 111, 41);
		panTemperatura.add(cmbMagnitudResult);
		
		/**
		 * llenado de combobox
		 */
		
		List<String> monedas = new MonedaController().listar();
		monedas.forEach(moneda -> {
			cmbMonedaConvertir.addItem(moneda);
			cmbMonedaResult.addItem(moneda);
		});
		
		/**
		 * botones:
		 */
		btnCambioMoneda = new JButton("Cambio");
		btnCambioMoneda.setFont(new Font("Jamrul", Font.BOLD, 22));
		btnCambioMoneda.setBounds(231, 178, 139, 28);
		panMonedas.add(btnCambioMoneda);
		
		btnCambioTemp = new JButton("Cambio");
		btnCambioTemp.setFont(new Font("Jamrul", Font.BOLD, 22));
		btnCambioTemp.setBounds(231, 179, 139, 28);
		panTemperatura.add(btnCambioTemp);
		
	}
	
	private void configurarAccionesDelFormulario() {
		
		btnCambioTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnCambioMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	}
}
