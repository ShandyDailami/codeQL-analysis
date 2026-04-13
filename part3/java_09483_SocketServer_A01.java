import java.io.*;
import java.net.*;

public class java_09483_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server is running...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected!");

                // Create input and output streams
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Echo client messages
                String clientInput;
                while ((clientInput = in.readLine()) != null) {
                    out.println("Server received: " + clientInput);
                }

                // Close the socket
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}