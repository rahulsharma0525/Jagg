package net.sf.jagg.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import net.sf.jagg.AggregateValue;
import net.sf.jagg.Aggregations;
import net.sf.jagg.Aggregator;
import net.sf.jagg.SumAggregator;
import net.sf.jagg.test.model.Record;

public class TestSumOnColumns {

	@Test
	public void testCol1Sum(){
		

	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category1");
	      Aggregator agg1 = new SumAggregator("value1");
	      List<Aggregator> aggs = Arrays.asList(agg1);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(3, recordAggValues.size());

	      List<String> cats1 = Arrays.asList("AAA", "BBB", "CCC");
	      List<Double> values1 = Arrays.asList(1088.0, 3829.0,46.0);

	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
	         assertEquals(values1.get(i), ((Number) aggValue.getAggregateValue(agg1)).doubleValue(), Math.abs(TestUtility.DELTA * values1.get(i)));
	      }
	   }
	@Test
	public void testCol2Sum(){
		

	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category3");
	      Aggregator agg1 = new SumAggregator("value1");
	      List<Aggregator> aggs = Arrays.asList(agg1);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(5, recordAggValues.size());

	      List<String> cats1 = Arrays.asList("abcd", "efgh", "ijk","yyy","zzz");
	      List<Double> values1 = Arrays.asList(10.0, 21.0,15.0, 2295.0,2622.0);

	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
	         assertEquals(values1.get(i), ((Number) aggValue.getAggregateValue(agg1)).doubleValue(), Math.abs(TestUtility.DELTA * values1.get(i)));
	      }
	   }
	
	@Test
	public void testCol3Sum(){
		

	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category3");
	      Aggregator agg1 = new SumAggregator("value2");
	      List<Aggregator> aggs = Arrays.asList(agg1);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(5, recordAggValues.size());

	      List<String> cats1 = Arrays.asList("abcd", "efgh", "ijk","yyy","zzz");
	      List<Double> values1 = Arrays.asList(24.0, 55.0,69.0, 423.50987,395.008);

	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
	         assertEquals(values1.get(i), ((Number) aggValue.getAggregateValue(agg1)).doubleValue(), Math.abs(TestUtility.DELTA * values1.get(i)));
	      }
	   }

	@Test
	public void testCol4Sum(){
		

	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category1");
	      Aggregator agg1 = new SumAggregator("value2");
	      List<Aggregator> aggs = Arrays.asList(agg1);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(3, recordAggValues.size());

	      List<String> cats1 = Arrays.asList("AAA", "BBB", "CCC");
	      List<Double> values1 = Arrays.asList(378.26787, 440.25,148.0);

	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(cats1.get(i), aggValue.getPropertyValue(0));
	         assertEquals(values1.get(i), ((Number) aggValue.getAggregateValue(agg1)).doubleValue(), Math.abs(TestUtility.DELTA * values1.get(i)));
	      }
	   }
	
	
	
	
	}

