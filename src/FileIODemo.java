import java.io.*;

/**
 * Created by Antonella on 7/10/17.
 */
public class FileIODemo {
    public static void main(String[] args) {

        //write to a file
        try {
            // if the test.txt file does not exist filewriter will write it
            FileWriter writer = new FileWriter("test.txt");
            writer.write("Hello!");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Some things you might want to do with this

        // make a file object representing an existing file
        File f = new File("mynewfile.txt");

        // make a new directory
        File dir = new File("Chapter 56");
        dir.mkdir();

        // list the contents of a directory
        if (dir.isDirectory()) {
            String[] dirContents = dir.list();
            for (int i = 0; i < dirContents.length; i++) {
                System.out.println(dirContents[i]);
            }
        }

        // get the absolute path of a file or directory
        System.out.println(dir.getAbsolutePath());

        // delete a file or directory (returns true if successful)
        boolean isDeleted = f.delete();


        // reading from a file
        try {
            File myFile = new File("test.txt");
            // FileReader is a connection stream for characters that connects to a text file
            FileReader fileReader = new FileReader(myFile);
            // BufferedReader allows the FileReader to chain to it (pass in as paramater)
            // it only goes back to the file when the buffer is empty
            BufferedReader reader = new BufferedReader(fileReader);

            // declare a string variable to hold each line as it's read
            String line = null;

            // this says -- read a line of text, and then assign it to the string
            // variable line -- and while that line is not null, print out the line
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
