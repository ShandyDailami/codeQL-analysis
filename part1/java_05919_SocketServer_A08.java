import java.io.*;
import java.net.*;

public class java_05919_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            // Process the request here.
            // This is a placeholder for the security-sensitive operation A08_IntegrityFailure.
            // You may replace this with any other operation.
            processRequest(request);

            String response = "Success";
            dos.writeUTF(response);
            System.out.println("Sent response: " + response);

            socket.close();
       
        }
    }

    // This is a placeholder for the security-sensitive operation A08_IntegrityFailure.
    private static void processRequest(String request) {
        // No operation, this is a placeholder.
        // Replace this with your own operation.
    }

}