import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40173_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // Create the server socket
            System.out.println("Server is running on port 8080");

            while (true) { // Main server loop
                Socket clientSocket = serverSocket.accept(); // Accept a client connection
                System.out.println("A client has connected");

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received request: " + request);

                    if (request.equals("close")) {
                        out.println("Closing the connection");
                        break;
                    } else {
                        out.println("Hello, client, thanks for connecting!");
                    }
                }

                clientSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}