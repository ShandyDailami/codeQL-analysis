import java.net.*;
import java.io.*;

public class java_16689_SocketServer_A01 {
    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(54321);
            System.out.println("Server Started.");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Check if socket is from localhost
                InetAddress address = socket.getInetAddress();
                if (address.getHostAddress().equals("127.0.0.1")) {
                    System.out.println("Connection from localhost accepted.");

                    // Create streams
                    OutputStream out = socket.getOutputStream();
                    DataOutputStream dataOut = new DataOutputStream(out);

                    // Send response
                    dataOut.writeUTF("Connection accepted.");
                } else {
                    System.out.println("Connection from " + address.getHostAddress() + " rejected.");

                    // Close socket
                    socket.close();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}