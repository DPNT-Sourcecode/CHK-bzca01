package befaster.solutions.TST;

import befaster.solutions.CHK.CheckoutSolution;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
        assertThat(sol.priceProduct(1, 10, new HashMap<>()), equalTo(10));
    }

    @Test
    public void testMultiPrice() {
        assertThat(sol.priceProduct(2, 10, new HashMap<>()), equalTo(20));
    }

    @Test
    public void testMultiPriceBelowThreshold() {
        Map<Integer,Integer> multiBuys = new HashMap<>();
        multiBuys.put(3,25);
        assertThat(sol.priceProduct(2, 10, multiBuys), equalTo(20));
    }

    @Test
    public void testMultiPriceEqualThreshold() {
        Map<Integer,Integer> multiBuys = new HashMap<>();
        multiBuys.put(3,20);
        assertThat(sol.priceProduct(3, 10, multiBuys), equalTo(20));
    }

    @Test
    public void testMultiPriceOneOverThreshold() {
        Map<Integer,Integer> multiBuys = new HashMap<>();
        multiBuys.put(3,15);
        assertThat(sol.priceProduct(4, 10, multiBuys), equalTo(25));
    }

    @Test
    public void testMultiPriceTwoThresholds() {
        Map<Integer,Integer> multiBuys = new HashMap<>();
        multiBuys.put(5,30);
        multiBuys.put(3,20);
        assertThat(sol.priceProduct(5, 10, multiBuys), equalTo(30));
    }

    @Test
    public void testMultiPriceTwoThresholds2() {
        Map<Integer,Integer> multiBuys = new HashMap<>();
        multiBuys.put(5,30);
        multiBuys.put(3,20);
        assertThat(sol.priceProduct(6, 10, multiBuys), equalTo(40));
    }

    @Test
    public void testMultiPriceTwoThresholds3() {
        Map<Integer,Integer> multiBuys = new HashMap<>();
        multiBuys.put(5,30);
        multiBuys.put(3,20);
        assertThat(sol.priceProduct(8, 10, multiBuys), equalTo(50));
    }

    @Test
    public void testMultiPriceTwoThresholds4() {
        Map<Integer,Integer> multiBuys = new HashMap<>();
        multiBuys.put(5,30);
        multiBuys.put(3,20);
        assertThat(sol.priceProduct(9, 10, multiBuys), equalTo(60));
    }

    @Test
    public void testE() {
        assertThat(sol.checkout("E"), equalTo(40));
    }

    @Test
    public void testAll() {
        assertThat(sol.checkout("ABCDE"), equalTo(155));
    }

    @Test
    public void testEEB() {
        assertThat(sol.checkout("EEB"), equalTo(40));
    }
}