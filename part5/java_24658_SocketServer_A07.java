import java.io.*;
import java.net.*;

public class java_24658_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        int port = 8080; // Listening port

        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started at port: " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Authenticate the client
            // In a real-world application, you would use secure authentication methods like SSL/TLS
            boolean authenticated = authenticateClient(in, out);

            if (!authenticated) {
                out.writeUTF("Authentication failed");
                out.close();
                socket.close();
                continue;
            }

            // Handle client request
            String request = in.readUTF();
            out.writeUTF("Response: " + request);
            out.close();
            socket.close();
       
        }
    }

    private static boolean authenticateClient(DataInputStream in, DataOutputStream out) throws IOException {
        // In a real-world application, you would use secure authentication methods like SSL/TLS
        // Here, we just return true for simplicity
        return true;
    }
}