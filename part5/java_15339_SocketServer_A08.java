import java.net.*;
import java.io.*;

public class java_15339_SocketServer_A08 {
    public static void main(String args[]) {
        ServerSocket server = null;
        while (true) {
            try {
                server = new ServerSocket(8080); // port number
                System.out.println("Waiting for client on port: " + 
                                    server.getLocalPort() + "...");
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                // Create a InputStream and OutputStream
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Perform security-sensitive operations related to A08_IntegrityFailure
                // ...

                String message = dis.readUTF();
                System.out.println("Received: " + message);

                // Send back a response
                dos.writeUTF("Server response: " + message);
                dos.flush();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Exception caught: " + e.getMessage());
            }
        }
    }
}