import java.io.*;
import java.net.*;

public class java_00044_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            // Create new streams for the socket connection
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read the client's request
            String request = in.readLine();
            System.out.println("Received: " + request);

            // Process the request (security sensitive operation)
            // In this case, we just echo the request back
            String response = request;

            // Send the response back to the client
            out.writeBytes("HTTP/1.1 200 OK\r\n\r\n" + response + "\r\n");
            out.flush();

            // Close the connection
            socket.close();
        }
    }
}