import java.net.*;
import java.io.*;

public class java_23885_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Waiting for client connection...");

        Socket socket = serverSocket.accept();
        System.out.println("Connection established!");

        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Received: " + inputLine);
            out.println("Hello client, you connected!");
        }

        socket.close();
    }
}