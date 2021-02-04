package Lesson_1.competitors;

public class Cat implements Competable{
    private int runDistanceMax;
    private int jumpHeightMax;

    public Cat(int runDistanceMax, int jumpHeightMax) {
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
