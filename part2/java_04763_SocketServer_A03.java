import java.net.*;
import java.io.*;

public class java_04763_SocketServer_A03 {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create a Server Socket on port 1234
            serverSocket = new ServerSocket(1234);
            System.out.println("Waiting for client on port 1234");

            // Accept a connection from a client
            socket = serverSocket.accept();
            System.out.println("Connection from " + socket.getRemoteSocketAddress());

            // Create an InputStream and an OutputStream
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Get a message from the client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // Send a response back to the client
            out.writeUTF("Hello, client, you are connected to port 1234");
            out.flush();

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}