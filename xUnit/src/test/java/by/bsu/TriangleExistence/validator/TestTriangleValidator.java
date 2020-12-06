package by.bsu.TriangleExistence.validator;


import by.bsu.TriangleExistence.exception.TriangleException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class TestTriangleValidator {
    TriangleValidator triangleValidator = new TriangleValidator();

    @DataProvider
    public Object[][] positiveCase() {
        return new Object[][]{
                {5, 6, 9},
                {7, 8, 3},
                {6, 11, 15}
        };
    }
    @Test(dataProvider = "positiveCase")
    public void testCheckTrianglePossiblePositiveCase(double sideA, double sideB, double sideC) throws Exception {
        assertTrue(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] negativeCase() {
        return new Object[][]{
                {5, 6, 49},
                {78, 8, 23},
                {6, 151, 15}
        };
    }
    @Test(dataProvider = "negativeCase")
    public void testCheckTrianglePossibleNegativeCase(double sideA, double sideB, double sideC) throws Exception {
        assertFalse(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] negativeSide() {
        return new Object[][]{
                {-5, 3, 9},
                {7, 8, -3},
                {6, 6, -8}
        };
    }
    @Test(dataProvider = "negativeSide",
            expectedExceptions = TriangleException.class,
            expectedExceptionsMessageRegExp = "Error. Length of the side of a triangle must be more than 0" )
    public void testCheckTrianglePossibleNegativeSide(double sideA, double sideB, double sideC) throws Exception {
        triangleValidator.checkTrianglePossible(sideA, sideB, sideC);
    }

    @DataProvider
    public Object[][] zeroSide() {
        return new Object[][]{
                {5, 0, 9},
                {0, 8, 3},
                {6, 16, 0}
        };
    }
    @Test(dataProvider = "zeroSide",
            expectedExceptions = TriangleException.class,
            expectedExceptionsMessageRegExp = "Error. Length of the side of a triangle must be more than 0" )
    public void testCheckTrianglePossibleZeroSide(double sideA, double sideB, double sideC) throws Exception {
        triangleValidator.checkTrianglePossible(sideA, sideB, sideC);
    }

    @DataProvider
    public Object[][] egyptianTriangle() {
        return new Object[][]{
                {3, 4, 5},
                {1.5, 2, 2.5}
        };
    }

    @Test(dataProvider = "egyptianTriangle")
    public void testCheckTriangleEgyptian(double sideA, double sideB, double sideC) throws Exception {
        assertTrue(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] incorrectSides() {
        return new Object[][]{
                {3, Double.NaN, 5},
                {3, 12, Float.NaN},
        };
    }
    @Test(dataProvider = "incorrectSides",
            expectedExceptions = TriangleException.class,
            expectedExceptionsMessageRegExp = "Error. A side of a triangle mustn't be NaN" )
    public void testCheckTriangleIncorrectSides(double sideA, double sideB, double sideC) throws Exception {
        triangleValidator.checkTrianglePossible(sideA, sideB, sideC);
    }

    @DataProvider
    public Object[][] bigSides() {
        return new Object[][]{
                {Float.MAX_VALUE, Float.MAX_VALUE - 15, Float.MAX_VALUE - 1},
                {Float.MAX_VALUE + 100, Float.MAX_VALUE / 2, Float.MAX_VALUE + 18}
        };
    }
    @Test(dataProvider = "bigSides")
    public void testCheckTriangleBigSides(double sideA, double sideB, double sideC) throws Exception {
        assertTrue(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] smallSides() {
        return new Object[][]{
                {Float.MIN_VALUE * 3, Float.MIN_VALUE * 4, Float.MIN_VALUE * 5},
                {0.000003, 0.000004, 0.000005}
        };
    }
    @Test(dataProvider = "smallSides")
    public void testCheckTriangleSmallSides(double sideA, double sideB, double sideC) throws Exception {
        assertTrue(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] specialIgnoreCase() {
        return new Object[][]{
                {777, 777, 777},
                {555, 555, 555},
                {333, 333, 333}
        };
    }
    @Ignore("special case")
    @Test(dataProvider = "specialIgnoreCase")
    public void testCheckTriangleSpecialIgnoreCase(double sideA, double sideB, double sideC) throws Exception {
        assertTrue(triangleValidator.checkTrianglePossible(sideA, sideB, sideC));
    }

    @DataProvider
    public Object[][] tooBigSides() {
        return new Object[][]{
                {Double.MAX_VALUE, Double.MAX_VALUE - 15, Double.MAX_VALUE - 1},
                {Double.MAX_VALUE + 100, Double.MAX_VALUE / 2, Double.MAX_VALUE + 18}
        };
    }
    @Test(dataProvider = "tooBigSides",
            expectedExceptions = TriangleException.class,
            expectedExceptionsMessageRegExp = "Error. A side is too big")
    public void testCheckTriangleTooBigSides(double sideA, double sideB, double sideC) throws Exception {
        triangleValidator.checkTrianglePossible(sideA, sideB, sideC);
    }
}
