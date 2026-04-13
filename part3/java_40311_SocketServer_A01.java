import java.io.*;
import java.net.*;

public class java_40311_SocketServer_A01 {
    private static final int port = 1234;
    private static ServerSocket server;

    public static void main(String[] args) {
        startServer();
        try {
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected!");
                handleClient(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void startServer() {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readLine();
            System.out.println("Received: " + request);

            out.writeBytes("HTTP/1.1 200 OK\r\n\r\n" + request + "\r\n");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}