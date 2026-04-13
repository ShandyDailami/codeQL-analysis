import java.io.*;
import java.net.*;

public class java_01656_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // Create a server socket and listen on port 4444
            serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                // Accept a new connection
                Socket socket = serverSocket.accept();

                // Create input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read a line of text from the client
                String line = in.readLine();

                // Send the line of text back to the client
                out.writeBytes(line + "\n");

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Ensure the server socket is closed
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}