package befaster.solutions.TST;

import befaster.solutions.CHK.CheckoutSolution;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CheckOutTest {
    private CheckoutSolution sol;

    @Before
    public void name() {
        sol = new CheckoutSolution();
    }

//    @Test
//    public void testNonMutliBuy() {
//        assertThat(sol.checkout("ABCD"), equalTo(115));
//    }

    @Test
    public void testCountProduct() {
        assertThat(sol.countProduct("ABCD", 'A'), equalTo(1));
    }
}