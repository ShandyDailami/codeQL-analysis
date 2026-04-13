import java.net.*;
import java.io.*;

public class java_41588_SocketServer_A08 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started. Waiting for client connections...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                out.writeUTF("Connected to " + clientSocket.getRemoteSocketAddress());
                out.close();

                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } catch (IOException ex) {
            System.out.println("Error in SocketServerExample: " + ex.getMessage());
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_41588_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                System.out.println("Received: " + in.readUTF());
                in.close();
            } catch (IOException ex) {
                System.out.println("Error in ClientHandler: " + ex.getMessage());
            }
        }
    }
}