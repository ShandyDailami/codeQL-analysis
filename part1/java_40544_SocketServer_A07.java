import java.io.*;
import java.net.*;

public class java_40544_SocketServer_A07 {

    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            // Step 1: Creating the server socket
            serverSocket = new ServerSocket(5000);
            System.out.println("Server started at port 5000");

            // Step 2: Listening for a client
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Step 3: Communication with the client
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String clientMessage = dataInputStream.readUTF();
            System.out.println("Client says: " + clientMessage);

            String serverMessage = "Hello Client";
            dataOutputStream.writeUTF(serverMessage);
            System.out.println("Server says: " + serverMessage);

            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}