package net.sf.jagg.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

import net.sf.jagg.AggregateValue;
import net.sf.jagg.Aggregations;
import net.sf.jagg.Aggregator;
import net.sf.jagg.MinAggregator;
import net.sf.jagg.test.model.Record;

/**
 * Tests the <code>MinAggregator</code>.
 *
 * @author Randy Gettman
 * @since 0.3.0
 */
public class MinAggregatorTest
{
   /**
    * Test the minimum functionality.
    */
   @Test
   public void testByProperty()
   {
      List<Record> records = TestUtility.getTestData();

      List<String> properties = Arrays.asList("category1", "category2");
      Aggregator agg = new MinAggregator("value1");
      List<Aggregator> aggs = Arrays.asList(agg);

      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
         properties, aggs);

      assertEquals(7, recordAggValues.size());

      List<String> cats1 = Arrays.asList("AAA", "AAA", "BBB", "BBB", "CCC", "CCC", "CCC");
      List<Integer> cats2 = Arrays.asList(1, 2, 1, 2, 1, 2, 3);
      List<Double> values = Arrays.asList(7.0, 1.0, 68.0, 5.0, 1.0, 1.0, 1.0);

      for (int i = 0; i < recordAggValues.size(); i++)
      {
         AggregateValue<Record> aggValue = recordAggValues.get(i);
         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
         assertEquals(cats2.get(i), aggValue.getPropertyValue(1));
         assertEquals(values.get(i).intValue(),
            ((Number) aggValue.getAggregateValue(0)).intValue());
      }
   }

   /**
    * Tests the merge functionality.
    */
   @Test
   public void testMerge()
   {
      MinAggregator agg1 = new MinAggregator(".");
      MinAggregator agg2 = new MinAggregator(".");
      agg1.init();
      agg2.init();

      agg1.iterate("blatherskyte");
      agg2.iterate("gobbledygook");
      agg1.iterate("java");
      agg2.iterate("supercalifragilisticexpialadocious");

      agg1.merge(agg2);
      assertEquals("blatherskyte", agg1.terminate());
   }

   /**
    * Tests the merge functionality with respect to <code>null</code> being
    * present.
    * @since 0.7.1
    */
   @Test
   public void testMergeNull()
   {
      Record nullCat1 = new Record(null, 0, "blah", "blah", 0, 0);
      Record imNotNullCat1 = new Record("I'm not null", 0, "blah", "blah", 0, 0);
      MinAggregator agg1 = new MinAggregator("category1");
      MinAggregator agg2 = new MinAggregator("category1");
      agg1.init();
      agg2.init();

      // Both null => null
      agg1.iterate(nullCat1);
      agg2.iterate(nullCat1);
      agg1.merge(agg2);
      assertNull(agg1.terminate());

      // First not null, Second null => first.
      agg1.iterate(imNotNullCat1);
      agg1.merge(agg2);
      assertEquals("I'm not null", agg1.terminate());

      MinAggregator agg3 = new MinAggregator("category1");
      MinAggregator agg4 = new MinAggregator("category1");
      agg3.init();
      agg4.init();

      // First null, Second not null => second.
      agg4.iterate(imNotNullCat1);
      agg3.merge(agg4);
      assertEquals("I'm not null", agg3.terminate());
   }
}