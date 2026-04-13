import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLServlet;

public class java_00468_SocketServer_A07 {

    private final static String PASSWORD = "password"; // replace with your password
    private final static String USERNAME = "username"; // replace with your username

    public static void main(String[] args) {
        runServer(8080);
    }

    public static void runServer(int port) {
        try {
            SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected");

                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();

                String message = "Client connected";
                byte[] bytes = message.getBytes();

                // Send a welcome message to the client
                outputStream.write(bytes);
                outputStream.flush();

                // Check the username and password for authentication
                checkAuthentication(clientSocket, inputStream);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void checkAuthentication(SSLSocket clientSocket, InputStream inputStream) throws IOException {
        byte[] bytes = new byte[256];
        inputStream.read(bytes);

        String username = new String(bytes);
        String password = PASSWORD; // assuming password is hardcoded

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Authentication successful");
            // If authentication is successful, continue with the communication
            // ...
        } else {
            System.out.println("Authentication failed");
            // If authentication fails, close the connection
            clientSocket.close();
            return;
        }
    }
}