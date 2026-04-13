import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_20597_SocketServer_A07 {

    private static class AuthenticationHandler {
        public boolean authenticate(String user, String password) {
            // Here you would typically connect to a database and check the user and password.
            // For this example, we just check if the user and password match.
            return user.equals("admin") && password.equals("password");
        }
    }

    public static void main(String[] args) throws IOException {
        final AuthenticationHandler authenticationHandler = new AuthenticationHandler();

        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(8888);
            serverSocket.setNeedClient(true);

            while (true) {
                SSLSocket socket = (SSLSocket) serverSocket.accept();
                socket.setNeedClient(true);

                new Handler(socket, authenticationHandler).start();
            }
        } finally {
            serverSocket.close();
        }
    }

    private static class Handler extends Thread {
        private final Socket socket;
        private final AuthenticationHandler authenticationHandler;

        public java_20597_SocketServer_A07(Socket socket, AuthenticationHandler authenticationHandler) {
            this.socket = socket;
            this.authenticationHandler = authenticationHandler;
        }

        @Override
        public void run() {
            try {
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Here we're assuming the client will send us a username and password.
                // You should replace this with actual authentication.
                String user = socket.getInputStream().readUTF();
                String password = socket.getInputStream().readUTF();

                if (authenticationHandler.authenticate(user, password)) {
                    out.println("You are authenticated.");
                } else {
                    out.println("Authentication failed.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}