package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFCadastrarFilme extends JFrame {

	private JPanel contentPane;
	private JTextField texttitulo;
	private JTextField textcategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarFilme frame = new JFCadastrarFilme();
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
	public JFCadastrarFilme() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 605, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Filme");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(0, 0, 123, 14);
		contentPane.add(lblNewLabel);
		
		texttitulo = new JTextField();
		texttitulo.setBounds(0, 48, 567, 20);
		contentPane.add(texttitulo);
		texttitulo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo:");
		lblNewLabel_1.setBounds(0, 25, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sinopse:");
		lblNewLabel_2.setBounds(0, 72, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 87, 579, 114);
		contentPane.add(scrollPane);
		
		JTextArea txtSinopse = new JTextArea();
		scrollPane.setViewportView(txtSinopse);
		
		JLabel lblNewLabel_3 = new JLabel("Categoria:");
		lblNewLabel_3.setBounds(0, 230, 68, 14);
		contentPane.add(lblNewLabel_3);
		
		textcategoria = new JTextField();
		textcategoria.setBounds(0, 250, 567, 20);
		contentPane.add(textcategoria);
		textcategoria.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tempo:");
		lblNewLabel_4.setBounds(0, 281, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JSpinner spinnertempo = new JSpinner();
		spinnertempo.setBounds(0, 296, 68, 20);
		contentPane.add(spinnertempo);
		
		JLabel lblNewLabel_5 = new JLabel("imagem:");
		lblNewLabel_5.setBounds(128, 281, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JRadioButton rdbtn3d = new JRadioButton("3d");
		rdbtn3d.setBounds(128, 317, 109, 23);
		contentPane.add(rdbtn3d);
		
		JRadioButton rdbtn2d = new JRadioButton("2d");
		rdbtn2d.setBounds(128, 295, 109, 23);
		contentPane.add(rdbtn2d);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtn2d);
		imagem.add(rdbtn3d);
		
		JLabel lblNewLabel_6 = new JLabel("\u00C1udio:");
		lblNewLabel_6.setBounds(246, 281, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JRadioButton rdbtndublado = new JRadioButton("Dublado");
		rdbtndublado.setBounds(239, 295, 109, 23);
		contentPane.add(rdbtndublado);
		
		JRadioButton rdbtnlegendado = new JRadioButton("Legendado");
		rdbtnlegendado.setBounds(239, 317, 109, 23);
		contentPane.add(rdbtnlegendado);
		
		ButtonGroup audio = new ButtonGroup();
		audio.add(rdbtndublado);
		audio.add(rdbtnlegendado);
		
		JButton btncadastrar = new JButton("Cadastrar");
		btncadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Filme f = new Filme();
				FilmeDAO dao = new FilmeDAO();
				f.setTitulo(texttitulo.getText());
				f.setSinopse(txtSinopse.getText());
				f.setCategoria(textcategoria.getText());
				f.setTempo(Integer.parseInt(spinnertempo.getValue().toString()));
				if(rdbtn2d.isSelected()) {
					f.setImagem3d(false);
				}else if (rdbtn3d.isSelected()) {
					f.setImagem3d(true);
				}
				if(rdbtndublado.isSelected()) {
					f.setDublado(true);
				}else if (rdbtnlegendado.isSelected()) {
					f.setDublado(false);
				}
				dao.create(f);
				dispose();
			}
		});
		btncadastrar.setBounds(0, 357, 89, 23);
		contentPane.add(btncadastrar);
		
		JButton btnlimpar = new JButton("Limpar");
		btnlimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				texttitulo.setText(null);
				txtSinopse.setText(null);
				textcategoria.setText(null);
				spinnertempo.setValue(0);
				imagem.clearSelection();
				audio.clearSelection();
			}
		});
		btnlimpar.setBounds(119, 357, 89, 23);
		contentPane.add(btnlimpar);
		
		JButton btncancelar = new JButton("Cancelar");
		btncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		btncancelar.setBounds(239, 357, 89, 23);
		contentPane.add(btncancelar);
		
		
	}
}
