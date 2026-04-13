import java.io.*;
import java.net.*;

public class java_23511_SocketServer_A01 {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(5000);
            System.out.println("Server is listening on port 5000");

            while (true) {
                socket = server.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected.");

                // Create a new Thread for each client
                Thread t = new Thread(new ClientHandler(socket));
                t.start();
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
}

class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_23511_SocketServer_A01(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String request;
        try {
            while ((request = in.readLine()) != null) {
                // Check if the request is a command to disconnect
                if (request.equals("DISCONNECT")) {
                    out.println("Disconnected.");
                    break;
                }

                // Perform security-sensitive operations
                System.out.println("Server received: " + request);
                out.println("Server received.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}