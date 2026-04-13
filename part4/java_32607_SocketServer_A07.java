import java.io.*;
import java.net.*;
import java.util.*;

public class java_32607_SocketServer_A07 {

    // Creating a server socket
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        // Create a server socket
        serverSocket = new ServerSocket(8080);

        // Infinite loop for accepting multiple client
        while (true) {
            Socket clientSocket = serverSocket.accept();

            // Thread for handling client
            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket clientSocket;

    public java_32607_SocketServer_A07(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            // BufferedReader and PrintWriter for reading and writing
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read and send messages from the client
            String message;
            while ((message = in.readLine()) != null) {
                out.println("Echo: " + message);
            }

            // Close the connection
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}