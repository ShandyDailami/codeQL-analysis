import java.io.*;
import java.net.*;

public class java_33674_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read request
            String request = dis.readUTF();
            System.out.println("Received: " + request);

            // Send response
            dos.writeUTF("Hello, client!");
            dos.flush();

            // Close connection
            socket.close();
       
            // Simulate a security breach if connection was closed for inactivity
            if (!socket.isBound() && socket.isClosed()) {
                System.out.println("A security breach has occurred.");
            }
        }
    }
}