import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22838_SocketServer_A03 {

    private final int port;

    public java_22838_SocketServer_A03(int port) {
        this.port = port;
    }

    public void start() {
        System.out.println("Server is starting on port " + port + "...");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

                    // Create new thread for handling each client
                    new Handler(clientSocket).start();
                }
            }
        } catch (Exception e) {
            System.out.println("Server failed to start");
            e.printStackTrace();
        }

        System.out.println("Server stopped.");
    }

    private class Handler extends Thread {
        private final Socket socket;
        private final BufferedReader in;
        private final PrintWriter out;

        public java_22838_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.out = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e) {
                close();
            }
        }

        @Override
        public void run() {
            String request;
            try {
                if ((request = in.readLine()) != null) {
                    processRequest(request);
                }
            } catch (Exception e) {
                close();
            }
        }

        private void processRequest(String request) {
            // Simplistic check for injection - if the request contains "badword" it's considered an attack
            if (request.toLowerCase().contains("badword")) {
                out.println("You are not allowed to send this message");
            } else {
                out.println("You said: " + request);
            }
        }

        private void close() {
            try {
                socket.close();
            } catch (Exception e) {
                // Ignore errors
            }
        }
    }
}