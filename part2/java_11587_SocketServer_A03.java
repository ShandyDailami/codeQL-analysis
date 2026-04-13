import java.io.*;
import java.net.*;

public class java_11587_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Server is listening on port 8189");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Split the message into components
                String[] components = message.split(" ");

                // Check if the message is a valid command
                if (components[0].equals("QUIT")) {
                    out.println("Thank you for connecting");
                    socket.close();
                } else {
                    out.println("Unknown command, please try again");
                }
            }
        }
    }
}