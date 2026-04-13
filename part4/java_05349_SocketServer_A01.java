import java.io.*;
import java.net.*;

public class java_05349_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started at port 8080.");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected.");

            // Create input and output streams
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read a request from the client
            String request = dis.readUTF();
            System.out.println("Received request: " + request);

            // Process the request
            String response;
            if (request.equals("Hello")) {
                response = "Hello, client!";
            } else {
                response = "Unknown request!";
            }

            // Send the response back to the client
            dos.writeUTF(response);
            dos.flush();

            socket.close();
        }
    }
}