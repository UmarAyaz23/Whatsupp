import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Select extends JFrame{

    public Select() {

        Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK, 1);

        //NAME OF THE PAGE
        JLabel head_text = new JLabel();
        head_text.setText("WHATSUPP");
        head_text.setBackground(null);
        head_text.setForeground(Color.WHITE);
        head_text.setFont(new Font("Arial Rounded MT", Font.BOLD, 30));

        JPanel head_panel = new JPanel();
        head_panel.setBounds(40, 0, 545, 60);
        head_panel.setBackground(null);
        head_panel.setLayout(new GridBagLayout());
        head_panel.add(head_text);

        JLabel head2_text = new JLabel();
        head2_text.setText("PLEASE SELECT WHO TO TALK TO");
        head2_text.setBackground(null);
        head2_text.setForeground(Color.WHITE);
        head2_text.setFont(new Font("Arial Rounded MT", Font.PLAIN, 22));

        JPanel head2_panel = new JPanel();
        head2_panel.setBounds(40, 60, 545, 40);
        head2_panel.setBackground(null);
        head2_panel.setLayout(new GridBagLayout());
        head2_panel.add(head2_text);


        //BUTTONS TO SELECT
        JButton umar = new JButton();
        umar.setText("UMAR AYAZ");
        umar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        umar.setBorder(buttonBorder);
        umar.setBackground(new Color(0x475161));
        umar.setForeground(Color.WHITE);
        umar.setBounds(40, 150, 545, 50);

        JButton saaniya = new JButton();
        saaniya.setText("SAANIYA TEHSEEN");
        saaniya.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        saaniya.setBorder(buttonBorder);
        saaniya.setBackground(new Color(0x475161));
        saaniya.setForeground(Color.WHITE);
        saaniya.setBounds(40, 210, 545, 50);

        JButton zeeshan = new JButton();
        zeeshan.setText("ZEESHAN ALI KHAN");
        zeeshan.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        zeeshan.setBorder(buttonBorder);
        zeeshan.setBackground(new Color(0x475161));
        zeeshan.setForeground(Color.WHITE);
        zeeshan.setBounds(40, 270, 545, 50);

        JButton fahad = new JButton();
        fahad.setText("FAHAD AHMED KHAN");
        fahad.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 22));
        fahad.setBorder(buttonBorder);
        fahad.setBackground(new Color(0x475161));
        fahad.setForeground(Color.WHITE);
        fahad.setBounds(40, 330, 545, 50);


        //BUTTON FUNCTIONS
        umar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Server_Messaging sm = new Server_Messaging();

                Client_Messaging cm = new Client_Messaging();

            }
        });

        saaniya.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Server_Messaging sm = new Server_Messaging();
                //server.setTitle("Saaniya Tehseen");

                Client_Messaging cm = new Client_Messaging();
                //client.setTitle("You");
            }
        });

        zeeshan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Server_Messaging sm = new Server_Messaging();
                //server.setTitle("Zeeshan Ali Khan");

                Client_Messaging cm = new Client_Messaging();
                //client.setTitle("You");
            }
        });

        fahad.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Server_Messaging sm = new Server_Messaging();
                //server.setTitle("Fahad Ahmed Khan");

                Client_Messaging cm = new Client_Messaging();
                //client.setTitle("You");
            }
        });


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("SELECT");
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x479bcc));
        this.setResizable(false);
        this.add(head_panel);
        this.add(head2_panel);
        this.add(umar);
        this.add(saaniya);
        this.add(zeeshan);
        this.add(fahad);
        this.setSize(640, 480);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
