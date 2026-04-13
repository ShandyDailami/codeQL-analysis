import java.io.*;
import java.net.*;

public class java_05387_SocketServer_A07 {

    private static int portNumber = 9876;

    public static void main(String[] args) {

        try {
            ServerSocket server = new ServerSocket(portNumber);
            while (true) {
                Socket socket = server.accept();
                System.out.println("A client has connected");

                // Create stream objects to handle data exchange
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read message from client
                String message = in.readUTF();
                System.out.println("Client says: " + message);

                // Prepare response
                String response = "Hello, client";

                // Send response back to client
                out.writeUTF(response);
                out.flush();

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}