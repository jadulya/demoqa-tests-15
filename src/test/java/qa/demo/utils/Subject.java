package qa.demo.utils;

import java.util.Random;

public enum Subject {
    Accounting, Arts, Maths, English, Chemistry, Economics, Commerce, History, Physics, Biology ;

    public static Subject getRandomSubject() {
        int pick = new Random().nextInt(Subject.values().length);
        return Subject.values()[pick];
    }

}