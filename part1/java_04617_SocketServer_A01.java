import java.net.*;
import java.io.*;

public class java_04617_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                socket = server.accept();
                System.out.println("Accepted a new client from " + socket.getRemoteSocketAddress());

                // Creating a new thread to handle each client
                new Handler(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
                if (socket != null) socket.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

class Handler extends Thread {
    private Socket socket;
    public java_04617_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();

            int bytesRead;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            in.close();
            out.close();
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}