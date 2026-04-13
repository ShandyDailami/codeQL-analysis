import java.io.*;
import java.net.*;

public class java_21551_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started at port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Start receiving data from client
            String clientMsg = in.readUTF();
            System.out.println("Client says: " + clientMsg);

            // Process the client request
            String responseMsg = processRequest(clientMsg);

            // Send response back to client
            out.writeUTF(responseMsg);
            out.flush();
       
            socket.close();
        }
    }

    private static String processRequest(String request) {
        // Injecting code here (e.g., using a library like OWASP Java Encoder)
        // Injection code goes here
        return request; // just return the request for now
    }
}