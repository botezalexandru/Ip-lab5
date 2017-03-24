import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class Main {
    private Main(String file) {
        int max = 0;
        // Read the entire file in
        List<String> myFileLines = null;
        try {
            myFileLines = Files.readAllLines(Paths.get(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Remove any blank lines
        assert myFileLines != null;
        for (int i = myFileLines.size() - 1; i >= 0; i--) {
            if (myFileLines.get(i).isEmpty()) {
                myFileLines.remove(i);
            }
        }

        // Declare you 2d array with the amount of lines that were read from the file
        int[][] intArray = new int[myFileLines.size()][];

        // Iterate through each row to determine the number of columns
        for (int i = 0; i < myFileLines.size(); i++) {
            // Split the line by spaces
            String[] splitLine = myFileLines.get(i).split("\\s");


            // Declare the number of columns in the row from the split
            intArray[i] = new int[splitLine.length];

            //get the maxium of columns
            max = maxium(max, splitLine.length);
            for (int j = 0; j < splitLine.length; j++) {
                // Convert each String element to an integer
                intArray[i][j] = Integer.parseInt(splitLine[j]);
            }
        }

        // Print the integer array
        for (int[] row : intArray) {
            System.out.print("|");
            for (int col : row) {
                if (col == 1) {
                    System.out.print("\t *");
                } else {
                    System.out.print("\t  ");
                }
            }
            System.out.println();
        }
        System.out.println("+-----------------------------------");
        System.out.print("   ");
        for (int count = 1; count <= max; count++) {
            System.out.print("\t" + count);
        }
    }

    private int maxium(int a, int b) {
        return Math.max(a, b);
    }

    public static void main(String[] args) throws Exception {
        new Main("array.txt");
//        new Main("array2.txt");
//        new Main("array3.txt");

    }
}
