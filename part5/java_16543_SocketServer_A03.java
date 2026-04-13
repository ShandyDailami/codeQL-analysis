import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class java_16543_SocketServer_A03 {

    private final Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        new SocketServer().startServer(1234);
    }

    private void startServer(int port) {
        System.out.println("Server started on port " + port);

        Thread serverThread = new Thread(() -> {
            while (true) {
                try {
                    Socket client = Server.accept(port);
                    System.out.println("Client connected from " + client.getRemoteSocketAddress());

                    new ClientHandler(client).start();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        serverThread.setDaemon(true);
        serverThread.start();
    }

    private class ClientHandler extends Thread {
        private final Socket client;
        private final BufferedReader in;
        private final PrintWriter out;

        public java_16543_SocketServer_A03(Socket client) {
            this.client = client;
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
        }

        @Override
        public void run() {
            try {
                String request;
                while ((request = in.readLine()) != null) {
                    if (request.equals("logout")) {
                        users.remove(client.getRemoteSocketAddress().toString());
                        out.println("Logout successful");
                        out.flush();
                        break;
                    } else {
                        String response;
                        if (users.containsKey(request)) {
                            response = "User " + request + " is already logged in.";
                        } else {
                            response = "User " + request + " is logged in.";
                            users.put(client.getRemoteSocketAddress().toString(), request);
                        }
                        out.println(response);
                        out.flush();
                    }
                }
                client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}