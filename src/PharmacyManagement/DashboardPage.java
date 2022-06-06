package PharmacyManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class DashboardPage extends JPanel {
	JPanel textfield;
	public JButton Adder, stock, previousorderlist, logout;

	public DashboardPage() {
		setVisible(true);
		setLayout(null);
		setSize(900, 600);

		JLabel header = new JLabel("Welcome to Digital Pharmacy Management", SwingConstants.CENTER);
		add(header);
		header.setForeground(Color.BLACK);
		header.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		header.setBounds(5, 10, 875, 40);

		stock = new JButton("Products Stock");
		add(stock);
		stock.setBounds(5, 70, 430, 40);

		previousorderlist = new JButton("Previous Order List");
		add(previousorderlist);
		previousorderlist.setBounds(450, 70, 430, 40);

		textfield = new JPanel();
		textfield.setForeground(Color.BLACK);
		textfield.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		stock.addActionListener(l -> {
			ResultSet productList = new DbConnect().getProductList();
			if (productList == null) {
				return;
			}

			DefaultTableModel model = new DefaultTableModel();

			model.addColumn("ID");
			model.addColumn("Name");
			model.addColumn("Quantity");
			try {
				while (productList.next()) {
					String id = productList.getString(1);
					String name = productList.getString(2);
					String quentity = productList.getString(3);
					model.addRow(new String[] { id, name, quentity });
				}
			} catch (Exception e) {

			}
			JTable table = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(table);
			textfield.add(scrollPane);
		});
		previousorderlist.addActionListener(l -> {
			ResultSet order_list = new DbConnect().getOrderList();
			if (order_list == null) {
				return;
			}

			DefaultTableModel model = new DefaultTableModel();

			model.addColumn("ID");
			model.addColumn("Name");
			model.addColumn("Price");
			try {
				while (order_list.next()) {
					String id = order_list.getString(1);
					String name = order_list.getString(2);
					String price = order_list.getString(3);
					model.addRow(new String[] { id, name, price });
				}
			} catch (Exception e) {

			}

			JTable table = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(table);
			textfield.add(scrollPane);
		});

		add(textfield);
		textfield.setBounds(5, 120, 875, 375);

		Adder = new JButton("Add New Sell");
		add(Adder);
		Adder.setBounds(5, 500, 150, 30);

		logout = new JButton("Logout");
		add(logout);
		logout.setBounds(780, 525, 100, 30);

	}
}
