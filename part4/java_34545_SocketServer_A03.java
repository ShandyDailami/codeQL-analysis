import java.io.*;
import java.net.*;

public class java_34545_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Waiting for client on port " + 5000);

            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received: " + message);

            String response = processRequest(message);
            output.writeUTF(response);
            System.out.println("Sent: " + response);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }

    private static String processRequest(String request) {
        // This is a placeholder for a security-sensitive operation related to A03_Injection
        // You should implement the logic to prevent the injection yourself
        // For example:
        // return "Processed request: " + request;
        
        return "Processed request: " + request;
    }
}