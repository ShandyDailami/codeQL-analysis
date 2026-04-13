import java.io.*;
import java.net.*;
import java.util.*;

public class java_24341_SocketServer_A07 {
    private static final String AUTHENTICATION_SUCCESS = "Authentication Successful!";
    private static final String AUTHENTICATION_FAILURE = "Authentication Failed!";

    private List<ClientHandler> clientHandlers = new ArrayList<>();
    private boolean authenticated = false;

    private class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_24341_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.equals("authenticate")) {
                        out.println(authenticate());
                    } else {
                        out.println(AUTHENTICATION_FAILURE);
                    }
                }
            } catch (IOException e) {
                close();
            }
        }

        private void close() {
            try {
                socket.close();
            } catch (IOException e) {
                // Ignore
            }
        }
    }

    public void start(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(socket);
            clientHandler.start();
            clientHandlers.add(clientHandler);
        }
    }

    private String authenticate() {
        // Add authentication logic here
        // For now, we'll just return a hardcoded authentication status
        return authenticated ? AUTHENTICATION_SUCCESS : AUTHENTICATION_FAILURE;
    }
}