package Lesson_1.obstacles;

import Lesson_1.competitors.Competable;

public class Track implements Surmountable{
    private int distance;

    public Track(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean action(Competable c) {
        return c.run(distance);
    }
}
