package company.example.android.providejokes;

import java.util.HashMap;
import java.util.Random;

// TODO 1 ) Creating a Java library via module defined "providejokes"
// TODO 2 ) Creating CreatingJoke class to create jokes and return them
public class CreatingJoke  {

    // TODO 3 ) Creating HashMap refering to number id as Integer and joke as a String for jokes
    private static HashMap<Integer,String> jokeList = new HashMap<Integer, String>();

    // TODO 8 ) Defining random
    private static Random random = new Random();

    // TODO 14 ) Defining joke as a String
    private static String joke = "";


    // TODO 4 ) Creating a jokeCreation method to create jokes
    private static HashMap<Integer,String> jokeCreation(){

        // TODO 5 ) Adding 5 jokes into the jokeList
        jokeList.put(0,"My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.");
        jokeList.put(1,"What is the difference between a snowman and a snowwoman?" +
                "\n" +
                "Snowballs.");
        jokeList.put(2,"Can a kangaroo jump higher than a house?" +
                "\n" +
                "Of course, a house doesn’t jump at all.");
        jokeList.put(3," Anton, do you think I’m a bad mother?" +
                "\n" +
                "My name is Paul.");
        jokeList.put(4,"Patient: Oh doctor, I\\u0027m just so nervous. This is my first operation." +
                "\n" +
                "Doctor: Don't worry. Mine too.");

        // TODO 6 ) Returning jokeList
        return jokeList;

    }

    // TODO 7 ) Creating randomNumber for getting any number from 0 to 5 to get the joke in the size of list according to selected random number.
    private static int randomNumber(){

        // TODO 9 ) Defining selectedRandomNumber between 0 to 5
        int selectedRandomNumber = random.nextInt(jokeList.size());

        // TODO 10 ) Returning selectedRandomNumber
        return selectedRandomNumber;
    }

    // TODO 11 ) Creating getJoke method to get a joke from jokelist with respect to selected Random Number
    public static String getJoke(){

        // TODO 12 ) Defining jokeCreation to create joke
        jokeCreation();

        // TODO 13 ) Defining selectedNumber
        int choosenNumber = randomNumber();

        // TODO 15 ) Getting a joke as A string from list according to choosenNumber
        joke = jokeList.get(choosenNumber);

        // TODO 16 ) Returning joke
        return joke;

    }


}
