import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class Login extends JFrame{
    private Map<String, String> credentials;
    public Login(){
        Border credentialsBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        
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
        head2_text.setText("LOGIN PAGE");
        head2_text.setBackground(null);
        head2_text.setForeground(Color.WHITE);
        head2_text.setFont(new Font("Arial Rounded MT", Font.PLAIN, 22));

        JPanel head2_panel = new JPanel();
        head2_panel.setBounds(40, 60, 545, 40);
        head2_panel.setBackground(null);
        head2_panel.setLayout(new GridBagLayout());
        head2_panel.add(head2_text);


        //THE CREDENTIALS
        JButton usernameLabel = new JButton();
        usernameLabel.setText("Username: ");
        usernameLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
        usernameLabel.setBorder(credentialsBorder);
        usernameLabel.setBackground(new Color(0x475161));
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(40, 200, 150, 30);
        usernameLabel.setEnabled(false);

        JTextField usernameField = new JTextField();
        usernameField.setBorder(credentialsBorder);
        usernameField.setFont(new Font("Arial", Font.PLAIN, 17));
        usernameField.setBounds(210, 200, 370, 30);

        JButton passwordLabel = new JButton();
        passwordLabel.setText("Password: ");
        passwordLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
        passwordLabel.setBorder(credentialsBorder);
        passwordLabel.setBackground(new Color(0x475161));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(40, 260, 150, 30);
        passwordLabel.setEnabled(false);

        JTextField passwordField = new JTextField();
        passwordField.setBorder(credentialsBorder);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 17));
        passwordField.setBounds(210, 260, 370, 30);

        JButton loginButton = new JButton();
        loginButton.setText("LOGIN");
        loginButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 17));
        loginButton.setBorder(credentialsBorder);
        loginButton.setBackground(new Color(0x475161));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBounds(480, 320, 100, 30);


        loadCredentials();

        //BUTTON FUNCTION
        loginButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                if (validateCredentials(username, password)) {
                    JOptionPane.showMessageDialog(null, "Welcome!");
                    dispose();
                    Select select = new Select();
                } else {
                    JOptionPane.showMessageDialog(null, "Try Again!");
                }
            }
        });


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("LOGIN");
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(0x479bcc));
        this.setResizable(false);
        this.add(head_panel);
        this.add(head2_panel);
        this.add(usernameLabel);
        this.add(usernameField);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(loginButton);
        this.setSize(640, 480);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    private void loadCredentials() {
        credentials = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("credentials.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String username = parts[0];
                    String password = parts[1];
                    credentials.put(username, password);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean validateCredentials(String username, String password) {
        String storedPassword = credentials.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

}
