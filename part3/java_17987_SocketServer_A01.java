import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_17987_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        int port = 1234; // Define the port number

        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server is listening on port " + port);

        while (true) {
            // Accept a new connection
            Socket clientSocket = serverSocket.accept();

            // Create a new thread to handle communication with this client
            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_17987_SocketServer_A01(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            // Get a writer for the client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Get a reader for the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;

            // Read from the client
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                out.println("Server received your message: " + inputLine);
            }

            // Close the connections
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}