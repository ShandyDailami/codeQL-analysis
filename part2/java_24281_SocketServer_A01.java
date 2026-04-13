import java.io.*;
import java.net.*;

public class java_24281_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Server is running on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("A new client has connected");

            // handle client communication here
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);

                // Example: echo back message
                writer.println("Echo: " + message);
           
                // Flush after each write operation
                writer.flush();
            }

            socket.close();
        }
    }
}