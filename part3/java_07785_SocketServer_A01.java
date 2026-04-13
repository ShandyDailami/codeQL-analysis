import java.io.*;
import java.net.*;

public class java_07785_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 12345; // listen on port 12345
        try {
            ServerSocket server = new ServerSocket(port); // create server socket
            System.out.println("Server started on port " + port);

            while (true) { // infinite loop for server to keep running
                Socket socket = server.accept(); // accept a connection from a client
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                // write to the client
                OutputStream out = socket.getOutputStream();
                DataOutputStream dataOut = new DataOutputStream(out);
                dataOut.writeUTF("Thank you for connecting to " + socket.getLocalSocketAddress());

                // close the connection
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}