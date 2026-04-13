import java.net.*;
import java.io.*;

public class java_03485_SocketServer_A01 {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a ServerSocket and wait for a client to connect
            serverSocket = new ServerSocket(54321);
            System.out.println("Waiting for a client...");
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read from the client and send back
            String input;
            while ((input = in.readLine()) != null) {
                System.out.println("Received: " + input);
                out.println("Echo: " + input);
            }

            // Close the connection
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}