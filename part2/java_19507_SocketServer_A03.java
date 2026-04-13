import java.io.*;
import java.net.*;

public class java_19507_SocketServer_A03 {
    private static final int port = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started at port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String request = input.readUTF();
            System.out.println("Received request: " + request);

            String response = processRequest(request);

            output.writeUTF(response);
            output.flush();
            System.out.println("Sent response: " + response);

            socket.close();
        }
    }

    private static String processRequest(String request) {
        // This is a simple example of a security-sensitive operation.
        // In a real-world application, this operation would likely involve more complex operations.
        // It's also important to note that this example does not involve injection.

        if (request.contains("badword")) {
            return "Bad word detected, processing stopped.";
        }

        return "Processed request: " + request;
    }
}