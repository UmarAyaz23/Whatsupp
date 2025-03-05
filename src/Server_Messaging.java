import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Messaging extends Server{
    public static void main(String[] args){
        Server server = new Server();

        try{
            ServerSocket ss = new ServerSocket(106);

            while(true){
                Socket s = ss.accept();
                DataInputStream dIn = new DataInputStream(s.getInputStream());
                dOut = new DataOutputStream(s.getOutputStream());

                while(true){
                    String Msg = dIn.readUTF();
                    JPanel panel = formatLabel(Msg);

                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);

                    vBox.add(left);

                    frame.validate();
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
