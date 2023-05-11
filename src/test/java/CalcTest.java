import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
public class CalcTest {

    @Test
    public void givenTwoNumbers_ReturnTheirSum(){
        Calc calc = new Calc();
        assertThat(calc.sum(1,2)).isEqualTo(3);
    }
}
