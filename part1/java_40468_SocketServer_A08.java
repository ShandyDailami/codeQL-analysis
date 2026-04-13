import java.net.*;
import java.io.*;

public class java_40468_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for a client to connect...");

        Socket socket = server.accept();
        System.out.println("A client has connected!");

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            out.println("Server: Hello, you have connected!");
        }

        socket.close();
    }
}