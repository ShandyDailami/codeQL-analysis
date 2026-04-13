import java.io.*;
import java.net.*;

public class java_15402_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                // read the request
                String request = input.readUTF();
                System.out.println("Received request: " + request);

                // process the request and send the response
                String response = processRequest(request);
                output.writeUTF(response);
                System.out.println("Sent response: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static String processRequest(String request) {
        // TODO: add your security-sensitive operations here
        // e.g. use of a secure algorithm to hash the request or compare it to a stored value
        // return a suitable response
        return "Server received your request: " + request;
    }
}