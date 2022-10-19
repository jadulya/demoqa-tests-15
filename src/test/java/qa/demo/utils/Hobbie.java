package qa.demo.utils;

import java.util.Random;

public enum Hobbie {
    Sports, Reading, Music;

    public static Hobbie getRandomHobbie() {
        int pick = new Random().nextInt(Hobbie.values().length);
        return Hobbie.values()[pick];
    }

}
