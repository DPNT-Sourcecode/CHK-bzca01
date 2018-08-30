package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class CheckoutSolution {

    private static final int PRODUCT_A = 'A';
    private static final int PRODUCT_B = 'B';
    private static final int PRODUCT_C = 'C';
    private static final int PRODUCT_D = 'D';
    private static final int PRODUCT_E = 'E';
    private static final int PRODUCT_F = 'F';
    private static final int PRODUCT_G = 'G';
    private static final int PRODUCT_H = 'H';
    private static final int PRODUCT_I = 'I';
    private static final int PRODUCT_J = 'J';
    private static final int PRODUCT_K = 'K';
    private static final int PRODUCT_L = 'L';
    private static final int PRODUCT_M = 'M';
    private static final int PRODUCT_N = 'N';
    private static final int PRODUCT_O = 'O';
    private static final int PRODUCT_P = 'P';
    private static final int PRODUCT_Q = 'Q';
    private static final int PRODUCT_R = 'R';
    private static final int PRODUCT_S = 'S';
    private static final int PRODUCT_T = 'T';
    private static final int PRODUCT_U = 'U';
    private static final int PRODUCT_V = 'V';
    private static final int PRODUCT_W = 'W';
    private static final int PRODUCT_X = 'X';
    private static final int PRODUCT_Y = 'Y';
    private static final int PRODUCT_Z = 'Z';

    private static final int UNIT_PRICE_A = 50;
    private static final int UNIT_PRICE_B = 30;
    private static final int UNIT_PRICE_C = 20;
    private static final int UNIT_PRICE_D = 15;
    private static final int UNIT_PRICE_E = 40;
    private static final int UNIT_PRICE_F = 10;
    private static final int UNIT_PRICE_G = 20;
    private static final int UNIT_PRICE_H = 10;
    private static final int UNIT_PRICE_I = 35;
    private static final int UNIT_PRICE_J = 60;
    private static final int UNIT_PRICE_K = 80;
    private static final int UNIT_PRICE_L = 90;
    private static final int UNIT_PRICE_M = 15;
    private static final int UNIT_PRICE_N = 40;
    private static final int UNIT_PRICE_O = 10;
    private static final int UNIT_PRICE_P = 50;
    private static final int UNIT_PRICE_Q = 30;
    private static final int UNIT_PRICE_R = 50;
    private static final int UNIT_PRICE_S = 30;
    private static final int UNIT_PRICE_T = 20;
    private static final int UNIT_PRICE_U = 40;
    private static final int UNIT_PRICE_V = 50;
    private static final int UNIT_PRICE_W = 20;
    private static final int UNIT_PRICE_X = 90;
    private static final int UNIT_PRICE_Y = 10;
    private static final int UNIT_PRICE_Z = 50;

    private static Map<Integer,Integer> MULTIBUYS_A = new HashMap<>();
    private static Map<Integer,Integer> MULTIBUYS_B = new HashMap<>();
    private static Map<Integer,Integer> MULTIBUYS_H = new HashMap<>();
    private static Map<Integer,Integer> MULTIBUYS_K = new HashMap<>();
    private static Map<Integer,Integer> MULTIBUYS_P = new HashMap<>();
    private static Map<Integer,Integer> MULTIBUYS_Q = new HashMap<>();
    private static Map<Integer,Integer> MULTIBUYS_V = new HashMap<>();


    private static Map<Integer,Integer> NO_MULTIBUYS = new HashMap<>();

    public CheckoutSolution(){
        MULTIBUYS_A.put(3,130);
        MULTIBUYS_A.put(5,200);

        MULTIBUYS_B.put(2,45);

        MULTIBUYS_H.put(5,45);
        MULTIBUYS_H.put(10,80);

        MULTIBUYS_K.put(2,150);

        MULTIBUYS_P.put(5,200);

        MULTIBUYS_Q.put(3,80);

        MULTIBUYS_V.put(2,90);
        MULTIBUYS_V.put(3,130);
    }

    public Integer checkout(String skus) {

        Integer checkoutTotal = Integer.valueOf(-1);

        if( countInvalidProducts(skus) == 0 ){

            long countOfProductA = countProduct(skus, PRODUCT_A);
            long countOfProductB = countProduct(skus, PRODUCT_B);
            long countOfProductC = countProduct(skus, PRODUCT_C);
            long countOfProductD = countProduct(skus, PRODUCT_D);
            long countOfProductE = countProduct(skus, PRODUCT_E);
            long countOfProductF = countProduct(skus, PRODUCT_F);
            long countOfProductG = countProduct(skus, PRODUCT_G);
            long countOfProductH = countProduct(skus, PRODUCT_H);
            long countOfProductI = countProduct(skus, PRODUCT_I);
            long countOfProductJ = countProduct(skus, PRODUCT_J);
            long countOfProductK = countProduct(skus, PRODUCT_K);
            long countOfProductL = countProduct(skus, PRODUCT_L);
            long countOfProductM = countProduct(skus, PRODUCT_M);
            long countOfProductN = countProduct(skus, PRODUCT_N);
            long countOfProductO = countProduct(skus, PRODUCT_O);
            long countOfProductP = countProduct(skus, PRODUCT_P);
            long countOfProductQ = countProduct(skus, PRODUCT_Q);
            long countOfProductR = countProduct(skus, PRODUCT_R);
            long countOfProductS = countProduct(skus, PRODUCT_S);
            long countOfProductT = countProduct(skus, PRODUCT_T);
            long countOfProductU = countProduct(skus, PRODUCT_U);
            long countOfProductV = countProduct(skus, PRODUCT_V);
            long countOfProductW = countProduct(skus, PRODUCT_W);
            long countOfProductX = countProduct(skus, PRODUCT_X);
            long countOfProductY = countProduct(skus, PRODUCT_Y);
            long countOfProductZ = countProduct(skus, PRODUCT_Z);


            countOfProductB = processFreeGift( countOfProductE, 2, countOfProductB);
            countOfProductM = processFreeGift( countOfProductN, 3, countOfProductM);
            countOfProductQ = processFreeGift( countOfProductR, 3, countOfProductQ);

            countOfProductF = processBOGOff(countOfProductF, 2 );
            countOfProductU = processBOGOff(countOfProductU, 3 );



            checkoutTotal = priceProduct(countOfProductA, UNIT_PRICE_A, MULTIBUYS_A )
                    + priceProduct(countOfProductB, UNIT_PRICE_B, MULTIBUYS_B )
                    + priceProduct(countOfProductC, UNIT_PRICE_C, NO_MULTIBUYS )
                    + priceProduct(countOfProductD, UNIT_PRICE_D, NO_MULTIBUYS )
                    + priceProduct(countOfProductE, UNIT_PRICE_E, NO_MULTIBUYS )
                    + priceProduct(countOfProductF, UNIT_PRICE_F, NO_MULTIBUYS )
                    + priceProduct(countOfProductG, UNIT_PRICE_G, NO_MULTIBUYS )
                    + priceProduct(countOfProductH, UNIT_PRICE_H, MULTIBUYS_H )
                    + priceProduct(countOfProductI, UNIT_PRICE_I, NO_MULTIBUYS )
                    + priceProduct(countOfProductJ, UNIT_PRICE_J, NO_MULTIBUYS )
                    + priceProduct(countOfProductK, UNIT_PRICE_K, MULTIBUYS_K )
                    + priceProduct(countOfProductL, UNIT_PRICE_L, NO_MULTIBUYS )
                    + priceProduct(countOfProductM, UNIT_PRICE_M, NO_MULTIBUYS )
                    + priceProduct(countOfProductN, UNIT_PRICE_N, NO_MULTIBUYS )
                    + priceProduct(countOfProductO, UNIT_PRICE_O, NO_MULTIBUYS )
                    + priceProduct(countOfProductP, UNIT_PRICE_P, MULTIBUYS_P )
                    + priceProduct(countOfProductQ, UNIT_PRICE_Q, MULTIBUYS_Q )
                    + priceProduct(countOfProductR, UNIT_PRICE_R, NO_MULTIBUYS )
                    + priceProduct(countOfProductS, UNIT_PRICE_S, NO_MULTIBUYS )
                    + priceProduct(countOfProductT, UNIT_PRICE_T, NO_MULTIBUYS )
                    + priceProduct(countOfProductU, UNIT_PRICE_U, NO_MULTIBUYS )
                    + priceProduct(countOfProductV, UNIT_PRICE_V, MULTIBUYS_V )
                    + priceProduct(countOfProductW, UNIT_PRICE_W, NO_MULTIBUYS )
                    + priceProduct(countOfProductX, UNIT_PRICE_X, NO_MULTIBUYS )
                    + priceProduct(countOfProductY, UNIT_PRICE_Y, NO_MULTIBUYS )
                    + priceProduct(countOfProductZ, UNIT_PRICE_Z, NO_MULTIBUYS )
                    ;

            ////////////////////////////
            // process group discount
            long groupDiscounts = (countOfProductS + countOfProductT + countOfProductX + countOfProductY + countOfProductZ) / 3;
            if( groupDiscounts > 0 ){
                checkoutTotal = checkoutTotal - ((int)(groupDiscounts*45));
            }
        }

        return checkoutTotal;
    }

    private long processFreeGift( long prodA, long threshold, long targetProd ){
        long countFreeGifts = prodA / threshold;
        if( countFreeGifts > 0 ){
            targetProd = targetProd - countFreeGifts;
        }
        return targetProd;
    }

    private long processBOGOff( long prodA, long threshold ){
        long countFreeGifts = prodA / (threshold+1);
        if( countFreeGifts > 0 ){
            prodA = prodA - countFreeGifts;
        }
        return prodA;
    }

    public long countProduct( String skus, final int productId ){
        return skus.chars()
                .filter(ch->ch==productId)
                .count();
    }

    private long countInvalidProducts( String skus ){
        return skus.chars()
                .filter(ch->"ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(ch)==-1 )
                .count();
    }

    public Integer priceProduct( long count , Integer unitPrice, Map<Integer,Integer> multiBuys ){
        Integer price = Integer.valueOf(0);

        int iCount = (int)count;

        if( count > 0 ){
            if( !multiBuys.isEmpty() ){

                Integer[] intKeys = multiBuys.keySet().toArray(new Integer[]{});
                Arrays.sort(intKeys, Collections.reverseOrder());

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
