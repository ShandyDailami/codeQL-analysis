import java.io.*;
import java.net.*;
import javax.security.auth.callback.*;

public class java_12113_SocketServer_A07 {

    public static void main(String[] args) throws IOException, UnsupportedCallbackException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Simulate authentication failure
                if (message.equals("fail")) {
                    out.println("Authentication failure");
                    out.close();
                } else {
                    out.println("Server received: " + message);
                }
            }

            socket.close();
        }
    }
}