import java.io.*;
import java.net.*;

public class java_40329_SocketServer_A01 {
    private static String[] allowedClients = {"192.168.1.101", "192.168.1.102"}; // Replace with actual IPs

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientIP = socket.getRemoteSocketAddress().toString().substring(socket.getRemoteSocketAddress().toString().lastIndexOf("/") + 1);

            if (isAllowed(clientIP)) {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received from client: " + message);
                    out.writeUTF("Message received from " + socket.getRemoteSocketAddress());
                }
            } else {
                out.writeUTF("Access denied for client " + socket.getRemoteSocketAddress());
            }

            socket.close();
        }
    }

    private static boolean isAllowed(String ip) {
        for (String allowedIp : allowedClients) {
            if (allowedIp.equals(ip)) {
                return true;
            }
        }
        return false;
    }
}