import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

public class java_04199_SocketServer_A07 {

    private static final String SERVER_USERNAME = "admin";
    private static final String SERVER_PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Waiting for client...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Read the request from the client
            String request = readRequest(clientSocket);

            // Check the credentials
            if (!checkCredentials(request)) {
                System.out.println("Invalid credentials, closing connection");
                clientSocket.close();
                continue;
            }

            // Send a response
            sendResponse(clientSocket);
        }
    }

    private static String readRequest(Socket socket) throws Exception {
        byte[] bytes = new byte[1024];
        socket.getInputStream().read(bytes);
        return new String(Base64.getDecoder().decode(bytes));
    }

    private static boolean checkCredentials(String request) {
        String[] credentials = request.split(" ");

        if (credentials.length != 2) {
            return false;
        }

        String username = credentials[0];
        String password = credentials[1];

        if (!username.equals(SERVER_USERNAME) || !password.equals(SERVER_PASSWORD)) {
            return false;
        }

        return true;
    }

    private static void sendResponse(Socket socket) throws Exception {
        String response = "Authentication successful";
        byte[] bytes = Base64.getEncoder().encode(response.getBytes());
        socket.getOutputStream().write(bytes);
        socket.getOutputStream().flush();
        System.out.println("Sent response: " + response);
    }
}