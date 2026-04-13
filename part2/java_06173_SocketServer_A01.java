import java.io.*;
import java.net.*;

public class java_06173_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server started at port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                String message = input.readUTF();
                System.out.println("Received: " + message);

                // Here, we're performing a security-sensitive operation related to Broken Access Control.
                // This operation is not implemented in the example, but should be implemented in a real-world scenario.
                // In this example, we're just echoing the message back to the client.
                output.writeUTF(message);
                output.flush();

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}