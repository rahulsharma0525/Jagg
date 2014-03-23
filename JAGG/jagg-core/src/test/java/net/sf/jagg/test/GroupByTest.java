package net.sf.jagg.test;
/*
 * Added By Rahul For Testing Different combinations of Group by clause
 * 
 * 
 * */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import net.sf.jagg.AggregateValue;
import net.sf.jagg.Aggregations;
import net.sf.jagg.Aggregator;
import net.sf.jagg.CountAggregator;
import net.sf.jagg.test.model.Record;

import org.junit.Test;

public class GroupByTest {

	
	
	  @Test
	   public void testOneColumn()
	   {
	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category1");
	      Aggregator agg = new CountAggregator("value1");
	      List<Aggregator> aggs = Arrays.asList(agg);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(3, recordAggValues.size());

	      List<String> cats1 = Arrays.asList("AAA", "BBB","CCC");
	      List<Integer> values = Arrays.asList(8, 9, 15);

	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
	         assertEquals(values.get(i).intValue(),
	            ((Number) aggValue.getAggregateValue(0)).intValue());
	      }
	   }
	
	  @Test
	   public void testSecondColumn()
	   {
	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category2");
	      Aggregator agg = new CountAggregator("value1");
	      List<Aggregator> aggs = Arrays.asList(agg);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(3, recordAggValues.size());

	      List<Integer> cats1 = Arrays.asList(1, 2,3);
	      List<Integer> values = Arrays.asList(12, 15, 5);

	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
	         assertEquals(values.get(i).intValue(),
	            ((Number) aggValue.getAggregateValue(0)).intValue());
	      }
	   }
	  
	  @Test
	   public void testthirdColumn()
	   {
	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category3");
	      Aggregator agg = new CountAggregator("value1");
	      List<Aggregator> aggs = Arrays.asList(agg);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(5, recordAggValues.size());

	      List<String> cats1 = Arrays.asList("abcd","efgh","ijk","yyy","zzz");
	      List<Integer> values = Arrays.asList(4,6,5,9,8);

	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
	         assertEquals(values.get(i).intValue(),
	            ((Number) aggValue.getAggregateValue(0)).intValue());
	      }
	   }
	  @Test
	   public void testFourthColumn()
	   {
	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category4");
	      Aggregator agg = new CountAggregator("value1");
	      List<Aggregator> aggs = Arrays.asList(agg);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(3, recordAggValues.size());

	      List<String> cats1 = Arrays.asList("baseball","basketball","football");
	      List<Integer> values = Arrays.asList(8,9,15);

	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
	         assertEquals(values.get(i).intValue(),
	            ((Number) aggValue.getAggregateValue(0)).intValue());
	      }
	   }
}
