package Lesson4;

public class Triangle {
        int a;
        int b;
        int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double geroneSquare() throws MyException {
        double squareTriangle;
        if (a>0&&b>0&&c>0){
            if (a+b>c&&a+c>b&&b+c>a) {
                    double p = (a + b + c) / 2.0;
                    squareTriangle = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                    System.out.printf("Площадь %.2f", squareTriangle);
                    return squareTriangle;
            } else  throw new MyException("Нельзя построить треугольник!");
        } else throw new MyException("Ошибка! Введено отрицательное значение!");





    }

}
