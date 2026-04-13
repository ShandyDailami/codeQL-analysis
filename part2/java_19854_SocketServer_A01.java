import java.net.*;
import java.io.*;

public class java_19854_SocketServer_A01 {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Create Server Socket
            serverSocket = new ServerSocket(6000);
            System.out.println("Server is listening on port 6000");

            // Step 2: Accept Client Connection
            socket = serverSocket.accept();
            System.out.println("A client has connected!");

            // Step 3: Send a Response
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello Client, You are connected to Server!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Step 4: Close Socket Connection
            try {
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}