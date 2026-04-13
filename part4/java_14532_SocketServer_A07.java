import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14532_SocketServer_A07 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(12345)) {
            while (true) {
                Socket socket = server.accept();
                new AuthThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class AuthThread extends Thread {
        private Socket socket;

        public java_14532_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (Socket client = socket) {
                String clientUsername = client.getInputStream().readUTF();
                String clientPassword = client.getInputStream().readUTF();

                if (clientUsername.equals(USERNAME) && clientPassword.equals(PASSWORD)) {
                    client.getOutputStream().writeUTF("OK");
                } else {
                    client.getOutputStream().writeUTF("FAILURE");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}