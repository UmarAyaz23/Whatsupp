import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client_Messaging extends Client{
    public static void main(String[] args){
        Client client = new Client();

        try{
            Socket s = new Socket("localhost", 106);
            DataInputStream dIn = new DataInputStream(s.getInputStream());
            dOut = new DataOutputStream(s.getOutputStream());

            while(true){
                chat_panel.setLayout(new BorderLayout());
                String Msg = dIn.readUTF();
                JPanel panel = formatLabel(Msg);

                JPanel left = new JPanel(new BorderLayout());
                left.add(panel, BorderLayout.LINE_START);

                vBox.add(left);
                vBox.add(Box.createVerticalStrut(5));

                frame.validate();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
