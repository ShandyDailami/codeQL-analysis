import java.net.*;
import java.io.*;

public class java_32067_SocketServer_A01 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a ServerSocket on port 4444
            serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                // Wait for a client to connect
                socket = serverSocket.accept();
                System.out.println("Client connected");

                // Create input and output streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Handle client requests
                while (true) {
                    String request = in.readUTF();
                    if (request.equals("close")) {
                        break;
                    }
                    out.writeUTF("Server received: " + request);
               
                }
                // Close streams and socket
                out.close();
                in.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}