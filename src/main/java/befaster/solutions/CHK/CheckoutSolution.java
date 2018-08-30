package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.function.Predicate;

public class CheckoutSolution {

    private static final int PRODUCT_A = 'A';
    private static final int PRODUCT_B = 'B';
    private static final int PRODUCT_C = 'C';
    private static final int PRODUCT_D = 'D';

    private static final int UNIT_PRICE_A = 50;
    private static final int UNIT_PRICE_B = 30;
    private static final int UNIT_PRICE_C = 20;
    private static final int UNIT_PRICE_D = 15;

    private static final int MULTIBUY_PRICE_A = 130;
    private static final int MULTIBUY_PRICE_B = 45;
    private static final int MULTIBUY_PRICE_C = 20;
    private static final int MULTIBUY_PRICE_D = 15;

    private static final Integer MULTIBUY_THRESHOLD_A = 3;
    private static final Integer MULTIBUY_THRESHOLD_B = 2;
    private static final Integer MULTIBUY_THRESHOLD_C = null;
    private static final Integer MULTIBUY_THRESHOLD_D = null;

    public Integer checkout(String skus) {

        Integer checkoutTotal = Integer.valueOf(-1);

        if( countInvalidProducts(skus) == 0 ){

            long countOfProductA = countProduct(skus, PRODUCT_A);
            long countOfProductB = countProduct(skus, PRODUCT_B);
            long countOfProductC = countProduct(skus, PRODUCT_C);
            long countOfProductD = countProduct(skus, PRODUCT_D);

            checkoutTotal = priceProduct(countOfProductA, UNIT_PRICE_A, MULTIBUY_THRESHOLD_A, MULTIBUY_PRICE_A )
                    + priceProduct(countOfProductB, UNIT_PRICE_B, MULTIBUY_THRESHOLD_B, MULTIBUY_PRICE_B )
                    + priceProduct(countOfProductC, UNIT_PRICE_C, MULTIBUY_THRESHOLD_C, MULTIBUY_PRICE_C )
                    + priceProduct(countOfProductD, UNIT_PRICE_D, MULTIBUY_THRESHOLD_D, MULTIBUY_PRICE_D );

        }

        return checkoutTotal;
    }


    public long countProduct( String skus, final int productId ){
        return skus.chars()
                .filter(ch->ch==productId)
                .count();
    }

    private long countInvalidProducts( String skus ){
        return skus.chars()
                .filter(ch->!(ch==PRODUCT_A || ch==PRODUCT_B || ch==PRODUCT_C || ch==PRODUCT_D) )
                .count();
    }

    public Integer priceProduct( long count , Integer unitPrice, Integer multiBuyNumber, Integer multiBuyPrice ){
        Integer price = Integer.valueOf(0);

        int iCount = (int)count;

        if( count > 0 ){
            if( multiBuyNumber != null ){
                int numMultiBuys = iCount / multiBuyNumber.intValue();
                int nonQualifying = iCount % multiBuyNumber.intValue();

                price = Integer.valueOf(numMultiBuys);
                price = Integer.valueOf((numMultiBuys*multiBuyPrice.intValue()) + (nonQualifying*unitPrice.intValue()));
            }
            else{
                price = Integer.valueOf( iCount * unitPrice.intValue() );
            }
        }

        return price;
    }
}