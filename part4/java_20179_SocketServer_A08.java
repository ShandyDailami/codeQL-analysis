import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20179_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Create a new server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            // Wait for a client to connect
            Socket clientSocket = serverSocket.accept();

            // Create a new input stream for the client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // Read the request from the client
            String request = in.readLine();
            System.out.println("Received: " + request);

            // Write a response to the client
            OutputStream out = clientSocket.getOutputStream();
            out.write("HTTP/1.1 200 OK\r\n".getBytes());
            out.write("Content-Type: text/plain; charset=utf-8\r\n".getBytes());
            out.write("\r\n".getBytes());
            out.write("Hello, Client!".getBytes());

            // Close the connection
            out.close();
            clientSocket.close();
        }
    }
}