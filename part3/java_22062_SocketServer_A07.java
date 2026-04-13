import java.io.*;
import java.net.*;
import java.util.*;

public class java_22062_SocketServer_A07 {
    private List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {
        new SocketServer().start();
    }

    public void start() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(1234);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                clients.add(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class ClientHandler extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_22062_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
                start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            String request;
            try {
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);
                    // Here, we're assuming the client is sending us a 'auth' request
                    if (request.equals("auth")) {
                        // Send back an 'auth' response. This is a basic example, actual authentication might be more complex.
                        writer.println("auth success");
                        writer.flush();
                    } else {
                        writer.println("unknown request");
                        writer.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}