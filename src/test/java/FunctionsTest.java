import io.qameta.allure.Feature;
import lesson4.NegativeOrNullTriangleSideException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import  lesson4.NegativeOrNullTriangleSideException;
import static lesson4.Functions.calculateArea;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;


@Feature("Тестирование вычисления площади треугольника")
    public class FunctionsTest {
        @Test
        void positiveTriangleAreaCalculationTest() throws NegativeOrNullTriangleSideException {
            Assertions.assertEquals(calculateArea(3, 3, 3), 2.23606797749979);
        }

        @Test
        void degenerateTriangleTest() {
            assertThatExceptionOfType(
                    NegativeOrNullTriangleSideException.class).isThrownBy(() -> calculateArea(-1, 5, 6));
        }
    }


