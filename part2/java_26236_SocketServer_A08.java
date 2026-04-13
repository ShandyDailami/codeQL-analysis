import java.net.*;
import java.io.*;

public class java_26236_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 6000;
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message = in.readUTF();
                System.out.println("Received: " + message);

                String response = "Hello, client!";
                out.writeUTF(response);
                System.out.println("Sent: " + response);

                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}