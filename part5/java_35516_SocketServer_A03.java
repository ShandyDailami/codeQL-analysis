import java.io.*;
import java.net.*;

public class java_35516_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444); // port number
        System.out.println("Server is listening on port 4444...");

        while (true) {
            Socket socket = server.accept(); // wait for connection
            System.out.println("Client connected");

            // create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read request from client
            String request = in.readLine();
            System.out.println("Received request: " + request);

            // send back a response
            String response = "Hello, client!";
            out.writeBytes(response + "\n");

            socket.close();
        }
    }
}