package PharmacyManagement;

import javax.swing.*;

import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class Main {

	    public static void main(String[] args) {

	        new DbConnect();

	        // write your code here
	        JFrame frame = new JFrame();
	        frame.setSize(900, 600);
	        frame.setLayout(null);
	        frame.setResizable(false);
	        frame.setDefaultCloseOperation(3);
	        frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	        DashboardPage dashboardPage = new DashboardPage();
	        dashboardPage.setVisible(false);
	        frame.add(dashboardPage);
	        dashboardPage.setBounds(0, 0, 900, 600);

	        LoginPage loginPage = new LoginPage();
	        loginPage.setVisible(true);
	        frame.add(loginPage);
	        loginPage.setBounds(0, 0, 900, 600);

	        SignupPage signupPage = new SignupPage();
	        signupPage.setVisible(false);
	        frame.add(signupPage);
	        signupPage.setBounds(0, 0, 900, 600);

	        Addnew addnew = new Addnew();
	        addnew.setVisible(false);
	        frame.add(addnew);
	        addnew.setBounds(0,0,900,600);

	        loginPage.login.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if(loginPage.loginUser()){
	                    loginPage.setVisible(false);
						dashboardPage.setVisible(true);
	                }
	                else
	                {
	                    JOptionPane.showMessageDialog(null, "Invalid Credentials!");
	                }
	            }

	        });
	        loginPage.signup.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                loginPage.setVisible(false);
	                signupPage.setVisible(true);
	            }
	        });

	        signupPage.create.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if(signupPage.signupUser()){
	                    signupPage.setVisible(false);
	                    loginPage.setVisible(true);
	                    JOptionPane.showMessageDialog(null, "Account created successfully.");
	                }else{
	                    JOptionPane.showMessageDialog(null, "Failed to create account.");
	                }
	            }
	        });

	        signupPage.signin.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                signupPage.setVisible(false);
	                loginPage.setVisible(true);
	            }
	        });
	        dashboardPage.Adder.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dashboardPage.setVisible(false);
	                addnew.setVisible(true);
	            }
	        });
	        addnew.back.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                addnew.setVisible(false);
	                dashboardPage.setVisible(true);
	            }
	        });
	        dashboardPage.logout.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                loginPage.setVisible(true);
	                dashboardPage.setVisible(false);
	            }
	        });
	        dashboardPage.Adder.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dashboardPage.setVisible(false);
	                addnew.setVisible(true);
	            }
	        });


	        frame.setVisible(true);
	    }
	}

