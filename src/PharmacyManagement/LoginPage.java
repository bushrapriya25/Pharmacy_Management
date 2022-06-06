package PharmacyManagement;

import javax.swing.*;

public class LoginPage extends JPanel {
	public JButton login, signup;
	private JTextField email;
	private JPasswordField password;

	public LoginPage() {
		setLayout(null);
		setSize(900, 600);

		JLabel header = new JLabel("Login to Pharmacy Management", SwingConstants.CENTER);
		add(header);
		header.setBounds(250, 50, 400, 40);

		JLabel label1 = new JLabel("Email");
		add(label1);
		label1.setBounds(300, 100, 300, 20);

		email = new JTextField();
		add(email);
		email.setBounds(300, 140, 300, 40);

		JLabel label2 = new JLabel("Password");
		add(label2);
		label2.setBounds(300, 200, 300, 20);

		password = new JPasswordField();
		add(password);
		password.setBounds(300, 240, 300, 40);

		login = new JButton("Login");
		add(login);
		login.setBounds(300, 320, 300, 32);

		signup = new JButton("Don't have an account? Signup.");
		add(signup);
		signup.setBounds(300, 520, 300, 30);

	}

	public boolean loginUser() {
		String email = this.email.getText();
		String password = String.valueOf(this.password.getPassword());

		String query = "SELECT * FROM `users` WHERE `email` = '" + email + "'AND `password`= '" + password + "'";

		try {
			DbConnect dbConnect = new DbConnect();
			dbConnect.resultSet = dbConnect.statement.executeQuery(query);
			System.out.println(dbConnect.resultSet);
			if (dbConnect.resultSet != null) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return false;
	}

}
