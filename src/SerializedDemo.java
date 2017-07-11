import java.io.*;

/**
 * Created by Antonella on 7/10/17.
 */
public class SerializedDemo {
    public static void main(String[] args) {


        Car car = new Car();
        car.setMake("Ford");
        car.setMileage(123456);
// this section is writing to the file
// all lines associated with the filestream must be handled via exceptions
        try {

            // FileOutputStream knows how to connect and create a file
            // so if the file passed in as a parameter does not exist
            // it creates one for us automatically
            FileOutputStream filestream = new FileOutputStream("myname.ser");

            // ObjectOutputStream lets you write objects, but it can't directly connect to a file
            // it needs to be fed a helper
            // this is called chaining one stream to another (also demonstrates factory pattern)
            ObjectOutputStream os = new ObjectOutputStream(filestream);

            // serializes the objects referenced by the object Cat
            os.writeObject(car);

            // closing the stream at the top closes the ones underneath
            // so, FileOutputStream and the file close automatically
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // this section is reading from the file
        // here if the file that we're attempting to read from
        // doesn't exist we will get an exception :(
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("myname.ser"));
            Car carRestore = (Car) is.readObject();

            System.out.println("type: " + carRestore.getClass() + " " + carRestore.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
