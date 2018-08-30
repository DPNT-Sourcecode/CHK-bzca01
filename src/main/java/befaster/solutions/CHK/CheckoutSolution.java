package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.function.Predicate;

public class CheckoutSolution {
    public Integer checkout(String skus) {

        long countOfProductA = countProduct(skus, 'A');
        long countOfProductB = countProduct(skus, 'B');
        long countOfProductC = countProduct(skus, 'C');
        long countOfProductD = countProduct(skus, 'D');


        throw new SolutionNotImplementedException();
    }


    private long countProduct( String skus, final int productId ){
        return skus.chars()
                .filter(ch->ch==productId)
                .count();
    }
}
