package Lesson_1;

import Lesson_1.competitors.Cat;
import Lesson_1.competitors.Competable;
import Lesson_1.competitors.Human;
import Lesson_1.competitors.Robot;
import Lesson_1.obstacles.Surmountable;
import Lesson_1.obstacles.Track;
import Lesson_1.obstacles.Wall;

public class Main {
    public static void main(String[] args) {
        Competable[] competitors = {
                new Human(3000, 1),
                new Cat(700, 3),
                new Robot(1000, 0),
        };

        Surmountable[] obstacles = {
                new Wall(2),
                new Track(1000),
        };

        for (Competable competitor : competitors) {
            for (Surmountable obstacle : obstacles) {
                if (obstacle.action(competitor)) {
                    System.out.println(competitor.getClass().getSimpleName() + " successfully got over the " + obstacle.getClass().getSimpleName());
                } else {
                    System.out.println(competitor.getClass().getSimpleName() + " failed with the " + obstacle.getClass().getSimpleName());
                }
            }

        }
    }
}