import magicsquares.Square;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SquareTest {

    @Test
    public void testThreeByThreeSquareEqualMagicalConstant(){
        Square mySquare = new Square(3);
        for (int i =0; i<3; i++){
            assertTrue(mySquare.isSumColN(i) && mySquare.isSumRowN(i));
        }
        assertTrue(mySquare.isSumDiagonalN(0) && mySquare.isSumDiagonalN(1));

    }
}
