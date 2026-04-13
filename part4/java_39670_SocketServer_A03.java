import java.io.*;
import java.net.*;

public class java_39670_SocketServer_A03 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(1234); // listen on port 1234
            System.out.println("Waiting for a client...");

            socket = serverSocket.accept(); // wait for a client
            System.out.println("Client accepted!");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // read the message from the client
            String message = dataInputStream.readUTF();
            System.out.println("Received: " + message);

            // send a response back to the client
            String response = "Hello, client!";
            dataOutputStream.writeUTF(response);
            System.out.println("Sent: " + response);

            // close the connections
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}