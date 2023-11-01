package src.CountWithStreams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class CountWithStreams {
    public static void main(String[] args) throws Exception {

        try {
            File fileToRead = new File("road_not_taken.txt");
            FileReader fr = new FileReader(fileToRead);
            BufferedReader br = new BufferedReader(fr);

            // what is optional - 0 cannot tell the difference between if a file is really empty of it really has blank spaces 
            Optional<Integer> opt = br.lines()
                //clean table
                .map(line -> line.trim().replaceAll("[^\\sa-zA-Z0-9]", "")) // return string
                //remove empty lines 
                .filter(line -> line.length() > 0) // filter to only continue with lines that are not empty
                // line -> words
                .map(line -> line.split(" "))
                // words -> count 
                .map(words -> words.length) // split and get integer
                .reduce((acc, x) -> acc + x);

            int count =0;

            if (opt.isPresent()){
                count = opt.get();
                System.out.printf("Number of words in %s is %d\n", fileToRead, count);
            } else {
                System.out.println("no result");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
