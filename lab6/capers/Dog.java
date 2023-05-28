package capers;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import static capers.Utils.*;

/** Represents a dog that can be serialized.
 * @author LBZ
*/
public class Dog { // TODO

    /** Folder that dogs live in. */
    static final File DOG_FOLDER = Utils.join(CapersRepository.CAPERS_FOLDER,  "dogs");
    /** Age of dog. */
    private int age;
    /** Breed of dog. */
    private String breed;
    /** Name of dog. */
    private String name;

    /**
     * Creates a dog object with the specified parameters.
     * @param name Name of dog
     * @param breed Breed of dog
     * @param age Age of dog
     */
    public Dog(String name, String breed, int age) {
        this.age = age;
        this.breed = breed;
        this.name = name;
    }

    /**
     * Reads in and deserializes a dog from a file with name NAME in DOG_FOLDER.
     *
     * @param name Name of dog to load
     * @return Dog read from file
     */
    public static Dog fromFile(String name) {
        String dogInfo = readContentsAsString(Utils.join(DOG_FOLDER, name + ".txt") );
        String[] lines = dogInfo.split("\r?\n|\r");
        if (lines.length != 3) {
            throw new RuntimeException("Invalid status of dogs");
        }
        return new Dog(lines[0], lines[1], Integer.parseInt(lines[2]));
    }

    /**
     * Increases a dog's age and celebrates!
     */
    public void haveBirthday() {
        age += 1;
        System.out.println(toString());
        System.out.println("Happy birthday! Woof! Woof!");
    }

    /**
     * Saves a dog to a file for future use.
     */
    public void saveDog() {
        File dogInfo = Utils.join(DOG_FOLDER, name + ".txt");
        try {
            dogInfo.createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);}

        writeContents(dogInfo, name + "\n" + breed + "\n" + age);
    }

    @Override
    public String toString() {
        return String.format(
            "Woof! My name is %s and I am a %s! I am %d years old! Woof!",
            name, breed, age);
    }

}
