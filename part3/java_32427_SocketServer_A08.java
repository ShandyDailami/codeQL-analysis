import java.io.*;
import java.net.*;
import java.util.*;

public class java_32427_SocketServer_A08 {

    private List<Socket> clients = new ArrayList<>();
    private ServerSocket server;

    public java_32427_SocketServer_A08() {
        try {
            this.server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("New client connected");
                clients.add(socket);
                handleClient(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleClient(Socket socket) {
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage;
            while ((clientMessage = in.readUTF()) != null) {
                System.out.println("Received message from client: " + clientMessage);

                // A08_IntegrityFailure related operation here

                // sending message to all clients
                for (Socket client : clients) {
                    out.writeUTF("Server: " + clientMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UniqueVanillaServer().startServer();
    }
}