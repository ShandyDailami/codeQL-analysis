import java.io.*;
import java.net.*;

public class java_41041_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444); // port number
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Basic authentication: always send a greeting back
                out.writeUTF("Server: Hello Client!");

                // Now for the handshake, we'll use SSL
                SSLServerSocket sslServer = (SSLServerSocket) server;
                SSLSocket sslSocket = (SSLSocket) sslServer.accept();
                sslSocket.setNeedClientAuth(true);

                // Ask for client certificate
                SSLSession sslSession = sslSocket.getSession();
                sslSession.setWantServerAuth(true);

                // Now we read data from the client
                DataInputStream in = new DataInputStream(socket.getInputStream());
                System.out.println("Client says: " + in.readUTF());

                // Close the connection
                sslSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}