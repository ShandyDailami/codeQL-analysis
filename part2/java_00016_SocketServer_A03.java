import java.io.*;
import java.net.*;

public class java_00016_SocketServer_A03 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started at port 8080...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String message, response;

                // read message from client
                message = in.readLine();
                System.out.println("Received: " + message);

                // respond to client
                response = "Hello, client!";
                out.writeBytes(response + '\n');
                System.out.println("Sent: " + response);

                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}