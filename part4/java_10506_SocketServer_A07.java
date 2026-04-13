import java.io.*;
import java.net.*;
import java.util.*;

public class java_10506_SocketServer_A07 {
    private static final int PORT = 5000;
    private static final String AUTH_FILE = "auth.txt";

    private Map<String, String> users = new HashMap<>();

    public java_10506_SocketServer_A07() {
        loadUsers();
    }

    public void startServer() {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected!");

                Thread thread = new Thread(new SocketHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadUsers() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(AUTH_FILE));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                users.put(parts[0], parts[1]);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class SocketHandler implements Runnable {
        private Socket socket;

        public java_10506_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String clientName = in.readLine();
                if (authenticate(clientName)) {
                    out.writeBytes("OK\n");
                } else {
                    out.writeBytes("FAIL\n");
                    socket.close();
                    return;
                }

                String message = in.readLine();
                System.out.println("Received: " + message);

                out.writeBytes("OK\n");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticate(String clientName) {
            return users.containsKey(clientName) && users.get(clientName).equals("password");
        }
    }

    public static void main(String[] args) {
        new SocketServer().startServer();
    }
}