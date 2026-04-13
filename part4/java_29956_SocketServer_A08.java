import java.io.*;
import java.net.*;

public class java_29956_SocketServer_A08 {
    private static final int port = 6789;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            while (true) {
                socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String request = dataInputStream.readUTF();
                System.out.println("Received request: " + request);

                // Here we assume that the request is a command that requires authentication.
                // In a real-world scenario, this could be a more complex process.
                boolean isAuthenticated = authenticate(request);

                if (isAuthenticated) {
                    dataOutputStream.writeUTF("Request processed successfully");
                } else {
                    dataOutputStream.writeUTF("Authentication failed, request not processed");
                }

                dataOutputStream.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) serverSocket.close();
            if (socket != null) socket.close();
        }
    }

    // This is a placeholder for a method that would authenticate a client.
    // In a real-world scenario, this would involve more complex authentication methods.
    private static boolean authenticate(String request) {
        // Placeholder for authentication logic.
        // In a real-world scenario, this would involve hashing and comparing the request to a stored hash.
        return request.equals("authenticateRequest");
    }
}