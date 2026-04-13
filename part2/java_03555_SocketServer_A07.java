import java.io.*;
import java.net.*;
import java.util.*;

public class java_03555_SocketServer_A07 {

    private List<ClientHandler> clients = new ArrayList<>();

    class ClientHandler extends Thread {
        Socket clientSocket;
        DataInputStream dis;
        DataOutputStream dos;

        public java_03555_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
            try {
                dis = new DataInputStream(clientSocket.getInputStream());
                dos = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String clientMessage;
            while (true) {
                try {
                    clientMessage = dis.readUTF();
                    System.out.println("Received: " + clientMessage);

                    // Authentication
                    if ("auth".equals(clientMessage)) {
                        dos.writeUTF("accepted");
                    } else {
                        dos.writeUTF("denied");
                    }

                } catch (IOException e) {
                    clients.remove(this);
                    close();
                }
            }
        }

        private void close() {
            try {
                clientSocket.close();
                dis.close();
                dos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer().startServer(5000);
    }

    private void startServer(int port) {
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started on port: " + port);
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Accepted new client: " + clientSocket.getRemoteSocketAddress());
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clients.add(clientHandler);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}