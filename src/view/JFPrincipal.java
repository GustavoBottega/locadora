package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFPrincipal frame = new JFPrincipal();
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
	public JFPrincipal() {
		setTitle("SISCINEMA - Menu Principal");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Filme");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar Filme...");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastrarFilme cf = new JFCadastrarFilme();
				cf.setVisible(true);				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listar Filmes...");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFListarFilmes lf = new JFListarFilmes();
				lf.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Filme");
		popupMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cadastrar Filme...");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastrarFilme cf = new JFCadastrarFilme();
				cf.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listar Filmes...");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFListarFilmes lf = new JFListarFilmes();
				lf.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		


		
		
		
		
		
		
		
		
		JMenu mnNewMenuc = new JMenu("Cliente");
		menuBar.add(mnNewMenuc);
		
		JMenuItem mntmNewMenuItemc = new JMenuItem("Cadastrar Cliente...");
		mntmNewMenuItemc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastrarCliente cfc = new JFCadastrarCliente();
				cfc.setVisible(true);				
			}
		});
		mnNewMenuc.add(mntmNewMenuItemc);
		
		JMenuItem mntmNewMenuItem_1c = new JMenuItem("Listar Clientes...");
		mntmNewMenuItem_1c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFListarClientes lfc = new JFListarClientes();
				lfc.setVisible(true);
			}
		});
		mnNewMenuc.add(mntmNewMenuItem_1c);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPopupMenu popupMenuc = new JPopupMenu();
		addPopup(contentPane, popupMenuc);
		
		JMenu mnNewMenu_1c = new JMenu("Cliente");
		popupMenuc.add(mnNewMenu_1c);
		
		JMenuItem mntmNewMenuItem_2c = new JMenuItem("Cadastrar Cliente...");
		mntmNewMenuItem_2c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastrarCliente cfc = new JFCadastrarCliente();
				cfc.setVisible(true);
			}
		});
		mnNewMenu_1c.add(mntmNewMenuItem_2c);
		
		JMenuItem mntmNewMenuItem_3c = new JMenuItem("Listar Clientes...");
		mntmNewMenuItem_3c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFListarClientes lfc = new JFListarClientes();
				lfc.setVisible(true);
			}
		});
		mnNewMenu_1c.add(mntmNewMenuItem_3c);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		
		
		
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}