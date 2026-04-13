import java.io.*;
import java.net.*;

public class java_31631_SocketServer_A08 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a ServerSocket and bind it to port 8080
            serverSocket = new ServerSocket(8080);
            System.out.println("Server is running...");

            // Accept a new connection
            socket = serverSocket.accept();
            System.out.println("A new client connected");

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read data from the client
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                // Send back data to the client
                out.writeUTF("Hello: " + inputLine);
                out.flush();
            }

            // Close the connection
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}