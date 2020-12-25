import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Client Class.
 * @author Helia Hashemipour
 * @version 0.0
 */
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1",5000)) {//the host that related to my own server & the port is in the manual
            System.out.println("Connected");
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            Scanner scanner = new Scanner(System.in);
            String input;
            do {
                input = scanner.nextLine();
                out.writeUTF(input);

                System.out.println("+ From Server: " + in.readUTF());
            } while (!input.equals("over"));//the specific word for closing the client connection
            //close resources
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
