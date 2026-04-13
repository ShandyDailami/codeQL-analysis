import java.net.*;
import java.io.*;

public class java_15013_SocketServer_A07 {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        try {
            server = new ServerSocket(1234); // port number
            System.out.println("Server started...");

            while (true) {
                socket = server.accept(); // waiting for client
                System.out.println("Client accepted...");

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message, response;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received client: " + message);
                    // Simple authentication
                    if (message.equals("auth")) {
                        response = "auth_success";
                    } else {
                        response = "auth_failed";
                    }
                    out.println(response);
                }
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}