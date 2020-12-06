package by.bsu.TriangleExistence.validator;

import by.bsu.TriangleExistence.exception.TriangleException;

import java.util.Arrays;
import java.util.Collections;

public class TriangleValidator {
    public boolean checkTrianglePossible(double sideA, double sideB, double sideC) throws TriangleException {
        if (Double.isNaN(sideA) || Double.isNaN(sideB) || Double.isNaN(sideC)){
            throw new TriangleException("Error. A side of a triangle mustn't be NaN");
        }
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new TriangleException("Error. Length of the side of a triangle must be more than 0");
        }
        if (sideA == Double.MAX_VALUE || sideB == Double.MAX_VALUE || sideC == Double.MAX_VALUE){
            throw new TriangleException("Error. A side is too big");
        }
        return 2 * Collections.max(Arrays.asList(sideA, sideB, sideC)) < sideA + sideB + sideC;
    }
}
