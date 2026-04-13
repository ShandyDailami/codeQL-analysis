import java.io.*;
import java.net.*;

public class java_24883_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket socket = server.accept();

            // Creating input and output streams
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;

            // Reading input from the client
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                out.println("Server received your message. Thank you!");
            }

            // Closing streams and socket
            out.close();
            in.close();
            socket.close();
       
        }
    }
}