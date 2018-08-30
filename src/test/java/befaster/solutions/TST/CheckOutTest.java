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
    public void testCountProductA() {
        assertThat(sol.countProduct("ABCD", 'A'), equalTo(1L));
    }

    @Test
    public void testCountProductB() {
        assertThat(sol.countProduct("ABBB", 'B'), equalTo(3L));
    }

    @Test
    public void testUnitPrice() {
        assertThat(sol.priceProduct(1, 10, null, 1), equalTo(10));
    }

    @Test
    public void testMultiPrice() {
        assertThat(sol.priceProduct(2, 10, null, 1), equalTo(20));
    }

    @Test
    public void testMultiPriceBelowThreshold() {
        assertThat(sol.priceProduct(2, 10, 3, 15), equalTo(20));
    }

    @Test
    public void testMultiPriceEqualThreshold() {
        assertThat(sol.priceProduct(3, 10, 3, 15), equalTo(15));
    }

    @Test
    public void testMultiPriceOneOverThreshold() {
        assertThat(sol.priceProduct(4, 10, 3, 15), equalTo(25));
    }
}