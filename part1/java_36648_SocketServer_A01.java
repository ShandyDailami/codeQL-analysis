import java.io.*;
import java.net.*;

public class java_36648_SocketServer_A01 {
    private static final int PORT = 8080;
    private static final String BAD_REQUEST = "Bad Request";
    private static final String FORBIDDEN = "Forbidden";

    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create a new thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_36648_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String request = in.readLine();
            System.out.println("Received: " + request);

            // Broken Access Control example: Check if the request is 'bad'
            if (request.equals("BAD_REQUEST")) {
                out.write(BAD_REQUEST.getBytes());
            } else if (request.equals("FORBIDDEN")) {
                out.write(FORBIDDEN.getBytes());
            } else {
                out.write("Good Request".getBytes());
            }

            out.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}