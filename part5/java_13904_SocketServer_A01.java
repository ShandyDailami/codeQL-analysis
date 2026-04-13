import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_13904_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);
        System.out.println("Server started on port 4444");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received: " + request);

                // Here we're simulating a security breach related to BrokenAccessControl
                // We're checking if the request is a command to break the loop and abort the connection
                if (request.equals("abort")) {
                    System.out.println("Aborting connection...");
                    clientSocket.close();
                    break;
                }

                // We're simulating a security breach related to BrokenAccessControl
                // We're sending a response back to the client
                out.println("Hello, client");
            }

            clientSocket.close();
        }
    }
}