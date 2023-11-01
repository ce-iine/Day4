import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CountWithLoops {
    public static void main(String[] args) throws Exception {

        // Open the file
        File fileToRead = new File("road_not_taken.txt");
        FileReader fr = new FileReader(fileToRead);
        BufferedReader br = new BufferedReader(fr);

        String line;
        int count = 0;
        while ((line = br.readLine()) != null) {
            // System.out.printf("> line: %s\n", line);

            // clean the line
            line = line.trim().replaceAll("[^\\sa-zA-A0-9]", ""); // dont want anywhite space, replace all with blank
            // check if line is empty
            if (line.length() < 0) {
                continue;
            }

            // split line into words by " ", stores each line as a list in an array called
            // words
            String[] words = line.split(" ");

            // count number of words and add to total
            count += words.length;
        }

        br.close();
        System.out.printf("total number of words is %d", count);

    }
}
