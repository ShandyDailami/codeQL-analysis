import java.io.*;
import java.net.*;

public class java_14387_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started on port 8000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Create streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Handle the request
            String request;
            while ((request = in.readLine()) != null) {
                System.out.println("Received request: " + request);

                // This is a simple example of authentication failure. In a real application, 
                // you would likely want to use a secure way to authenticate the client.
                // For the sake of simplicity, we just check if the request is "auth"
                if (request.equals("auth")) {
                    out.println("auth_success");
                } else {
                    out.println("auth_failure");
                }
            }

            socket.close();
        }
    }
}