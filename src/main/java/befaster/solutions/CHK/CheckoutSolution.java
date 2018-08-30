package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class CheckoutSolution {

    private static final int PRODUCT_A = 'A';
    private static final int PRODUCT_B = 'B';
    private static final int PRODUCT_C = 'C';
    private static final int PRODUCT_D = 'D';
    private static final int PRODUCT_E = 'E';

    private static final int UNIT_PRICE_A = 50;
    private static final int UNIT_PRICE_B = 30;
    private static final int UNIT_PRICE_C = 20;
    private static final int UNIT_PRICE_D = 15;
    private static final int UNIT_PRICE_E = 40;

    private static Map<Integer,Integer> MULTIBUYS_A = new HashMap<>();
    private static Map<Integer,Integer> MULTIBUYS_B = new HashMap<>();
    private static Map<Integer,Integer> MULTIBUYS_C = new HashMap<>();
    private static Map<Integer,Integer> MULTIBUYS_D = new HashMap<>();
    private static Map<Integer,Integer> MULTIBUYS_E = new HashMap<>();

    public CheckoutSolution(){
        MULTIBUYS_A.put(3,130);
        MULTIBUYS_A.put(5,200);
    }

    public Integer checkout(String skus) {

        Integer checkoutTotal = Integer.valueOf(-1);

        if( countInvalidProducts(skus) == 0 ){

            long countOfProductA = countProduct(skus, PRODUCT_A);
            long countOfProductB = countProduct(skus, PRODUCT_B);
            long countOfProductC = countProduct(skus, PRODUCT_C);
            long countOfProductD = countProduct(skus, PRODUCT_D);
            long countOfProductE = countProduct(skus, PRODUCT_E);

            long countFreeGifts = countOfProductE % 2;

            if( countFreeGifts > 0 ){
                countOfProductB = countOfProductB - countFreeGifts;

                countOfProductE = countOfProductE / 2;
            }


            checkoutTotal = priceProduct(countOfProductA, UNIT_PRICE_A, MULTIBUYS_A )
                    + priceProduct(countOfProductB, UNIT_PRICE_B, MULTIBUYS_B )
                    + priceProduct(countOfProductC, UNIT_PRICE_C, MULTIBUYS_C )
                    + priceProduct(countOfProductD, UNIT_PRICE_D, MULTIBUYS_D )
                    + priceProduct(countOfProductE, UNIT_PRICE_D, MULTIBUYS_E );

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
                .filter(ch->!(ch==PRODUCT_A || ch==PRODUCT_B || ch==PRODUCT_C || ch==PRODUCT_D || ch==PRODUCT_E) )
                .count();
    }

    public Integer priceProduct( long count , Integer unitPrice, Map<Integer,Integer> multiBuys ){
        Integer price = Integer.valueOf(0);

        int iCount = (int)count;

        if( count > 0 ){
            if( !multiBuys.isEmpty() ){

                Integer[] intKeys = multiBuys.keySet().toArray(new Integer[]{});
                Arrays.sort(intKeys);

                for(int i = 0; i<intKeys.length; i++ ){
                    int key = intKeys[i];
                    int numMultiBuys = iCount / key;
                    if( numMultiBuys > 0 ) {
                        price = price.intValue() + (multiBuys.get(key)*numMultiBuys);
                        iCount = iCount % key;
                    }
                }

                price = price + (iCount*unitPrice.intValue());
            }
            else{
                price = Integer.valueOf( iCount * unitPrice.intValue() );
            }
        }

        return price;
    }
}
