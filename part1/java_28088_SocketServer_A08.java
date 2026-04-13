import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class java_28088_SocketServer_A08 {

    private List<InputStream> clientInputStreams = new ArrayList<>();
    private List<OutputStream> clientOutputStreams = new ArrayList<>();

    public void startServer(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                InetAddress ip = clientSocket.getInetAddress();
                System.out.println("Client " + ip.getHostAddress() + " connected");

                InputStream clientInputStream = clientSocket.getInputStream();
                OutputStream clientOutputStream = clientSocket.getOutputStream();

                clientInputStreams.add(clientInputStream);
                clientOutputStreams.add(clientOutputStream);

                Thread handler = new Thread(new SocketHandler(clientInputStream, clientOutputStream));
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class SocketHandler implements Runnable {
        private InputStream clientInputStream;
        private OutputStream clientOutputStream;

        public java_28088_SocketServer_A08(InputStream clientInputStream, OutputStream clientOutputStream) {
            this.clientInputStream = clientInputStream;
            this.clientOutputStream = clientOutputStream;
        }

        @Override
        public void run() {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = clientInputStream.read(buffer)) != -1) {
                // Here you can add the code to check the integrity of the received data.
                // For this example, we'll just echo the data back.
                clientOutputStream.write(buffer, 0, bytesRead);
            }
            closeConnection();
        }

        private void closeConnection() {
            try {
                clientInputStream.close();
                clientOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}