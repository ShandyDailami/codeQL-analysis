import java.io.*;
import java.net.*;

public class java_41097_SocketServer_A03 {
    private int port;
    private boolean running;
    private ServerSocket server;

    public java_41097_SocketServer_A03(int port) {
        this.port = port;
        this.running = false;
    }

    public void start() throws IOException {
        if (running) throw new IllegalStateException("Already running");
        server = new ServerSocket(port);
        running = true;
    }

    public void stop() throws IOException {
        if (!running) throw new IllegalStateException("Not running");
        server.close();
        running = false;
    }

    public Socket accept() throws IOException {
        if (!running) throw new IllegalStateException("Not running");
        return server.accept();
    }

    public static void main(String[] args) {
        try {
            SocketServer server = new SocketServer(8080);
            server.start();

            while(true) {
                Socket socket = server.accept();
                new Thread(new SocketHandler(socket)).start();
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_41097_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Hello, client!");
            }

            socket.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}