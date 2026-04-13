import java.io.*;
import java.net.*;
import java.util.*;

public class java_13523_SocketServer_A07 {
    private static final int PORT = 8080;
    private static Set<Socket> clients = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (true) {
            try {
                Socket socket = server.accept();
                clients.add(socket);

                HandleClient handleClient = new HandleClient(socket);
                handleClient.start();
            } catch (IOException e) {
                System.err.println(e);
                break;
            }
        }

        server.close();
    }

    private static class HandleClient extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_13523_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.err.println(e);
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Perform authentication here.
                    if (!authenticate(message)) {
                        out.println("Authentication failed");
                        out.flush();
                        break;
                    }
                    out.println("Authentication successful");
                    out.flush();
                }
            } catch (IOException e) {
                System.err.println(e);
            } finally {
                clients.remove(socket);
                socket.close();
            }
        }

        private boolean authenticate(String message) {
            // Implement authentication logic here.
            // Return true if successful, false otherwise.
            return true;
        }
    }
}