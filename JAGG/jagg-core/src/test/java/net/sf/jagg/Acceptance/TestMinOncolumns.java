package net.sf.jagg.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import net.sf.jagg.AggregateValue;
import net.sf.jagg.Aggregations;
import net.sf.jagg.Aggregator;
import net.sf.jagg.MinAggregator;
import net.sf.jagg.test.model.Record;

public class TestMinOncolumns {
	@Test
	  public void testOnColumn1()
	   {
	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category1");
	      Aggregator agg = new MinAggregator("value1");
	      List<Aggregator> aggs = Arrays.asList(agg);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(3, recordAggValues.size());

	      List<String> cats1 = Arrays.asList("AAA", "BBB","CCC");
	      List<Double> values = Arrays.asList(1.0, 5.0, 1.0);

	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
	         assertEquals(values.get(i).intValue(),
	            ((Number) aggValue.getAggregateValue(0)).intValue());
	      }
	   }
	
	@Test
	  public void testOnColumn2()
	   {
	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category4");
	      Aggregator agg = new MinAggregator("value1");
	      List<Aggregator> aggs = Arrays.asList(agg);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(3, recordAggValues.size());

	      List<String> cats1 = Arrays.asList("baseball", "basketball","football");
	      List<Double> values = Arrays.asList(1.0, 3.0, 1.0);

	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
	         assertEquals(values.get(i).intValue(),
	            ((Number) aggValue.getAggregateValue(0)).intValue());
	      }
	   }
	@Test
	  public void testOnColumn3()
	   {
	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category3");
	      Aggregator agg = new MinAggregator("value1");
	      List<Aggregator> aggs = Arrays.asList(agg);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(5, recordAggValues.size());

	      List<String> cats1 = Arrays.asList("abcd", "efgh","ijk","yyy","zzz");
	      List<Double> values = Arrays.asList(1.0, 1.0,1.0,5.0, 1.0);

	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
	         assertEquals(values.get(i).intValue(),
	            ((Number) aggValue.getAggregateValue(0)).intValue());
	      }
	   }
}
