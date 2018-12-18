package weekone;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

class AdventOfCodeDay1 {

    public static void main(String[] args) {
        //experiment0101();
        //experiment0102();
        solution();

    }


    /**
     * Experiment one: failed
     * <p>
     * Part One:
     * Starting with a frequency of zero, what is the resulting frequency
     * after all of the changes in frequency have been applied?
     */
    static void experiment0101() {

        File file = new File("src/main/java/weekone/input01.txt");
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        int sum = 0;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            while ((bufferedReader.read() != -1)) {
                String line = bufferedReader.readLine();
                System.out.println("\nThe string is: " + line);
                int number = Integer.valueOf(line);

                System.out.println("The number is: " + number);

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("The sum is: " + sum);
    }

    /**
     * Experiment two: failed
     * <p>
     * Part One:
     * Starting with a frequency of zero, what is the resulting frequency
     * after all of the changes in frequency have been applied?
     */
    static void experiment0102() {

        File file = new File("src/main/java/weekone/input01.txt");
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);

            System.out.println("Total file size to read (in bytes) : "
                    + fis.available());

            int content;
            while ((content = fis.read()) != -1) {
                // convert to char and display it
                char converted = (char) content;
                System.out.print(converted);


            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }


    }

    /**
     * My final solution for part one
     * <p>
     * Part One:
     * Starting with a frequency of zero, what is the resulting frequency
     * after all of the changes in frequency have been applied?
     */
    static void solution() {
        List<Integer> integerList = new ArrayList<Integer>();   // Defining an integer Array List
        Scanner myFile = null;
        int sum = 0;

        try {
            myFile = new Scanner(new FileReader("src/main/java/weekone/input01.txt"));
            while (myFile.hasNext()) {
                integerList.add(myFile.nextInt());
            }
            for (int test : integerList) {
                sum += test;
            }
            System.out.println(sum);
            //Might be also possible using: System.out.println(IntStream.of(integerList).sum());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (myFile != null) {
                    myFile.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
