package PharmacyManagement;

import javax.swing.*;

public class SignupPage extends JPanel {

    public JButton create, signin;
    JTextField email, name;
    JPasswordField password;

    public SignupPage() {
        setLayout(null);
        setSize(900, 600);

        JLabel header = new JLabel("Signup for Login to Pharmacy Management", SwingConstants.CENTER);
        add(header);
        header.setBounds(250, 50, 400, 40);

        JLabel label1 = new JLabel("Name");
        add(label1);
        label1.setBounds(300, 100, 300, 20);

        name = new JTextField();
        add(name);
        name.setBounds(300, 140, 300, 40);

        JLabel label2 = new JLabel("Email");
        add(label2);
        label2.setBounds(300, 200, 300, 20);

        email = new JTextField();
        add(email);
        email.setBounds(300, 240, 300, 40);

        JLabel label3 = new JLabel("Password");
        add(label3);
        label3.setBounds(300, 300, 300, 20);

        password = new JPasswordField();
        add(password);
        password.setBounds(300, 340, 300, 40);

        create = new JButton("Create");
        add(create);
        create.addActionListener(l -> signupUser());
        create.setBounds(300, 410, 300, 32);

        signin = new JButton("Already have an account? Signin.");
        add(signin);
        signin.setBounds(300, 520, 300, 30);
    }

    public boolean signupUser() {
        String a = this.name.getText();
        String b = this.email.getText();
        String c = String.valueOf(this.password.getPassword());
        System.out.println(a + " " + b + " " + c);
        String query = "INSERT INTO `users` (`name`, `email`, `password`) VALUES ('" + a + "', '" + b + "', '" + c + "')";

        if (c.length() < 8) {
            return false;
        }

        try {
            DbConnect dbConnect = new DbConnect();
            dbConnect.statement.executeUpdate(query);
            System.out.println("success");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}
