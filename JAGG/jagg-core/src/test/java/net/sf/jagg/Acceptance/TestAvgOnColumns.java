package net.sf.jagg.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import net.sf.jagg.AggregateValue;
import net.sf.jagg.Aggregations;
import net.sf.jagg.Aggregator;
import net.sf.jagg.AvgAggregator;
import net.sf.jagg.test.model.Record;

import org.junit.Test;

public class TestAvgOnColumns {
	   @Test
	   public void testByProperty()
	   {
	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category4");
	      Aggregator agg1 = new AvgAggregator("value1");
	      List<Aggregator> aggs = Arrays.asList(agg1);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(3, recordAggValues.size());

	      List<Double> values1 = Arrays.asList(253.375, 321.1111111111111, 3.066666666666667);
	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(values1.get(i), ((Number) aggValue.getAggregateValue(agg1)).doubleValue(), Math.abs(TestUtility.DELTA * values1.get(i)));
	      }
	   }
	   @Test
	   public void testByProperty2()
	   {
	      List<Record> records = TestUtility.getTestData();

	      List<String> properties = Arrays.asList("category3");
	      Aggregator agg1 = new AvgAggregator("value1");
	      List<Aggregator> aggs = Arrays.asList(agg1);

	      List<AggregateValue<Record>> recordAggValues = Aggregations.groupBy(records,
	         properties, aggs);

	      assertEquals(5, recordAggValues.size());

	      List<Double> values1 = Arrays.asList(2.5, 3.5, 3.0,255.0,327.75);
	      for (int i = 0; i < recordAggValues.size(); i++)
	      {
	         AggregateValue<Record> aggValue = recordAggValues.get(i);
	         assertEquals(values1.get(i), ((Number) aggValue.getAggregateValue(agg1)).doubleValue(), Math.abs(TestUtility.DELTA * values1.get(i)));
	      }
	   }
}
