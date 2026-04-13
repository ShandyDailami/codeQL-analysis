import java.io.*;
import java.net.*;

public class java_11456_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started.");

        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected.");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received message: " + message);

            out.writeUTF("Message received: " + message);
            out.flush();

            socket.close();
        }
    }
}