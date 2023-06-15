package org.example;

import com.amazonaws.services.kinesis.model.InvalidArgumentException;


public class ConcatenateMethod {
    public  double[] concatenate(double[]... x) throws InvalidArgumentException {

        int combinedLength = 0;


            for (double[] a : x) {
                combinedLength += a.length;



                for (double[] l : x) {

                    for (int n = 0; n < l.length; n++) {

                        if (l[n] < -Double.MAX_VALUE/1E1 || l[n] > Double.MAX_VALUE/1E1) {
                            throw new InvalidArgumentException("Invalid array");
                        }

                    }
                }
            }
        int offset = 0;
        int curLength = 0;
        final double[] combined = new double[combinedLength];
        for (int i = 0; i < x.length; i++) {

            curLength = x[i].length;
            System.arraycopy(x[i], 0, combined, offset, curLength);
            offset += curLength;

        }
        return combined;
    }

}
