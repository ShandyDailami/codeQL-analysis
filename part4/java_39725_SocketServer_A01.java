import java.io.*;
import java.net.*;

public class java_39725_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        // create server socket
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started");

        while (true) {
            // wait for client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // handle client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String request = reader.readLine();
            System.out.println("Received request: " + request);

            // send response
            writer.write("HTTP/1.1 200 OK\r\n".getBytes());
            writer.write("Content-Type: text/html; charset=utf-8\r\n".getBytes());
            writer.write("\r\n".getBytes());
            writer.write("<html><body>Hello, World!</body></html>\r\n".getBytes());
            writer.flush();

            // close connection
            socket.close();
        }
    }
}