import java.io.*;
import java.net.*;

public class java_39644_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(4444);
            System.out.println("Waiting for connection...");
            socket = server.accept();
            System.out.println("Connection established!");
            
            // Secure data transmission with SSLSocket
            SSLServerSocket sslServer = (SSLServerSocket) server;
            SSLSocket sslSocket = (SSLSocket) sslServer.accept();
            sslSocket.setNeedClientAuth(true);

            // Data input and output streams
            InputStream input = sslSocket.getInputStream();
            OutputStream output = sslSocket.getOutputStream();

            // Read data
            DataInputStream dataInputStream = new DataInputStream(input);
            DataOutputStream dataOutputStream = new DataOutputStream(output);

            // Write to client
            dataOutputStream.writeUTF("Hello Client!");

            // Read from client
            String message = dataInputStream.readUTF();
            System.out.println("Message from client: " + message);

            sslSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}