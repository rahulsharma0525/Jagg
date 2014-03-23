package net.sf.jagg.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

import net.sf.jagg.AggregateValue;
import net.sf.jagg.Aggregations;
import net.sf.jagg.Aggregator;
import net.sf.jagg.ModeAggregator;

/**
 * Tests the <code>ModeAggregator</code>.
 *
 * @author Randy Gettman
 * @since 0.6.0
 */
public class ModeAggregatorTest
{
   /**
    * Test the collection functionality.
    */
   @Test
   public void testByProperty()
   {
      List<String> records = Arrays.asList("", "aggregator", "mode", "test", "mode",
         "list", "mode", "test", "test", "mode", "aggregator");

      List<String> properties = new ArrayList<String>(0);
      Aggregator aggMode = new ModeAggregator(".");
      List<Aggregator> aggs = Arrays.asList(aggMode);

      List<AggregateValue<String>> recordAggValues = Aggregations.groupBy(records,
         properties, aggs);

      assertEquals(1, recordAggValues.size());
      assertEquals("mode", recordAggValues.get(0).getAggregateValue(0));
   }

   /**
    * Tests when no items are iterated.
    */
   @Test
   public void testNulls()
   {
      List<String> records = new ArrayList<String>(3);
      records.add(null);
      records.add(null);
      records.add(null);

      List<String> properties = new ArrayList<String>(0);
      Aggregator aggMode = new ModeAggregator(".");
      List<Aggregator> aggs = Arrays.asList(aggMode);

      List<AggregateValue<String>> recordAggValues = Aggregations.groupBy(records,
         properties, aggs);

      assertEquals(1, recordAggValues.size());
      assertNull(recordAggValues.get(0).getAggregateValue(0));
   }

   /**
    * Tests the merge functionality.
    */
   @Test
   public void testMerge()
   {
      ModeAggregator agg1 = new ModeAggregator(".");
      ModeAggregator agg2 = new ModeAggregator(".");
      agg1.init();
      agg2.init();

      // 1: 1, 2, 3, 2, 1, 2 (2 1s, 3 2s, 1 3) (2)
      // 2: 1, 4, 3, 4, 1, 4 (2 1s, 1 3, 3 4s) (4)
      // m: (4 1s, 3 2s, 2 3s, 3 4s) (1)
      agg1.iterate("1");
      agg2.iterate("2");
      agg1.iterate("4");
      agg2.iterate("3");
      agg1.iterate("3");
      agg2.iterate("1");
      agg1.iterate("4");
      agg2.iterate("2");
      agg1.iterate("1");
      agg2.iterate("1");
      agg1.iterate("2");
      agg2.iterate("4");

      agg1.merge(agg2);

      Comparable value = agg1.terminate();
      assertTrue(value instanceof String);
      assertEquals("1", value);
   }
}