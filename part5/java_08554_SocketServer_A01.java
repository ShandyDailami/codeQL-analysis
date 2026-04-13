import java.io.*;
import java.net.*;

public class java_08554_SocketServer_A01 {
    private ServerSocket serverSocket;

    public java_08554_SocketServer_A01(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() {
        System.out.println("Server started at port " + serverSocket.getLocalPort() + "...");

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage, serverMessage;

                // Receive message from client
                clientMessage = in.readUTF();
                System.out.println("Received: " + clientMessage);

                // Echo back message to client
                serverMessage = "Server: " + clientMessage;
                out.writeUTF(serverMessage);
                System.out.println("Sent: " + serverMessage);

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Client disconnected");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(5000);
        server.startServer();
    }
}