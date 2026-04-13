import java.io.*;
import java.net.*;

public class java_08694_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Creating new streams for both input and output
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            // Reading request from client
            String request = inputStream.readUTF();
            System.out.println("Received request: " + request);

            // Sending response back to client
            String response = "HTTP/1.1 200 OK\n" +
                    "Content-Type: text/plain; charset=UTF-8\n" +
                    "Content-Length: " + response.length() + "\n\n" +
                    response;

            outputStream.writeUTF(response);
            outputStream.flush();
            System.out.println("Sent response");

            // Closing the streams
            inputStream.close();
            outputStream.close();
            socket.close();
        }
    }
}