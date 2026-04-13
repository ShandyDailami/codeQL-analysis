import java.net.*;
import java.io.*;

public class java_04923_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8189);
        System.out.println("Waiting for connection...");

        Socket socket = server.accept();
        System.out.println("Connected!");

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
       
            // Sending a response back to client
            out.println("Thank you for connecting to the server.");
        }

        socket.close();
    }
}