import java.io.*;
import java.net.*;

public class java_27542_SocketServer_A01 {
    private static final int DEFAULT_PORT = 12345;
    private static ServerSocket server;

    private java_27542_SocketServer_A01() {}

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        startServer(port);
    }

    private static void startServer(int port) {
        try {
            server = new ServerSocket(port);
            while (true) {
                handleClient(server.accept());
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            stopServer();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            OutputStream out = new BufferedOutputStream(clientSocket.getOutputStream());
            InputStream in = new BufferedInputStream(clientSocket.getInputStream());

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void stopServer() {
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}