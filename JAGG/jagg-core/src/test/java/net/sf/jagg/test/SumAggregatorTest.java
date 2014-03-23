package net.sf.jagg.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

import net.sf.jagg.AggregateValue;
import net.sf.jagg.Aggregations;
import net.sf.jagg.Aggregator;
import net.sf.jagg.SumAggregator;
import net.sf.jagg.test.model.Record;

/**
 * Tests the <code>SumAggregator</code>.
 *
 * @author Randy Gettman
 * @since 0.3.0
 */
public class SumAggregatorTest
{
   /**
    * Test the summation functionality.
    */
   @Test
   public void testByProperty()
   {
      List<Record> records = TestUtility.getTestData();

      List<String> properties = Arrays.asList("category1", "category2");
      Aggregator agg1 = new SumAggregator("value1");
      Aggregator agg2 = new SumAggregator("value2");
      List<Aggregator> aggs = Arrays.asList(agg1, agg2);

      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
         properties, aggs);

      assertEquals(7, recordAggValues.size());

      List<String> cats1 = Arrays.asList("AAA", "AAA", "BBB", "BBB", "CCC", "CCC", "CCC");
      List<Integer> cats2 = Arrays.asList(1, 2, 1, 2, 1, 2, 3);
      List<Double> values1 = Arrays.asList(51.0, 1037.0, 2279.0, 1550.0, 10.0, 21.0, 15.0);
      List<Double> values2 = Arrays.asList(13.69787, 364.57, 69.0, 371.25, 24.0, 55.0, 69.0);

      for (int i = 0; i < recordAggValues.size(); i++)
      {
         AggregateValue<Record> aggValue = recordAggValues.get(i);
         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
         assertEquals(cats2.get(i), aggValue.getPropertyValue(1));
         assertEquals(values1.get(i), ((Number) aggValue.getAggregateValue(agg1)).doubleValue(), Math.abs(TestUtility.DELTA * values1.get(i)));
         assertEquals(values2.get(i), ((Number) aggValue.getAggregateValue(agg2)).doubleValue(), Math.abs(TestUtility.DELTA * values2.get(i)));
      }
   }

   /**
    * Another test.
    */
   @Test
   public void testSomeNull()
   {
      List<Record> records = TestUtility.getSomeNullData();

      List<String> properties = Arrays.asList("category1");

      Aggregator agg1 = new SumAggregator("value1");
      Aggregator agg2 = new SumAggregator("value2");
      List<Aggregator> aggs = Arrays.asList(agg1, agg2);

      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
         properties, aggs);

      assertEquals(3, recordAggValues.size());

      List<Double> values1 = Arrays.asList(6.0, 9.0, 6.0);
      List<Double> values2 = Arrays.asList(6.8, 10.1, 6.8);

      for (int i = 0; i < recordAggValues.size(); i++)
      {
         AggregateValue<Record> aggValue = recordAggValues.get(i);
         assertEquals(values1.get(i), ((Number) aggValue.getAggregateValue(0)).doubleValue(), Math.abs(TestUtility.DELTA * values1.get(i)));
         assertEquals(values2.get(i), ((Number) aggValue.getAggregateValue(1)).doubleValue(), Math.abs(TestUtility.DELTA * values2.get(i)));
      }
   }

   /**
    * Tests the merge functionality.
    */
   @Test
   public void testMerge()
   {
      SumAggregator agg1 = new SumAggregator(".");
      SumAggregator agg2 = new SumAggregator(".");
      agg1.init();
      agg2.init();

      agg1.iterate(2);
      agg2.iterate(3);
      agg1.iterate(11);
      agg2.iterate(5);

      agg1.merge(agg2);
      double sum = 21;
      assertEquals(sum, agg1.terminate(), Math.abs(TestUtility.DELTA * sum));
   }
}