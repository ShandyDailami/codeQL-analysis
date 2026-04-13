import java.io.*;
import java.net.*;
import java.util.*;

public class java_12792_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(6000);
            System.out.println("Waiting for client connection...");

            // accept incoming client
            socket = serverSocket.accept();
            System.out.println("Client connected!");

            DataInputStream dataIn = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());

            // read the message from client
            String message = dataIn.readUTF();
            System.out.println("Client says: " + message);

            // send the message back to the client
            dataOut.writeUTF("Hello client, your message has been received.");
            dataOut.close();

            socket.close();
            serverSocket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}