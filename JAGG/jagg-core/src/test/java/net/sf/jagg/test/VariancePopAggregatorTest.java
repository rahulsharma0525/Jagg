package net.sf.jagg.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

import net.sf.jagg.AggregateValue;
import net.sf.jagg.Aggregations;
import net.sf.jagg.Aggregator;
import net.sf.jagg.VariancePopAggregator;
import static net.sf.jagg.test.TestUtility.*;
import net.sf.jagg.test.model.Record;

/**
 * Tests the <code>VariancePopAggregator</code>.
 *
 * @author Randy Gettman
 * @since 0.3.0
 */
public class VariancePopAggregatorTest
{
   /**
    * Test the population variance functionality.
    */
   @Test
   public void testByProperty()
   {
      List<Record> records = getTestData();

      List<String> properties = Arrays.asList("category1", "category2");
      Aggregator agg1 = new VariancePopAggregator("value1");
      Aggregator agg2 = new VariancePopAggregator("value2");
      List<Aggregator> aggs = Arrays.asList(agg1, agg2);

      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
         properties, aggs);

      assertEquals(7, recordAggValues.size());

      List<String> cats1 = Arrays.asList("AAA", "AAA", "BBB", "BBB", "CCC", "CCC", "CCC");
      List<Integer> cats2 = Arrays.asList(1, 2, 1, 2, 1, 2, 3);
      List<Double> values1 = Arrays.asList( 37.1875,
                                         84899.1875,
                                        238071.6875,
                                        140600.0,
                                             1.25,
                                             2.91666666666666666666666666667,
                                             2.0);
      List<Double> values2 = Arrays.asList(  3.59774181306875,
                                          5146.67066875,
                                            81.0,
                                           580.8,
                                             8.5,
                                            50.80555555555555555555555555556,
                                           405.76);

      for (int i = 0; i < recordAggValues.size(); i++)
      {
         AggregateValue<Record> aggValue = recordAggValues.get(i);
         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
         assertEquals(cats2.get(i), aggValue.getPropertyValue(1));
         assertEquals(values1.get(i), ((Number) aggValue.getAggregateValue(agg1)).doubleValue(), Math.abs(DELTA * values1.get(i)));
         assertEquals(values2.get(i), ((Number) aggValue.getAggregateValue(agg2)).doubleValue(), Math.abs(DELTA * values2.get(i)));
      }
   }
}