package org.example;

import com.amazonaws.services.kinesis.model.InvalidArgumentException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ConcatenateMethodTest {

    //explorative tests
    @Test
    public void singleValue() throws Exception {
        ConcatenateMethod prova= new ConcatenateMethod();
        double[] a = {8.88};
        double[] b = {3};
        double[] result = {8.88, 3};
        assertThat(prova.concatenate(a, b)).isEqualTo(result);
    }

    @Test
    public void multipleValues() throws Exception {
        ConcatenateMethod prova= new ConcatenateMethod();
        double[] a = {-36, 8.88, 9.3};
        double[] b = {3, 5, 0, 45.3335};
        double[] result = {-36, 8.88, 9.3, 3, 5, 0, 45.3335};
        assertThat(prova.concatenate(a, b)).isEqualTo(result);

    }

    //T1, T2
    @Test
    public void nullArray() throws NullPointerException {
        ConcatenateMethod prova= new ConcatenateMethod();
        double[] a = {1,2,3};

        Assertions.assertAll(
                ()->Assert.assertThrows(NullPointerException.class, () -> prova.concatenate(null)), // come unico argomento
                ()-> Assert.assertThrows(NullPointerException.class, () -> prova.concatenate(a,null))); // tra gli argomenti
    }

    // T3, T4, T5
    @Test
    public void emptyArray() throws Exception {
        ConcatenateMethod prova= new ConcatenateMethod();
        double[] a = {0,1,2};
        double[] b = {};
        double[] c = {};
        double[] result = {};

        Assertions.assertAll(
                ()->assertThat(prova.concatenate()).isEqualTo(result), // T2
                ()->assertThat(prova.concatenate(a, b, c)).isEqualTo(a), // T3
                ()->assertThat(prova.concatenate(b, c)).isEqualTo(result) // T4
        );
    }

    //T6
    @Test
    public void differentFormat() throws Exception {
        ConcatenateMethod prova= new ConcatenateMethod();
        double[] a = {3.0d}; // T5
        double[] b = {3.6f}; // T6
        double[] c = {2}; // T7
        double[] d = {-2, -8.88}; // T8
        double[] e = {3.00000005}; // T9

        double[] result = {3.0d, 3.6f, 2, -2, -8.88, 3.00000005};
        assertThat(prova.concatenate(a,b,c,d,e)).isEqualTo(result);
    }

    //T7
    @Test
    public void scientificNotation() throws Exception {
        ConcatenateMethod prova= new ConcatenateMethod();
        double[] a = {1,2,3};
        double[] b = {3.0E90};
        double[] result = {1,2,3,3.0E90};

        assertThat(prova.concatenate(a,b)).isEqualTo(result);
    }



    /*T8
    @Test
    public void invalidArray() throws Exception {
        ConcatenateMethod prova= new ConcatenateMethod();
        double[] a = {1,2,3};
        double[] b = {'a','b','='};

        Assert.assertThrows(InvalidArgumentException.class, () -> prova.concatenate(a,b));
    }*/



    //T9, T10, T11
    @Test
    public void boundaryCases() throws Exception {
        ConcatenateMethod prova= new ConcatenateMethod();
        double[] a = {Double.MAX_VALUE/1E1};//ON POINT
        double[] b = {-Double.MAX_VALUE/1E1};//ON POINT
        double[] c = {Double.MAX_VALUE};//OFF POINT
        double[] d = {-Double.MAX_VALUE};//OFF POINT
        double[] f = {1,2,3};

        double[] result = {Double.MAX_VALUE/1E1,-Double.MAX_VALUE/1E1};

        Assertions.assertAll(
                ()->assertThat(prova.concatenate(a,b)).isEqualTo(result),
                ()->Assert.assertThrows(InvalidArgumentException.class, () -> prova.concatenate(c,f)),
                ()->Assert.assertThrows(InvalidArgumentException.class, () -> prova.concatenate(d,f)));

    }
//T12, T13
    @Test
    public void Infinity() throws Exception {
        ConcatenateMethod prova= new ConcatenateMethod();
        double[] a = {Double.POSITIVE_INFINITY};
        double[] c = {Double.NEGATIVE_INFINITY};
        double[] f = {1,2,3};



        Assertions.assertAll(
                ()->Assert.assertThrows(InvalidArgumentException.class, () -> prova.concatenate(a,f)),
                ()->Assert.assertThrows(InvalidArgumentException.class, () -> prova.concatenate(c,f)));

    }




}
