package Lesson_1.competitors;

public class Human implements Competable {
    int runDistanceMax;
    int jumpHeightMax;

    public Human(int runDistanceMax, int jumpHeightMax) {
        this.runDistanceMax = runDistanceMax;
        this.jumpHeightMax = jumpHeightMax;
    }

    @Override
    public boolean jump(int height) {
        return (height <= jumpHeightMax);
    }

    @Override
    public boolean run(int length) {
        return (length <= runDistanceMax);
    }
}
