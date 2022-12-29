import java.io.*;

public class Array2DClass implements Array2D {

    Integer[][] array2D = null;
    String fileName;

    // Two constructors. One that lets the caller specify the dimensions of the array
    // and one that takes a file name from which a saved array can be read.

    public Array2DClass(int rows, int columns) {
        array2D = new Integer[rows][columns];
    }

    public Array2DClass(File file) {
        fileName = file.getName();
    }

    //saving contents of array2D to the file
    public void saveFile() {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(array2D);
        } catch (Exception e) {
            System.out.println("Exception saving array to file");
        }
    }

    //loading contents of the file to array2D
    public void loadFile() {
        try {
            FileInputStream fis = new FileInputStream(new File("array2Dfile.txt"));
            ObjectInputStream iis = new ObjectInputStream(fis);
            array2D = (Integer[][]) iis.readObject();

        } catch (Exception e) {
            System.out.println("Exception loading array from file");
        }

    }


    @Override
    public void set(int row, int col, int value) {
        array2D[row][col] = value;
    }

    @Override
    public Integer get(int row, int col) {
        return array2D[row][col];
    }

}
