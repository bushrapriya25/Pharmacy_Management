 package PharmacyManagement;

import javax.swing.*;
import java.awt.*;

public class Addnew extends JPanel {
    JButton back, done;
    JTextField t1;
    public Addnew(){
        setLayout(null);
        setSize(900, 600);

        JLabel header = new JLabel("Add a new sell in order list",SwingConstants.CENTER);
        add(header);
        header.setForeground(Color.BLACK);
        header.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        header.setBounds(5, 10, 875, 40);

        done = new JButton("Done");
        add(done);
        done.setBounds(750, 500, 100, 30);
        done.addActionListener(l->{

            String[] items = t1.getText().split(",");
            new DbConnect().addOrders(items[0],items[1]);

        });

        t1 = new JTextField();
        add(t1);
        t1.setBounds(5, 70, 875, 40);


        back = new JButton("Back");
        add(back);
        back.setBounds(25, 500, 100, 30);
    }
}
