import java.io.*;
import java.net.*;

public class java_20174_SocketServer_A03 {
    private static final int PORT = 4445;
    private static final String TRUSTED_HOSTS = "127.0.0.1"; // or trusted IPs

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Check if the client is trusted
            if (isTrusted(socket.getInetAddress().getHostAddress())) {
                String message = in.readUTF();
                out.writeUTF("Message from client: " + message);
                out.flush();
            } else {
                out.writeUTF("Sorry, but you're not trusted");
                out.flush();
            }

            socket.close();
        }
    }

    private static boolean isTrusted(String ip) throws IOException {
        // Check if the client ip is in trusted hosts list
        String[] trustedHosts = TRUSTED_HOSTS.split(",");
        for (String trustedHost : trustedHosts) {
            if (ip.equals(trustedHost)) {
                return true;
            }
        }
        return false;
    }
}