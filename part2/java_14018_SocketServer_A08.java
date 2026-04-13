import java.io.*;
import java.net.*;

public class java_14018_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);

        while (true) {
            Socket socket = serverSocket.accept();

            // Send response to client
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Server: Thank you for connecting to my Socket Server!");

            // Close connection
            socket.close();
        }
    }
}