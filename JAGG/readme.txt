jAgg - Java Aggregation Operations
----------------

jAgg can be found online at http://jagg.sourceforge.net.

Description
----------------

jAgg is Java Aggregation Operations.  Give it a list of your own objects,
specify some aggregate operations, specify any "group-by" properties, and get
back a list of AggregateValues that wrap your objects and hold the aggregate
values.  You can even create your own custom aggregate operations.

Example
----------------

Here is a quick example of how to use jAgg:

List<YourRecord> records = getFromYourOwnDataSource();
Aggregation agg = new Aggregation.Builder()
   .setProperties(Arrays.asList("prop1", "prop2"))
   .setAggregators(Arrays.asList(new SumAggregator("value1"),
                                 new AvgAggregator("value2")))
   .build();
List<AggregateValue<YourRecord>> aggValues = agg.groupBy(records);

System.out.println("Prop1,Prop2,Sum(Value1),Avg(Value2)");
for (AggregateValue<YourRecord> aggValue : aggValues)
{
   System.out.println(aggValue.getPropertyValue(0) +
                "," + aggValue.getPropertyValue(1) +
                "," + aggValue.getAggregateValue(0) +
                "," + aggValue.getAggregateValue(1));
}

Installation
----------------

To use jAgg, you may download the latest distribution from
http://sourceforge.net/projects/jagg/files/.  The only module is "jagg-core".
Place the "jagg-core" jar library in your classpath.

If you are using Maven 2+, then you may place the following dependency in your
pom.xml.  Since 0.6.0, jAgg has been available in the Maven 2 Central
Repository.

<dependency>
    <groupId>net.sf.jagg</groupId>
    <artifactId>jagg-core</artifactId>
    <version>0.7.1</version>
</dependency>

Dependencies
----------------

jAgg has no external dependencies, but it does rely on JUnit 4.8.2 for JUnit
test cases when building through Maven.  jAgg can be used with Java 1.5+.

Build Instructions
----------------

If you would like to build jAgg yourself, do the following:
1. Get the source code.
  a. Download the jAgg latest distribution from
     http://sourceforge.net/projects/jagg/files/.
     This contains the source code from the latest release.
  OR
  b. Checkout the latest source code from the trunk using Subversion using the
     Subversion URL http://jagg.svn.sourceforge.net/svnroot/jagg/trunk.

2. Get Maven 2 or higher from http://maven.apache.org/ and install it.

3. Run Maven to build jAgg.
   mvn clean install

Contacts
----------------

For issues, bugs, suggestions, and feature requests, please send an email to
the "jagg-users" mailing list: jagg-users@lists.sourceforge.net.

Licensing
----------------

jAgg is licensed under the "GNU Lesser General Public License Version 3" at
http://www.gnu.org/copyleft/lesser.html.

Author
----------------

My name is Randy Gettman.  I created jAgg after I learned how to create custom
aggregate functions in Oracle databases.  My first custom aggregate function in
Oracle was a function to multiply all incoming numbers together to create a
product of all values, like jAgg's ProductAggregator.  I wanted to accomplish
the same thing in Java, and jAgg is the result.