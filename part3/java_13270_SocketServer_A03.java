import java.net.*;
import java.io.*;

public class java_13270_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000); // listen on port 8000
        System.out.println("Server is running and waiting for client connections...");
        while (true) {
            Socket clientSocket = serverSocket.accept(); // waiting for client connection
            System.out.println("A client has connected!");

            // create streams for reading and writing
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // get client's message and send it back to client
            String message = in.readUTF();
            System.out.println("Received: " + message);
            out.writeUTF("Server received your message: " + message);

            // close streams
            in.close();
            out.close();
            clientSocket.close();
        }
    }
}