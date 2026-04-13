import java.io.*;
import java.net.*;
import java.security.*;

public class java_13587_SocketServer_A03 {

    private static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        while (true) {
            Socket client = server.accept();
            new SecureSocketServerThread(client).start();
        }
    }

    private static class SecureSocketServerThread extends Thread {
        private final Socket socket;

        public java_13587_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Obtain a KeyPair
                KeyPair keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
                PublicKey publicKey = keyPair.getPublic();

                // Send the public key to the client
                out.writeUTF((new String(Base64.getEncoder().encode(publicKey.getEncoded())) + "\n");

                // Wait for the client's challenge
                String receivedChallenge = in.readUTF();
                byte[] receivedChallengeBytes = Base64.getDecoder().decode(receivedChallenge);

                // Verify the challenge
                if (Arrays.equals(receivedChallengeBytes, publicKey.getEncoded())) {
                    System.out.println("Challenge accepted");

                    // Send the symmetric key
                    byte[] symmetricKey = keyPair.getPrivate().decrypt(receivedChallengeBytes);
                    out.writeUTF(new String(Base64.getEncoder().encode(symmetricKey)));
                } else {
                    System.out.println("Challenge rejected");
                    return;
                }

                // Communication is secure now. Encoding read and write operations as streams of bytes.
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String message;
                while ((message = reader.readLine()) != null) {
                    writer.writeUTF(message);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}