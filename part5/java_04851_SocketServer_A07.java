import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04851_SocketServer_A07 {
    private static final String PASSWORD = "1234"; // This should be encrypted and stored securely

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started.");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            AuthHandler handler = new AuthHandler(socket);
            handler.startHandling();
        }
    }
}

class AuthHandler extends Thread {
    private Socket socket;
    private String clientName;

    public java_04851_SocketServer_A07(Socket socket) {
        this.socket = socket;
        this.clientName = socket.getInetAddress().toString();
    }

    public void run() {
        try {
            socket.getInputStream(); // Read password from client
            socket.getOutputStream().write(clientName.getBytes());

            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);

            String password = new String(buffer);
            if (password.equals(PASSWORD)) {
                System.out.println("Authentication successful.");
            } else {
                System.out.println("Authentication failed.");
                socket.close();
                return;
            }

            // Authentication successful, start communication with client
            CommunicationHandler communicationHandler = new CommunicationHandler(socket, clientName);
            communicationHandler.start();

        } catch (IOException e) {
            System.out.println("Error occurred while handling client " + clientName);
            e.printStackTrace();
        }
    }
}

class CommunicationHandler extends Thread {
    private Socket socket;
    private String clientName;

    public java_04851_SocketServer_A07(Socket socket, String clientName) {
        this.socket = socket;
        this.clientName = clientName;
    }

    public void run() {
        try {
            while (true) {
                byte[] buffer = new byte[1024];
                socket.getInputStream().read(buffer);
                String message = new String(buffer);
                System.out.println("Received: " + message + " from " + clientName);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while communicating with " + clientName);
            e.printStackTrace();
        }
    }
}