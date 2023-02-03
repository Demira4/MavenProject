package Lesson4;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(10,13,17);
        try {
            System.out.println("gjhgkhj"+ triangle.geroneSquare());
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}
