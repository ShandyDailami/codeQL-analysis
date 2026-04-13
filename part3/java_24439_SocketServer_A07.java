import java.net.*;
import java.io.*;

public class java_24439_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 6000; // default port
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            // create server socket
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            // wait for client connection
            clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // create input and output streams
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            // read request from client
            String request = in.readUTF();
            System.out.println("Received request: " + request);

            // authentication logic
            // In this example, we'll just check if the request is "auth"
            if ("auth".equals(request)) {
                out.writeUTF("Success");
            } else {
                out.writeUTF("Failed");
            }

            // close streams and socket
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}