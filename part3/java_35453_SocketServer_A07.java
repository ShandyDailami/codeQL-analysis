import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_35453_SocketServer_A07 {

    private Map<String, String> userDB = new HashMap<>();
    private boolean authenticated = false;

    public java_35453_SocketServer_A07() {
        userDB.put("admin", "password");
    }

    public void startServer(int port) {
        System.out.println("Server starting...");
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = server.accept()) {
                    handleClient(clientSocket);
                }
            }
        } catch (IOException ex) {
            System.out.println("IOException was caught: " + ex.getMessage());
        }
    }

    private void handleClient(Socket clientSocket) {
        System.out.println("New client connected");
        new Handler(clientSocket, this).start();
    }

    public static void main(String[] args) {
        new SocketServer().startServer(8080);
    }

    class Handler extends Thread {
        private Socket clientSocket;
        private SocketServer server;

        public java_35453_SocketServer_A07(Socket socket, SocketServer server) {
            this.clientSocket = socket;
            this.server = server;
        }

        @Override
        public void run() {
            try (InputStreamReader in = new InputStreamReader(clientSocket.getInputStream());
                 BufferedReader reader = new BufferedReader(in)) {

                String message;
                while ((message = reader.readLine()) != null) {
                    processRequest(message);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void processRequest(String request) {
            String response;
            String username = request.split(" ")[1];
            String password = request.split(" ")[2];

            if (server.userDB.containsKey(username) && server.userDB.get(username).equals(password)) {
                response = "AuthSuccess";
                server.authenticated = true;
            } else {
                response = "AuthFailure";
                server.authenticated = false;
            }

            try (OutputStream out = clientSocket.getOutputStream()) {
                out.write((response + "\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}