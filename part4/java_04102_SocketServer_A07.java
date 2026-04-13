import java.io.*;
import java.net.*;

public class java_04102_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client is connected");

                // Create streams for reading and writing
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read the message from the client
                String message = in.readLine();
                System.out.println("Received message from client: " + message);

                // Check if the message is a command for authentication
                if (message.startsWith("AUTH ")) {
                    String[] parts = message.split(" ");
                    String username = parts[1];
                    String password = parts[2];

                    // Simulate authentication by checking if the username and password match
                    if ("admin".equals(username) && "password".equals(password)) {
                        out.writeBytes("AUTH_SUCCESS\n");
                    } else {
                        out.writeBytes("AUTH_FAILURE\n");
                   
                    }
                } else {
                    // If the message is not a command for authentication, write a response
                    out.writeBytes("UNAUTHORIZED_CLIENT\n");
                }

                out.flush();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}