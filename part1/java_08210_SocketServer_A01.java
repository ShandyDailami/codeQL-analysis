import java.net.*;
import java.io.*;

public class java_08210_SocketServer_A01 {
    public static void main(String args[]) {
        int port = 6666;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle the request in a new thread
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection");
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_08210_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage, serverMessage;

            while ((clientMessage = in.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                serverMessage = "Server says: " + clientMessage;
                out.writeBytes(serverMessage + '\n');
            }

            socket.close();
        } catch (IOException ex) {
            System.out.println("Error handling client");
        }
    }
}