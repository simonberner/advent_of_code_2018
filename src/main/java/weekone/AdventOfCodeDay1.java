package weekone;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Exploring Day1 Part1&2
 */
class AdventOfCodeDay1 {

    public static void main(String[] args) {
        solutionDay1Part1();
        solution1Day1Part2();
    }


    /**
     * An experiment1 Day1 Part1: failed
     * <p>
     * Part One:
     * Starting with a frequency of zero, what is the resulting frequency
     * after all of the changes in frequency have been applied?
     */
    static void experiment1Day1Part1() {

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
     * An experiment2 Day1 Part1: failed
     * <p>
     * Part One:
     * Starting with a frequency of zero, what is the resulting frequency
     * after all of the changes in frequency have been applied?
     */
    static void experiment2Day1Part1() {

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
     * My final solution for Day1 Part1
     * <p>
     * Part One:
     * Starting with a frequency of zero, what is the resulting frequency
     * after all of the changes in frequency have been applied?
     */
    static void solutionDay1Part1() {
        List<Integer> integerList = new ArrayList<Integer>();   // Defining an integer Array List
        Scanner myFile = null;
        int sum = 0;

        try {
            myFile = new Scanner(new FileReader("src/main/java/weekone/input01.txt"));
            while (myFile.hasNext()) {
                integerList.add(myFile.nextInt());
            }
            for (int integer : integerList) {
                sum += integer;
                //System.out.println(sum);
            }
            System.out.println("Day 1 Part1 - The resulting frequency is: " + sum);
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

    /**
     * An experiment1 for Day1 Part2
     * <p>
     * Part Two:
     * What is the first frequency your device reaches twice?
     */
    static void experiment1Day1Part2() {

        Set<Integer> integerList = new HashSet();   // Defining an integer Array List
        Set<Integer> setToReturn = new HashSet();
        Set<Integer> set1 = new HashSet();

        Scanner myFile = null;

        try {
            myFile = new Scanner(new FileReader("src/main/java/weekone/input01.txt"));
            while (myFile.hasNext()) {
                integerList.add(myFile.nextInt());
            }
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

        for (int myInt : integerList) {
            if (!set1.add(myInt)) {
                //this set is 0, but why?
                setToReturn.add(myInt);
            }
        }

        String test = "test";

        for (int myInt2 : setToReturn) {
            System.out.println(myInt2);
        }

    }

    /**
     * My final solution for Day1 Part2
     * <p>
     * What is the first 'resulting' frequency your device reaches twice?
     * (Note that your device might need to repeat its list of frequency changes
     * many times before a duplicate frequency is found, and that duplicates might
     * be found while in the middle of processing the list.)
     */
    static void solution1Day1Part2() {

        Scanner file = null;
        Set<Integer> resultingFrequencies = new HashSet<>();
        int resultingFrequency = 0;
        int change = 0;
        boolean duplicateFound = false;

        try {
            while (!duplicateFound) {

                file = new Scanner(new FileReader("src/main/java/weekone/input01.txt"));

                while (file.hasNext()) {
                    //System.out.println("\nCurrent frequency is: " + resultingFrequency);
                    change = file.nextInt();
                    resultingFrequency += change;
                    //System.out.println("Change of: " + change);
                    //System.out.println("Resulting frequency is: " + resultingFrequency);

                    if (resultingFrequencies.contains(resultingFrequency)) {
                        System.out.println("\nDay1 Part2 - The first duplicate resulting frequency is: " + resultingFrequency);
                        duplicateFound = true;
                        break;
                    }
                    resultingFrequencies.add(resultingFrequency);
                }
                file.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
