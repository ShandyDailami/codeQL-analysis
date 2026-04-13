import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00918_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        // Set the port number to listen on
        int portNumber = 8080;
        ServerSocket serverSocket = new ServerSocket(portNumber);

        while (true) {
            System.out.println("Waiting for client on port " + portNumber);
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            // Create a new thread to handle the client request
            new Thread(() -> {
                try {
                    // Create a new input stream and output stream for the client
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                    // Read the client request
                    String clientRequest = in.readLine();
                    System.out.println("Received: " + clientRequest);

                    // Send a response back to the client
                    String response = "Hello, client!";
                    out.println(response);

                    // Close the connection
                    clientSocket.close();
                    System.out.println("Connection closed.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}