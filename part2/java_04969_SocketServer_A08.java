import java.net.*;
import java.io.*;

public class java_04969_SocketServer_A08 {
    public static void main(String args[]) throws Exception {
        ServerSocket server = new ServerSocket(8000);
        System.out.println("Server started at port 8000...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected...!");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Reading client's request
            String request = input.readUTF();
            System.out.println("Received: " + request);

            // Sending response
            String response = "IntegrityFailure: " + request;
            output.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();
        }
    }
}