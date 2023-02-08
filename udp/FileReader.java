package udp;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileReader {

    private static String Line(String route) {
            List<String> l;
            try {
                l = Files.readAllLines(Paths.get(route));
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            Random random = new Random();
            return l.get(random.nextInt(l.size()));
        }

        public static String printRandomQuote(){
            String route = new File("udp/quotes.txt").getAbsolutePath();// whole path of the file has to be written within the double qoutes
            String li= Line(route);
            return li;
        }
    }

