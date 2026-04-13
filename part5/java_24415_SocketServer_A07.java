import java.io.*;
import java.net.*;
import java.util.*;

public class java_24415_SocketServer_A07 {
    private static final String PASSWORD = "password";
    private static boolean authenticated = false;

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(6666);
            while (true) {
                Socket socket = server.accept();
                new ServerThread(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("Server failed: " + ex);
            System.exit(-1);
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException ex) {
                    System.out.println("Server failed to close: " + ex);
                }
            }
        }
    }

    private static class ServerThread extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_24415_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException ex) {
                System.out.println("Error getting input/output streams: " + ex);
            }
        }

        public void run() {
            String message, response;
            try {
                message = in.readLine();
                authenticated = message.equals("password");
                if (authenticated) {
                    out.println("Welcome!");
                } else {
                    out.println("Authentication failed!");
                }
            } catch (IOException ex) {
                System.out.println("Error reading from client: " + ex);
                stopThread();
            }
        }

        private void stopThread() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException ex) {
                System.out.println("Error closing socket: " + ex);
            }
        }
    }
}