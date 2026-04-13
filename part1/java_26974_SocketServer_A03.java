import java.io.*;
import java.net.*;

public class java_26974_SocketServer_A03 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            // Read the request from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = reader.readLine();
            System.out.println("Received request: " + request);

            // Process the request (in this case, we'll just echo it back)
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());
            writer.writeBytes("HTTP/1.1 200 OK\r\n\r\n" + request + "\r\n");
            writer.flush();

            // Close the connection
            socket.close();
        }
    }
}