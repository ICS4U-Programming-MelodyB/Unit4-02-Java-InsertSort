import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Will use the bubble sort method to
 * sort though an array and arrange the numbers
 * in ascending order.
 *
 * @author  Melody Berhane
 * @version 1.0
 *
 * @since 2023-05-08.
 */

public final class InsertSort {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private InsertSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Pass path to file as parameter.
        final File file = new File("input.txt");

        // Create a list of strings.
        final List<String> listOfStrings =
            new ArrayList<String>();

        // Declare variable
        String inputString;

        // Usage of try catch to detect error.
        try {
            // Create FileWriter object to write to file.
            final FileWriter fileWrite = new FileWriter("output.txt");
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(file);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fileWrite);

            while (sc.hasNextLine()) {
                // Read line as string.
                inputString = sc.nextLine();
                // Add to list.
                listOfStrings.add(inputString);
            }

            // Convert from list to array.
            final String[] arrayOfStr = listOfStrings.toArray(new String[0]);

            // Convert all elements in array to integers.
            for (int counter = 0; counter < arrayOfStr.length; counter++) {
                try {
                    final String[] inputNum = arrayOfStr[counter].split(" ");
                    final int[] arrayNum = new int[inputNum.length];
                    for (int counter2 = 0; counter2 < inputNum.length;
                        counter2++) {
                        arrayNum[counter2] =
                            Integer.parseInt(inputNum[counter2]);

                    }
                    // Call function.
                    final int[] insertionSort = sortInsert(arrayNum);

                    // Write to file
                    write.println(Arrays.toString(insertionSort));

                } catch (NumberFormatException error) {
                    // Write error in file.
                    write.println("Valid input only!");
                    continue;
                }
            }

            // Closes scanner & writer.
            write.close();
            sc.close();

        } catch (IOException error) {
            // Displays error to user.
            System.out.println("An error occurred: "
                    + error.getMessage());
        }
    }

    /**
    * This function uses recursion to
    * find the search of number.
    *
    * @param listNum passed
    * @return listNum.
    */
    public static int[] sortInsert(int[] listNum) {
        // This loop will access each element in array.
        for (int counter1 = 1; counter1 < listNum.length - 1; counter1++) {
            // Declare variable.
            final int current = listNum[counter1];
            int temp = counter1 - 1;

            // Usage of loop that checks if current is bigger than
            // previous, switching positions if so, to sort.
            while (temp >= 0 && listNum[temp] > current) {
                listNum[temp + 1] = listNum[temp];
                // Decrement temp.
                temp = temp - 1;
            }
            listNum[temp + 1] = current;
        }
        // Return to main.
        return listNum;
    }
}
