package net.sf.jagg.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import net.sf.jagg.AggregateValue;
import net.sf.jagg.Aggregations;
import net.sf.jagg.Aggregator;
import net.sf.jagg.MaxAggregator;
import net.sf.jagg.test.model.Record;

import org.junit.Test;

public class TestMaxOnColumns {
	@Test
	   public void testByProperty()
	   {
	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category1", "category2");
	      Aggregator agg = new MaxAggregator("value2");
	      List<Aggregator> aggs = Arrays.asList(agg);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(7, recordAggValues.size());

	      List<String> cats1 = Arrays.asList("AAA", "AAA", "BBB", "BBB", "CCC", "CCC", "CCC");
	      List<Integer> cats2 = Arrays.asList(1, 2, 1, 2, 1, 2, 3);
	      List<Double> values = Arrays.asList(6.5, 201.5, 30.25, 110.25, 10.0, 23.0, 54.0);

	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
	         assertEquals(cats2.get(i), aggValue.getPropertyValue(1));
	         assertEquals(values.get(i).intValue(),
	            ((Number) aggValue.getAggregateValue(0)).intValue());
	      }
	   }
	
	@Test
	   public void testColumn2()
	   {
	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category4", "category2");
	      Aggregator agg = new MaxAggregator("value2");
	      List<Aggregator> aggs = Arrays.asList(agg);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(7, recordAggValues.size());

	      List<String> cats1 = Arrays.asList("baseball","baseball","basketball","basketball", "football","football","football");
	      List<Integer> cats2 = Arrays.asList(1, 2, 1, 2, 1, 2, 3);
	      List<Double> values = Arrays.asList(20.25, 201.5, 30.25, 110.25, 10.0, 23.0, 54.0);

	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
	         assertEquals(cats2.get(i), aggValue.getPropertyValue(1));
	         assertEquals(values.get(i).intValue(),
	            ((Number) aggValue.getAggregateValue(0)).intValue());
	      }
}
	
	@Test
	   public void testColumn3()
	   {
	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category3");
	      Aggregator agg = new MaxAggregator("value2");
	      List<Aggregator> aggs = Arrays.asList(agg);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(5, recordAggValues.size());

	      List<String> cats1 = Arrays.asList("abcd","efgh","ijk","yyy", "zzz");
	      List<Double> values = Arrays.asList(10.0, 23.0, 54.0,110.25,201.5);

	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
	         assertEquals(values.get(i).intValue(),
	            ((Number) aggValue.getAggregateValue(0)).intValue());
	      }


	   }
	@Test
	   public void testColumn4()
	   {
	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category3");
	      Aggregator agg = new MaxAggregator("value1");
	      List<Aggregator> aggs = Arrays.asList(agg);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(5, recordAggValues.size());

	      List<String> cats1 = Arrays.asList("abcd","efgh","ijk","yyy", "zzz");
	      List<Double> values = Arrays.asList(4.0,6.0, 5.0,1005.0,1111.0);

	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
	         assertEquals(values.get(i).intValue(),
	            ((Number) aggValue.getAggregateValue(0)).intValue());
	      }


	   }
}
