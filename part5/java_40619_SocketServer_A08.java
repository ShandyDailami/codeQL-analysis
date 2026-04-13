import java.io.*;
import java.net.*;

public class java_40619_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();

            // Get input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read request
            String request = in.readLine();
            System.out.println("Received: " + request);

            // Send response
            out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
            out.flush();

            // Close connection
            socket.close();
        }
    }
}