import java.net.*;
import java.io.*;

public class java_24378_SocketServer_A07 {
    public static void main(String[] args) {
        int port = 12345;
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                socket = server.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

                // Use a separate thread for each client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try { socket.close(); } catch (IOException e) { /* can't do anything */ }
            }
            if (server != null) {
                try { server.close(); } catch (IOException e) { /* can't do anything */ }
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_24378_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String clientMessage;

            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received: " + clientMessage);

                // Simulate authentication failure
                if (clientMessage.equals("fail")) {
                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
                    writer.println("auth failure");
                    break;
                } else {
                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
                    writer.println("Server: " + clientMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try { socket.close(); } catch (IOException e) { /* can't do anything */ }
            }
        }
    }
}