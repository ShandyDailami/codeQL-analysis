import java.io.*;
import java.net.*;

public class java_20929_SocketServer_A03 {
    private static final String SERVER_STATE = "Server Started...\n";
    private ServerSocket serverSocket;

    public java_20929_SocketServer_A03(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println(SERVER_STATE);
    }

    public void listenForClients() {
        while(true) {
            try {
                System.out.println("Waiting for a client...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                // Create input and output streams
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Read from client
                String clientMessage = in.readUTF();
                System.out.println("Received: " + clientMessage);

                // Write back to client
                String serverMessage = "Hello, client!";
                out.writeUTF(serverMessage);
                System.out.println("Sent: " + serverMessage);

                clientSocket.close();
            } catch(IOException e) {
                e.printStackTrace();
           
                // Close the current socket
                if(serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch(IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(1234);
        server.listenForClients();
    }
}