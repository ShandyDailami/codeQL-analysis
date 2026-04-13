import java.io.*;
import java.net.*;

public class java_23623_SocketServer_A03 {
    public static void main(String args[]) {
        int port = 6000;

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("Server started at port: " + port);

            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("Client accepted from: " + socket.getRemoteSocketAddress());

                // Create input and output streams
                DataInputStream dis = new DataInputStream(socket.getInputStream());
                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                // Read message from client
                String message = dis.readUTF();

                System.out.println("Received: " + message);

                // Send message back to client
                dos.writeUTF("Thank you for connecting to " + socket.getRemoteSocketAddress() + "\n");

                // Close the connections
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}