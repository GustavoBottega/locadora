package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFCadastrarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textnome;
	private JTextField textemail;
	private JTextField textec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarCliente frame = new JFCadastrarCliente();
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
	public JFCadastrarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastro de Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(120, 11, 180, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(0, 58, 74, 27);
		contentPane.add(lblNewLabel_1);
		
		textnome = new JTextField();
		textnome.setBounds(44, 62, 390, 23);
		contentPane.add(textnome);
		textnome.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("E-mail:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(0, 96, 74, 27);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Estado Civil:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(0, 134, 74, 27);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblidade = new JLabel("Idade:");
		lblidade.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblidade.setBounds(0, 172, 74, 27);
		contentPane.add(lblidade);
		
		textemail = new JTextField();
		textemail.setBounds(44, 100, 390, 23);
		contentPane.add(textemail);
		textemail.setColumns(10);
		
		JSpinner spidade = new JSpinner();
		spidade.setBounds(45, 176, 56, 40);
		contentPane.add(spidade);
		
		textec = new JTextField();
		textec.setBounds(84, 138, 350, 23);
		contentPane.add(textec);
		textec.setColumns(10);
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Cliente f = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				f.setNome(textnome.getText());
				f.setEmail(textemail.getText());
				f.setEstadocivil(textec.getText());
				f.setIdade(Integer.parseInt(spidade.getValue().toString()));
				
				dao.create(f);
				
			}
		});
		btnNewButton.setBounds(24, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(294, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
	
		
		JButton btnNewButton_2 = new JButton("Limpar");
		btnNewButton_2.setBounds(164, 227, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
