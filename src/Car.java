import java.io.Serializable;

/**
 * Created by Antonella on 7/10/17.
 */

// Serializable is known as a marking or tag interface (no methods to implement)
// serializable just means that objects can be saved through
// the serializable mechanism (like flattening)
public class Car implements Serializable {

    // using transient skips the variable from being saved
    // if you do this you will want to bring the object back with some
    // default value
    // this might be helpful if you are inheriting values from another class
    // that are not implementing the serializable interface (serializable is all or nothing)
    // transient int test;
    private int mileage;
    private String make;

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String toString() {
        return make + "," + mileage;
    }
}
