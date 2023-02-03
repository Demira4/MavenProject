package Lesson4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleTest {


    @ParameterizedTest
    @CsvSource({"0,5,3", "-10,7,5", "20,4,10"})
    void negativeTest(int a, int b, int c) {
        Triangle triangle = new Triangle(a, b, c);

        Assertions.assertThrows(MyException.class, () -> {
            triangle.geroneSquare();
        });
    }

    @Test
    void positiveTest() {
            Triangle triangle = new Triangle(10, 13,17);
            try {
                triangle.geroneSquare();
                Assertions.assertEquals(64.8074069840786, triangle.geroneSquare());

            } catch (MyException e) {
                e.printStackTrace();
            }

    }

   // @ParameterizedTest
}
