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
import javax.swing.JSpinner;

public class MainView {

	private JFrame frmConversor;
	private JButton btnCambioMoneda;
	private JButton btnCambioTemp;
	private JComboBox<Object> cmbMonedaConvertir;
	private JComboBox<Object> cmbMonedaResult;
	private JComboBox<Object> cmbMagnitudConvertir;
	private JComboBox<Object> cmbMagnitudResult;
	private JSpinner spnMonedaResult;
	private JSpinner spnMoneda1;
	private JSpinner spnValor1;
	private JSpinner spnValorResult;
	private JLabel lblIngreseElValor_2;

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
		
		/**
		 * spinner textbox
		 */
		
		spnMoneda1 = new JSpinner();
		spnMoneda1.setBounds(229, 101, 228, 41);
		spnMoneda1.setFont(new Font("Hack", Font.PLAIN, 28));
		panMonedas.add(spnMoneda1);
		
		spnMonedaResult = new JSpinner();
		spnMonedaResult.setEnabled(false);
		spnMonedaResult.setFont(new Font("Hack", Font.PLAIN, 28));
		spnMonedaResult.setBounds(229, 249, 228, 41);
		panMonedas.add(spnMonedaResult);
		
		spnValor1 = new JSpinner();
		spnValor1.setBounds(229, 101, 228, 41);
		spnValor1.setFont(new Font("Hack", Font.PLAIN, 28));
		panTemperatura.add(spnValor1);
		
		spnValorResult = new JSpinner();
		spnValorResult.setEnabled(false);
		spnValorResult.setBounds(229, 250, 228, 41);
		spnValorResult.setFont(new Font("Hack", Font.PLAIN, 28));
		panTemperatura.add(spnValorResult);
		
		/**
		 * labels
		 */
		JLabel lblIngresaLaCantidad = new JLabel("Ingresa la cantidad a convertir");
		lblIngresaLaCantidad.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIngresaLaCantidad.setBounds(186, 50, 228, 28);
		panMonedas.add(lblIngresaLaCantidad);
		
		JLabel lblIngreseElValor = new JLabel("Ingrese el valor a convertir");
		lblIngreseElValor.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIngreseElValor.setBounds(201, 50, 201, 28);
		panTemperatura.add(lblIngreseElValor);
		
		cmbMonedaConvertir = new JComboBox<Object>();
		cmbMonedaConvertir.setToolTipText("Seleccione la moneda a convertir");
		cmbMonedaConvertir.setFont(new Font("Hack", Font.PLAIN, 28));
		cmbMonedaConvertir.setBounds(115, 101, 111, 41);
		panMonedas.add(cmbMonedaConvertir);
		
		cmbMonedaResult = new JComboBox<Object>();
		cmbMonedaResult.setToolTipText("Seleccione la moneda que desea como resultado");
		cmbMonedaResult.setFont(new Font("Hack", Font.PLAIN, 28));
		cmbMonedaResult.setBounds(115, 249, 111, 41);
		panMonedas.add(cmbMonedaResult);
		
		cmbMagnitudConvertir = new JComboBox<Object>();
		cmbMagnitudConvertir.setToolTipText("Seleccione la temperatura que desea convertir");
		cmbMagnitudConvertir.setFont(new Font("Hack", Font.PLAIN, 20));
		cmbMagnitudConvertir.setBounds(115, 102, 111, 41);
		cmbMagnitudConvertir.addItem("Celsius");
		cmbMagnitudConvertir.addItem("Fahrenheit");
		panTemperatura.add(cmbMagnitudConvertir);
		
		cmbMagnitudResult = new JComboBox<Object>();
		cmbMagnitudResult.setToolTipText("Seleccione la temperatura a la que desea convertir");
		cmbMagnitudResult.setFont(new Font("Hack", Font.PLAIN, 20));
		cmbMagnitudResult.setBounds(115, 250, 111, 41);
		panTemperatura.add(cmbMagnitudResult);
		cmbMagnitudResult.addItem("Celsius");
		cmbMagnitudResult.addItem("Fahrenheit");
		
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
		
		lblIngreseElValor_2 = new JLabel("Resultado de su conversion");
		lblIngreseElValor_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIngreseElValor_2.setBounds(201, 302, 201, 28);
		panMonedas.add(lblIngreseElValor_2);
		
		
		
		btnCambioTemp = new JButton("Cambio");
		btnCambioTemp.setFont(new Font("Jamrul", Font.BOLD, 22));
		btnCambioTemp.setBounds(231, 179, 139, 28);
		panTemperatura.add(btnCambioTemp);
		
		JLabel lblIngreseElValor_1 = new JLabel("Resultado de su conversion");
		lblIngreseElValor_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblIngreseElValor_1.setBounds(201, 303, 201, 28);
		panTemperatura.add(lblIngreseElValor_1);
		
	}
	
	private void configurarAccionesDelFormulario() {
		
		btnCambioTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Integer indexValorConvertir = cmbMagnitudConvertir.getSelectedIndex();
				Integer indexValorResult = cmbMagnitudResult.getSelectedIndex();
				Double valorConvertir = Double.valueOf(spnValor1.getValue().toString());
				double resultado;
				
				if(indexValorConvertir != indexValorResult) {
					if(indexValorConvertir == 0) {
						resultado = valorConvertir * 1.8 + 32;
						spnValorResult.setValue(resultado);
						return;
					}
					resultado = (valorConvertir - 32) * (5/9);
					spnValorResult.setValue(resultado);
					return;
				}
				
				spnValorResult.setValue(valorConvertir);
				
			}
		});
		
		btnCambioMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String moneda1 = (String) cmbMonedaConvertir.getSelectedItem();
				String monedaAConvertir = (String) cmbMonedaResult.getSelectedItem();
				
				Double cantidad = Double.parseDouble(spnMoneda1.getValue().toString());
				MonedaController resultadoMoneda = new MonedaController();
				
				Double resultado = resultadoMoneda.convertir(moneda1, monedaAConvertir, cantidad);
				
				spnMonedaResult.setValue(resultado);
				
			}
		});
		
	}
}
