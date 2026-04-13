import java.io.*;
import java.net.*;

public class java_23957_SocketServer_A01 {

    private static boolean stopServer = false;

    public static void main(String args[]) {

        int port = 8080;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started at port: " + port);

            while (!stopServer) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Read from the client
                DataInputStream in = new DataInputStream(socket.getInputStream());
                String clientMessage = in.readUTF();
                System.out.println("Received from client: " + clientMessage);

                // Send response
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String response = "Hello client, you connected successfully!";
                out.writeUTF(response);
                System.out.println("Sent to client: " + response);

                socket.close();
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}