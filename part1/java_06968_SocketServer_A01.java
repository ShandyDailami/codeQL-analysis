import java.io.*;
import java.net.*;

public class java_06968_SocketServer_A01 {

    public static void main(String[] args) {
        Socket socket;
        ServerSocket server;

        try {
            // Step 1: Create a server socket
            server = new ServerSocket(2400);
            System.out.println("Server is listening at port 2400");

            // Step 2: Accept a client connection
            socket = server.accept();
            System.out.println("A client has connected");

            // Step 3: Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Step 4: Handle client communication
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                // Simulate a security breach by not allowing access to a specific method
                // This is a placeholder and won't actually break anything
                if ("access method".equals(inputLine)) {
                    out.println("Denied access to specific method");
                } else {
                    out.println("Server: " + inputLine);
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}