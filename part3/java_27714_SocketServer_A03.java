import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_27714_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        ExecutorService executor = Executors.newCachedThreadPool();

        while (true) {
            Socket client = server.accept();
            System.out.println("Connected to " + client.getRemoteSocketAddress());
            executor.execute(new SocketHandler(client));
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_27714_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            output.close();
            input.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}