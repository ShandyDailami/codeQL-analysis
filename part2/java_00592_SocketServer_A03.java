import java.io.*;
import java.net.*;

public class java_00592_SocketServer_A03 {
    private ServerSocket serverSocket;

    public java_00592_SocketServer_A03(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port + "...");
    }

    public void startServer() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected!");

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(clientSocket));
            thread.start();
        }
    }

    public static void main(String[] args) {
        try {
            new SocketServer(8080).startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private BufferedReader in;
    private PrintWriter out;

    public java_00592_SocketServer_A03(Socket socket) {
        this.clientSocket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        } catch (IOException e) {
            closeConnection();
        }
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // Here we are just echoing back the message to the client
                out.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}