import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22141_SocketServer_A07 {
    private int port;
    private ServerSocket serverSocket;

    public java_22141_SocketServer_A07(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        System.out.println("Server is listening on port " + port);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Here we are assuming authentication is a simple username/password check
                // In a real-world application, authentication would likely involve more complex
                // mechanisms and also use of a secure channel (like SSL/TLS)
                String username = socket.getInputStream().readUTF();
                String password = socket.getInputStream().readUTF();
                if (authenticate(username, password)) {
                    socket.getOutputStream().writeUTF("Authenticated");
                } else {
                    socket.getOutputStream().writeUTF("FailedAuthentication");
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean authenticate(String username, String password) {
        // Here you would typically use a database to check the username and password
        // This is a very simplistic example, in a real application you would want to use
        // a secure method of authentication (like a hash of the password, not the plain text password)
        // and possibly also a secure channel (like SSL/TLS)
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(8080);
        server.start();
    }
}