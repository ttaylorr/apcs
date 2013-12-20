import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WhatIs {

    public static void main(String[] args) {
        List<String> tokens = new ArrayList<String>();
        int totalSum = 0;

        File file;
        BufferedReader reader = null;

        file = new File("./WhatIs.dat");

        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("The requested file does not exist, please create it and try again..!");
            System.exit(-1);
        }

        while (true) {
            try {
                if (!reader.ready())
                    break;

                String[] line = reader.readLine().split(",");

                for(String s : line) {
                    try {
                        totalSum += Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                         tokens.add(s);
                    }
                }
            } catch (IOException e) {
                System.err.println("There was an error parsing the file, aborting..!");
                System.exit(-1);
            }
        }

        for(String s : tokens) {
            System.out.println(s);
        }

        System.out.println(totalSum);
    }

}
