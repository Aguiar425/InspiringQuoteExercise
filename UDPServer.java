import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        final int portNumber= 8080;
        final int bufferSize = 1024;


        DatagramSocket socket = new DatagramSocket(portNumber);


        while(true){
            byte[] buffer = new byte[bufferSize];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet); // BLOCKING METHOD
            if(packet.toString().equals("HIT ME") || packet.toString().equals("hit me"))

            System.out.println("I receive new information");

            int numberOfBytes = packet.getLength();
            System.out.println("numberOfBytes = " + numberOfBytes);

            String readData= new String(packet.getData(), 0, packet.getLength());
            System.out.println("readData = " + readData);
        }

    }
}
