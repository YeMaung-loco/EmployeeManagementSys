package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class View_Main2 {
	JFrame frame;
	DefaultTableModel dtm;
	JPanel panel;
	JButton btnBrand, btnCategory, btnClose, btnLogin;
	private JPanel panel_1;

	public View_Main2() {
		initComponents();
		setProperties();
		addComponents();
	}

	private void initComponents() {
		frame = new JFrame();
		btnClose = new JButton();
		btnBrand = new JButton();
		btnCategory = new JButton();
		btnLogin = new JButton();
		dtm = new DefaultTableModel();
		panel = new JPanel();
		panel.setForeground(SystemColor.menu);
	}

	private void addComponents() {
		panel.setLayout(null);
		panel.add(btnBrand);
		panel.add(btnCategory);
		panel.add(btnLogin);

		frame.getContentPane().add(btnClose);
		frame.getContentPane().add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(0, 208, 177, 70);
		panel.add(panel_1);
		panel_1.setBackground(Color.ORANGE);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("D:\\SpringWorkspace\\MTPworkspace\\photo\\logo.jpg"));
		lblNewLabel.setBounds(0, 0, 177, 141);
		panel.add(lblNewLabel);
		
	//	setTableDesign();
	}

	private void setProperties() {
		frame.setTitle("Employee Management System");
		frame.setBounds(20, 10, 1270, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		//Color color = UIManager.getColor("Table.gridColor");
		//MatteBorder border = new MatteBorder(1, 1, 0, 0, color);
		// Border blackline = BorderFactory.createLineBorder(Color.black);
		panel.setBounds(6, 10, 177, 623);
		panel.setBackground((Color) Color.LIGHT_GRAY);

		btnClose.setText("Close");
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.setBounds(1076, 594, 170, 39);

		btnBrand.setText("Brand");
		btnBrand.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBrand.setBounds(0, 288, 177, 70);

		btnCategory.setText("Category");
		btnCategory.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCategory.setBounds(0, 140, 177, 70);
		
		btnLogin.setText("LogOut");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(0, 553, 177, 70);

	}

	private void setTableDesign() {
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		
	}
	
	public JFrame getFrame() {
		return frame;
	}

	/*
	 * public JButton getbtnEmployee() { return btnEmployee; }
	 */

	public JButton getbtnBrand() {
		return btnBrand;
	}

	public JButton getbtnCategory() {
		return btnCategory;
	}

	public JButton getbtnClose() {
		return btnClose;
	}
	
	/*
	 * public JLabel getLabel() { return lblNewLabel_1; }
	 */
	public JPanel getPanel_1() {
		return panel_1;
	}
}
