import java.io.*;
import java.net.*;
import java.util.*;

public class java_04424_SocketServer_A08 {
    // Server port number
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create data input and output streams
                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // Read data from the client
                String data = input.readUTF();
                System.out.println("Received data from client: " + data);

                // Process the data
                String processedData = processData(data);
                System.out.println("Processed data: " + processedData);

                // Send processed data back to the client
                output.writeUTF(processedData);
                System.out.println("Sent processed data back to client");

                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processData(String data) {
        // Simulate integrity failure (for example, data is reversed)
        String reversedData = new StringBuilder(data).reverse().toString();
        return reversedData;
    }
}