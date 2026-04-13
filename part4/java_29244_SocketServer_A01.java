import java.io.*;
import java.net.*;

public class java_29244_SocketServer_A01 {

    private static int PORT = 5000;
    private static ServerSocket server;

    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");
                handleClient(socket);
            }
        } catch (IOException e) {
            System.out.println("Error " + e);
            stopServer();
        }
    }

    public static void handleClient(Socket socket) {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received: " + clientMessage);
                if (isPublicAddress(socket.getInetAddress().getHostAddress())) {
                    System.out.println("Sending response to client");
                    output.writeBytes("Received your message: " + clientMessage + "\n");
                } else {
                    System.out.println("Ignoring message from client");
                }
            }
            socket.close();
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }

    public static void stopServer() {
        try {
            server.close();
            System.out.println("Server stopped");
        } catch (IOException e) {
            System.out.println("Error " + e);
        }
    }

    public static boolean isPublicAddress(String ipAddress) {
        String[] publicIPs = {"127.0.0.1", "localhost"};
        for (String ip : publicIPs) {
            if (ipAddress.equals(ip)) {
                return true;
            }
        }
        return false;
    }
}