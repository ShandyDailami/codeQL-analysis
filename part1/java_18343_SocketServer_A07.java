import java.io.*;
import java.net.*;

public class java_18343_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Server started at port 6000");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Reads the request from the client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();
            System.out.println("Received: " + request);

            // For simplicity, we'll respond with a static message
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello, client!");

            socket.close();
        }
    }
}