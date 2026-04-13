import java.io.*;
import java.net.*;

public class java_07732_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Read message from client
            String message = in.readLine();
            System.out.println("Received message: " + message);

            // Send response
            String response = "Hello, client!";
            out.writeBytes(response + "\n");
       
            socket.close();
        }
    }
}