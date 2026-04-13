import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

public class java_14032_SocketServer_A07 {

    private static final String USERNAME = "user";
    private static final String PASSWORD = "pass";

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(4444);

        while (true) {
            Socket socket = serverSocket.accept();

            String clientRequest = "";
            byte[] bytes = new byte[1000];

            if (socket.getInputStream().read(bytes) != -1) {
                clientRequest = new String(bytes);
            }

            if (authenticateClient(clientRequest)) {
                socket.getOutputStream().write(processRequest(clientRequest).getBytes());
            } else {
                socket.getOutputStream().write("Authentication failed. Server closing connection.".getBytes());
            }

            socket.close();
        }
    }

    private static String processRequest(String request) {
        // This is a dummy request handler. Replace with your own logic.
        return "Server processed request: " + request;
    }

    private static boolean authenticateClient(String clientRequest) {
        String[] authParts = new String(Base64.getDecoder().decode(clientRequest.split(" ")[1])).split(":");

        return authParts[0].equals(USERNAME) && authParts[1].equals(PASSWORD);
    }
}