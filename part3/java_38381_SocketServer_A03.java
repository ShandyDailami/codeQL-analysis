import java.net.*;
import java.io.*;

// Create a new thread for each client that connects
public class java_38381_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create new input and output streams for the client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Get the client's message
            String message = in.readLine();
            System.out.println("Received: " + message);

            // Check if the message is a command to close the connection
            if (message.equals("close")) {
                out.writeBytes("Connection closed.\n");
                socket.close();
            } else {
                // Send a response back to the client
                out.writeBytes("Hello client, you said: \"" + message + "\"!\n");
            }

            // Close the input and output streams
            in.close();
            out.close();
       .
        // Continue with your code

        }
    }
}