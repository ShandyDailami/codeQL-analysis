import java.io.*;
import java.net.*;

public class java_10481_SocketServer_A03 {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client connected!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            // Perform security sensitive operation here

            output.writeUTF("Message received and processed");
            socket.close();
       
        }

    }

}