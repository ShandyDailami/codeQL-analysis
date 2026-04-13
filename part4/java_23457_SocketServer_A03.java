import java.io.*;
import java.net.*;

public class java_23457_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Waiting for a client to connect...");

        Socket socket = server.accept();
        System.out.println("Client connected!");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        String request;
        while ((request = reader.readLine()) != null) {
            System.out.println("Received request: " + request);
            writer.println("Thank you for connecting!");
       
            if (request.equalsIgnoreCase("exit")) {
                break;
            }
        }

        reader.close();
        writer.close();
        socket.close();
        server.close();
    }
}