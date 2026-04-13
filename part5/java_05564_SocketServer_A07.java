import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class java_05564_SocketServer_A07 {
    private static Map<String, String> users = new HashMap<String, String>();
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(8189);
            System.out.println("Server started.");

            while (true) {
                Socket socket = server.accept();

                // create a new thread to handle the client request
                new ClientHandler(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("IOException in server.");
        } finally {
            try {
                if (server != null) server.close();
            } catch (IOException ex) {
                System.out.println("IOException in server closing.");
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_05564_SocketServer_A07(Socket s) {
            socket = s;
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        }

        public void run() {
            try {
                String message, response;
                while ((message = in.readLine()) != null) {
                    System.out.println("Client says: " + message);
                    if (message.equals(USERNAME) && authenticate(USERNAME, PASSWORD)) {
                        response = "Authentication successful.";
                    } else {
                        response = "Authentication failed.";
                    }
                    out.println(response);
                }
            } catch (IOException ex) {
                System.out.println("Error in client communication.");
            } finally {
                try {
                    socket.close();
                } catch (IOException ex) {
                    System.out.println("Error closing socket.");
                }
            }
        }

        private boolean authenticate(String username, String password) {
            // here you can implement your authentication logic
            // for now let's just check the provided username and password
            // and return true or false accordingly
            return username.equals(USERNAME) && password.equals(PASSWORD);
        }
    }
}