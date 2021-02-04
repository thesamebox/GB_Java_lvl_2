package Lesson_1.obstacles;

import Lesson_1.competitors.Competable;

public class Wall implements Surmountable {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean action(Competable c) {
        return c.jump(height);
    }
}
