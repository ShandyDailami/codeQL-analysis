import java.io.*;
import java.net.*;

public class java_20930_SocketServer_A03 {

    public static void main(String[] args) {
        int port = 5555; // define the port
        try {
            ServerSocket serverSocket = new ServerSocket(port); // create server socket
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept(); // accept client
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientMessage = in.readUTF(); // read client message
                System.out.println("Client says: " + clientMessage);

                String serverMessage = "Hello, you sent: " + clientMessage; // create server message
                out.writeUTF(serverMessage); // write server message to client
                System.out.println("Server says: " + serverMessage);

                socket.close(); // close socket
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}