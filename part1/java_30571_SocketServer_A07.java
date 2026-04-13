import java.io.*;
import java.net.*;
import java.util.*;

public class java_30571_SocketServer_A07 {

    public static void main(String[] args) {
        Socket socket = null;
        ServerSocket server = null;

        try {
            server = new ServerSocket(5000); // Listen on port 5000
            System.out.println("Server is listening...");

            while (true) {
                socket = server.accept();
                System.out.println("Client connected...");

                // Create new thread for each client
                new HandleClientThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class HandleClientThread extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        HandleClientThread(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String request;
            try {
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);

                    // Here you can implement security-sensitive operations related to A07_AuthFailure
                    // For example, check the request for authentication failure and respond accordingly

                    out.println("Response: Hello, client!"); // Just a placeholder response
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}