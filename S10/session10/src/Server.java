import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server class.
 * @author Helia Hashemipour
 * @since 2020
 */

public class Server {
    public static void main(String[] args) {
        try (ServerSocket welcomingSocket = new ServerSocket(5000)) {//the port is in the manual
            System.out.println("Server started. \nWaiting for a client ...");
            int count=0;
            while (true) {
                Socket connectionSocket = welcomingSocket.accept();
                count++;
                System.out.println("Client("+count+")"+ " accepted");

                ClientHandler handler = new ClientHandler(connectionSocket,count);//multi-threading
                Thread thread = new Thread(handler,"Handler thread");
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ClientHandler class
     * For handling more than one client.
     */
    private static class ClientHandler implements Runnable {
        private Socket connectionSocket;
        private int countNum;
        public ClientHandler(Socket connectionSocket,int countNum) {
            this.connectionSocket = connectionSocket;
            this.countNum=countNum;
        }
        @Override
        public void run() {
            DataInputStream in;
            DataOutputStream out;
            StringBuilder res = new StringBuilder();
            while (true) {
                try {
                    in = new DataInputStream(connectionSocket.getInputStream());
                    out = new DataOutputStream(connectionSocket.getOutputStream());
                    String line = in.readUTF();
                    System.out.println("- From Client("+countNum+"):" + line);
                    res.append(line).append("\t");
                    out.writeUTF(res.toString());
                    System.out.println("+ To Client("+countNum+"):" + res.toString());//print what the client entered
                    if (line.equals("over")) {//the specific word for closing the client connection
                        System.out.println("Closing connection for  Client("+countNum+") .");
                        System.out.println();
                        break;
                    }

                }catch (IOException e) {
                    System.err.println(e.toString());
                    return;
                }
            }
            try {
                // closing resources & handle exceptions
                in.close();
                out.close();

            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
