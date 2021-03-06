package befaster.solutions.SUM;

import befaster.runner.SolutionNotImplementedException;

import java.util.Optional;

public class SumSolution {

    public int compute(int x, int y) {
        return x + y;
    }

    public Integer sum(Integer i1, Integer i2 ){

        validateInteger(0, Optional.ofNullable(i1) );
        validateInteger(1, Optional.ofNullable(i2) );

        return new Integer( i1.intValue() + i2.intValue() );
    }

    private void validateInteger( int index, Optional<Integer> optInt ){
        if( !optInt.isPresent() ){
            throw new IllegalArgumentException( String.format("parameter %d cannot be null", index ));
        }
        else{
            int iValue = optInt.get().intValue();
            if( iValue < 0 ){
                throw new IllegalArgumentException( String.format("parameter %d (%d) must be greater than or equal to 0", index, iValue ));
            }
            if( iValue > 100 ){
                throw new IllegalArgumentException( String.format("parameter %d (%d) must be less than or equal to 100", index, iValue ));
            }
        }
    }

}
