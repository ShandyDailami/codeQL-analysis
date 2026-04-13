import java.io.*;
import java.net.*;

public class java_21272_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Perform some security-sensitive operation here
                // For simplicity, we just check if the message is empty and respond accordingly
                if (message.isEmpty()) {
                    out.println("Server: Message is empty");
                } else {
                    out.println("Server: Message is not empty");
                }
            }

            socket.close();
        }
    }
}