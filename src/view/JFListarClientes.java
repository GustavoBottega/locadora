package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

import javax.swing.JButton;

public class JFListarClientes extends JFrame {

	private JPanel contentPane;
	private JTable JTCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarClientes frame = new JFListarClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFListarClientes() {
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 558, 227);
		contentPane.add(scrollPane);
		
		JTCliente = new JTable();
		JTCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "Idade", "Email", "Estado Civil"
			}
		));
		scrollPane.setViewportView(JTCliente);
		
		JButton btnNewButton = new JButton("Add Cliente");
		btnNewButton.setBounds(36, 262, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Alterar Cliente");
		btnNewButton_1.setBounds(242, 262, 134, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Excluir");
		btnNewButton_2.setBounds(479, 262, 89, 23);
		contentPane.add(btnNewButton_2);
		readJTable();
	}
	
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) JTCliente.getModel();
		modelo.setNumRows(0);
		ClienteDAO fdao = new ClienteDAO();
		for(Cliente f : fdao.read()) {
			modelo.addRow(new Object[] {
					f.getIdCliente(),
					f.getNome(),
					f.getIdade(),
					f.getEmail(),
					f.getEstadocivil()
			});
		}
	}

}