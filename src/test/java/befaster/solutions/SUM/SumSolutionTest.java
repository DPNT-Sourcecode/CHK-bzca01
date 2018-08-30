package befaster.solutions.SUM;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SumSolutionTest {
    private SumSolution sum;

    @Before
    public void setUp() {

        sum = new SumSolution();
    }

    @Test
    public void compute_sum() {
        assertThat(sum.compute(1, 1), equalTo(2));
    }

    @Test( expected = IllegalArgumentException.class )
    public void testNullIntegerPassedInParam1(){
        sum.sum(null, Integer.valueOf(1));
    }

    @Test( expected = IllegalArgumentException.class )
    public void testNullIntegerPassedInParam2(){
        sum.sum(Integer.valueOf(1), null);
    }

    @Test( expected = IllegalArgumentException.class )
    public void testTooLowIntegerPassedInParam1(){
        sum.sum(Integer.valueOf(-1), Integer.valueOf(1));
    }

    @Test( expected = IllegalArgumentException.class )
    public void testTooHighIntegerPassedInParam1(){
        sum.sum(Integer.valueOf(101), Integer.valueOf(1));
    }

    @Test( expected = IllegalArgumentException.class )
    public void testTooLowIntegerPassedInParam2() {
        sum.sum(Integer.valueOf(1), Integer.valueOf(-1));
    }

    @Test( expected = IllegalArgumentException.class )
    public void testTooHighIntegerPassedInParam2(){
        sum.sum(Integer.valueOf(1), Integer.valueOf(101));
    }

    @Test
    public void testMedians(){
        assertThat(sum.sum(Integer.valueOf(50),Integer.valueOf(50)), equalTo(Integer.valueOf(100)));
    }

    @Test
    public void testLowBoundary(){
        assertThat(sum.sum(Integer.valueOf(1),Integer.valueOf(1)), equalTo(Integer.valueOf(2)));
    }

    @Test
    public void testHighBoundary(){
        assertThat(sum.sum(Integer.valueOf(100),Integer.valueOf(100)), equalTo(Integer.valueOf(200)));
    }
}
