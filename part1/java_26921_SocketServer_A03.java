import java.io.*;
import java.net.*;

public class java_26921_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // port 8080

        while (true) {
            Socket socket = server.accept(); // waiting for client

            // Reading from client
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF();

            System.out.println("Received: " + clientMessage);

            // Sending back to client
            String serverMessage = "Hello, client!";
            out.writeUTF(serverMessage);
            out.flush();
       
            socket.close();
        }
    }
}