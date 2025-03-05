import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Server implements ActionListener {
    JTextField msg;
    JPanel chat_panel;
    static Box vBox = Box.createVerticalBox();
    static JFrame frame = new JFrame();
    static DataOutputStream dOut;

    Server() {
        Border chat_panelBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        Border msgBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        Border sendBorder = BorderFactory.createLineBorder(Color.BLACK, 1);

        //NAME OF THE PROGRAM
        JLabel head_text = new JLabel();
        head_text.setText("WHATSUPP");
        head_text.setBackground(null);
        head_text.setForeground(Color.WHITE);
        head_text.setFont(new Font("Arial Rounded MT", Font.BOLD, 30));

        JPanel head_panel = new JPanel();
        head_panel.setBounds(40,0, 545, 60);
        head_panel.setBackground(null);
        head_panel.setLayout(new GridBagLayout());
        head_panel.add(head_text);


        //THE CHAT PANEL
        Box vbox_messages = Box.createVerticalBox();

        chat_panel = new JPanel();
        chat_panel.setBounds(40,60, 545, 323);
        chat_panel.setBackground(new Color(0xf2f2f2));
        chat_panel.setLayout(new BorderLayout());
        chat_panel.setBorder(chat_panelBorder);


        //MESSAGING
        msg = new JTextField();
        msg.setBorder(msgBorder);
        msg.setFont(new Font("Arial", Font.PLAIN, 17));
        msg.setBounds(40, 390, 450, 30);

        JButton send = new JButton();
        send.setText("SEND");
        send.setBorder(sendBorder);
        send.setBackground(new Color(0x475161));
        send.setForeground(Color.WHITE);
        send.setBounds(495, 390, 90, 30);
        send.addActionListener(this);


        //FRAME
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(0x479bcc));
        frame.setResizable(false);
        frame.add(head_panel);
        frame.add(chat_panel);
        frame.add(msg);
        frame.add(send);
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String out = msg.getText();

            JLabel output = new JLabel(out);

            JPanel p2 = formatLabel(out);

            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);

            vBox.add(Box.createVerticalStrut(5));
            vBox.add(right);

            chat_panel.add(vBox, BorderLayout.PAGE_START);

            dOut.writeUTF(out);

            msg.setText("");

            frame.repaint();
            frame.invalidate();
            frame.validate();

        } catch (Exception a) {
            a.printStackTrace();
        }

    }

    public static JPanel formatLabel(String out){

        //OUTPUT TEXTBOX
        JLabel output = new JLabel("<html><p style=\"width: 210px\">" + out + "</p></html>");
        output.setFont(new Font("Arial", Font.PLAIN, 17));
        output.setBackground(new Color(0x475161));
        output.setForeground(Color.WHITE);
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(5, 5, 5, 5));

        //TIME OF MSG
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));

        //ADDING EVERYTHING TO A PANEL
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0xf2f2f2));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(output);
        panel.add(time);

        return panel;
    }
}
