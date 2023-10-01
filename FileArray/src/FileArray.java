import java.io.*;
import java.util.Random;

public class FileArray {

    private File file;
    private final int MAX_VALUE = 1024;

    public FileArray (File file) {
        this.file = file;
    }

    public FileArray (File file, int n) throws IOException {
        this.file = file;
        int[] givenIntArray = new int[n];
        Random random = new Random();

        for (int i = 0; i < givenIntArray.length; i++) {
            givenIntArray[i] = random.nextInt(MAX_VALUE+1);
        }
        write(givenIntArray);
    }

    public void print() throws IOException {
        int[] intArray = read();

        int elementsPerRow = 5;
        int numRows = (int) Math.ceil((double) intArray.length / elementsPerRow);

        for (int i = 0; i < numRows; i++) {
            int start = i * elementsPerRow;
            int end = Math.min((i + 1) * elementsPerRow - 1, intArray.length - 1);

            System.out.printf("[%02d-%02d] ", start, end);

            for (int j = start; j <= end; j++) {
                System.out.printf("%3d ", intArray[j]);
            }

            System.out.println();
        }
    }

    public void incrementAll() throws IOException {
        int[] intArray = read();

        for (int i = 0; i < intArray.length; i++) {
            intArray[i]++;
        }

        write(intArray);

    }

    private int[] read() throws IOException {
        FileInputStream fis = new FileInputStream(file);
        DataInputStream dis = new DataInputStream(fis);

        int arrayLength = dis.readInt();

        int[] intArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            intArray[i] = dis.readInt();
        }

        dis.close();

        return intArray;
    }

    private void write(int[] intArray) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        DataOutputStream dos = new DataOutputStream(fos);

        dos.writeInt(intArray.length);

        for (int i = 0; i<intArray.length; i++) {
            dos.writeInt(intArray[i]);
        }
        dos.close();
    }
}
