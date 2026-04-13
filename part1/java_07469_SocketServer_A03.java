import java.io.*;
import java.net.*;

public class java_07469_SocketServer_A03 {
    private static int port = 8888;
    private static ServerSocket serverSocket;
    
    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);
            while (true) {
                handleClient(serverSocket.accept());
            }
        } catch (IOException e) {
            System.out.println("Error in server: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); }
                catch (IOException e) { /* nothing to do */ }
            }
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            InputStream input = clientSocket.getInputStream();
            DataInputStream dis = new DataInputStream(input);
            OutputStream output = clientSocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(output);

            String request = dis.readUTF();
            System.out.println("Client says: " + request);

            String response = "Hello, you have connected to the server!";
            dos.writeUTF(response);
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        }
    }
}