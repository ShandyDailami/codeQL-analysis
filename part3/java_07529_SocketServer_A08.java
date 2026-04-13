import java.io.*;
import java.net.*;

public class java_07529_SocketServer_A08 {

    private ServerSocket serverSocket;

    public java_07529_SocketServer_A08(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() {
        System.out.println("Starting Socket Server...");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted New Connection from: " + socket.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Receive Message from Client
                String message = in.readUTF();
                System.out.println("Received: " + message);

                // Send Message to Client
                out.writeUTF("Message received. Thanks for connecting.");
                out.flush();

                // Close Connection
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
           
            }
       
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(6789);
        server.startServer();
    }
}