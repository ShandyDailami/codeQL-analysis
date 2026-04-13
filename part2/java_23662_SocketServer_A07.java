import java.io.*;
import java.net.*;
import java.util.Base64;

public class java_23662_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server started. Waiting for client connection...");

        Socket socket = serverSocket.accept();

        System.out.println("Client connected!");

        // Write the request to the client
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        outputStream.writeUTF("HTTP/1.1 200 OK\r\n");
        outputStream.writeUTF("Content-Type: text/html\r\n");
        outputStream.writeUTF("Connection: close\r\n");
        outputStream.writeUTF("\r\n");

        // Read the response from the client
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        String response = inputStream.readUTF();

        // Decode the base64 response
        byte[] decodedBytes = Base64.getDecoder().decode(response);
        String decodedResponse = new String(decodedBytes);

        System.out.println("Received response: " + decodedResponse);

        socket.close();
        serverSocket.close();
    }
}