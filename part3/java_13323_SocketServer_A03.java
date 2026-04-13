import java.io.*;
import java.net.*;

public class java_13323_SocketServer_A03 {

    // Main method
    public static void main(String[] args) {
        Socket socket = null;

        try {
            // Create a socket
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Waiting for client on port: " + serverSocket.getLocalPort());

            // Accept a new connection
            socket = serverSocket.accept();

            // Create input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;

            // Read from the client
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);

                // If the input line is a command, then respond accordingly
                if (inputLine.equalsIgnoreCase("QUIT")) {
                    out.println("Closing the connection");
                    socket.close();
                    break;
                } else {
                    out.println("Echo: " + inputLine);
                }
            }

            // Close the connection
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}