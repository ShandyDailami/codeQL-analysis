import java.io.*;
import java.net.*;

public class java_41152_SocketServer_A03 {
    private static final int PORT = 8080;
    private static boolean running = true;

    public static void main(String[] args) {
        ServerSocket server = null;
        while (running) {
            try {
                server = new ServerSocket(PORT);
                System.out.println("Server is listening on port " + PORT);
                while (true) {
                    Socket socket = server.accept();
                    System.out.println("Connected to: " + socket.getRemoteSocketAddress());
                    new EchoHandler(socket).start();
                }
            } catch (IOException e) {
                System.err.println("Failed to establish server socket");
                System.exit(-1);
            } finally {
                if (server != null) {
                    try {
                        server.close();
                    } catch (IOException e) {
                        System.err.println("Failed to close server socket");
                        System.exit(-1);
                    }
                }
            }
        }
        System.exit(0);
    }
}

class EchoHandler extends Thread {
    private Socket socket;
    BufferedReader in;
    PrintWriter out;

    public java_41152_SocketServer_A03(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            System.err.println("Failed to create I/O streams");
            System.exit(-1);
        }
    }

    public void run() {
        try {
            String msg;
            while ((msg = in.readLine()) != null) {
                System.out.println("Received: " + msg);
                out.println(msg);
                if (msg.equals("exit")) {
                    break;
                }
            }
            socket.close();
        } catch (IOException e) {
            System.err.println("Failed to handle client");
        }
    }
}