import java.io.*;
import java.net.*;

public class java_40394_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8000);

        System.out.println("Waiting for client connection...");
        Socket socket = server.accept();

        System.out.println("Connection established!");

        // create input and output streams
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // read and write operations
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        String inputLine;

        // read the message from the client
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);

            // here's a simple check for a broken access control
            if (inputLine.equals("BROKEN_ACCESS_CONTROL")) {
                out.println("Access denied!");
            } else {
                out.println("Access granted!");
            }
        }

        socket.close();
        server.close();
    }
}