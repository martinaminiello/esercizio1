package org.example;

import net.jqwik.api.*;
import net.jqwik.api.constraints.DoubleRange;

import net.jqwik.api.statistics.Histogram;
import net.jqwik.api.statistics.Statistics;
import net.jqwik.api.statistics.StatisticsReport;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



public class ConcatenateMethodPBT {

    @Property
@Report(Reporting.GENERATED)
    @StatisticsReport(format = Histogram.class)
    void concatenatedArrayContainsAllElements(@ForAll List<@DoubleRange(min = -Double.MAX_VALUE/1E1, max = Double.MAX_VALUE/1E1) Double> arrays) {
        ConcatenateMethod prova= new ConcatenateMethod();
        double[] arr =convertListToArray(arrays);
        double[] result=prova.concatenate(arr);

                assertThat(result).contains(arr);


        String range=new String("vuoto");
        if(arr.length==0){
            range="empty";
        }

        else if(arr.length==1){
            range="singleElement";
        }
        else if (arr.length>1 && arr.length<=5){
            range="shortArray";
        }
        else if (arr.length>5 && arr.length<=25){
            range="mediumArray";
        }
        else if (arr.length>25){
            range="longArray";
        }

        Statistics.collect(range);
        Statistics.coverage(coverage -> {
            coverage.check("empty").count(c -> c >= 10);
            coverage.check("singleElement").count(c -> c >= 10);
            coverage.check("shortArray").count(c -> c >=50 );

        });


    }



    public static double[] convertListToArray(List<Double> list) {
        double[] array = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}




