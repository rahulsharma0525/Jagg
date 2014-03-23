package net.sf.jagg.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

import net.sf.jagg.AggregateValue;
import net.sf.jagg.Aggregations;
import net.sf.jagg.Aggregator;
import net.sf.jagg.CovariancePopAggregator;
import net.sf.jagg.test.model.Record;

/**
 * Tests the <code>CovariancePopAggregator</code>.
 *
 * @author Randy Gettman
 * @since 0.3.0
 */
public class CovariancePopAggregatorTest
{
   /**
    * Test the population covariance functionality.
    */
   @Test
   public void testByProperty()
   {
      List<Record> records = TestUtility.getTestData();

      List<String> properties = Arrays.asList("category1", "category2");
      Aggregator agg1 = new CovariancePopAggregator("value1", "value2");
      List<Aggregator> aggs = Arrays.asList(agg1);

      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
         properties, aggs);

      assertEquals(7, recordAggValues.size());

      List<String> cats1 = Arrays.asList("AAA", "AAA", "BBB", "BBB", "CCC", "CCC", "CCC");
      List<Integer> cats2 = Arrays.asList(1, 2, 1, 2, 1, 2, 3);
      List<Double> values1 = Arrays.asList( -0.911328125,
                                        -15686.328125,
                                         -4011.25,
                                          4350.0,
                                             3.25,
                                            11.41666666666666666666666666667,
                                            21.4);

      for (int i = 0; i < recordAggValues.size(); i++)
      {
         AggregateValue<Record> aggValue = recordAggValues.get(i);
         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
         assertEquals(cats2.get(i), aggValue.getPropertyValue(1));
         assertEquals(values1.get(i), ((Number) aggValue.getAggregateValue(agg1)).doubleValue(), Math.abs(TestUtility.DELTA * values1.get(i)));
      }
   }
}