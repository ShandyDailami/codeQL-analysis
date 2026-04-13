import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12282_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        // Create a new server socket
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running and waiting for connections...");

        while (true) {
            // Accept a new client socket
            Socket clientSocket = serverSocket.accept();
            System.out.println("A client connected!");

            // Create a new thread for handling the client
            Thread clientHandler = new Thread(new ClientHandler(clientSocket));
            clientHandler.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_12282_SocketServer_A01(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Get the input and output streams from the client socket
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println(message);
            }

            // Close the client socket
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}