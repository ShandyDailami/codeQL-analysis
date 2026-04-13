import java.io.*;
import java.net.*;

public class java_27209_SocketServer_A07 {

    public static void main(String[] args) {

        // Create a socket
        ServerSocket server = null;
        try {
            server = new ServerSocket(5000);
            System.out.println("Server is running...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create input and output streams
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Read the request
                String request = dis.readUTF();
                System.out.println("Request: " + request);

                // Process the request
                String response = processRequest(request);

                // Send the response
                dos.writeUTF(response);
                dos.flush();
           
                // Close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try { server.close(); } catch (IOException e) { e.printStackTrace(); }
            }
        }
    }

    // Simulate a processing operation for the request
    private static String processRequest(String request) {
        // Add your security-sensitive operations here
        // For example, we add a delay to simulate a time-consuming process
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Response from server";
    }
}