package leave.nucleus.streams;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTests {

    @Test
    public void printNumbers() {
        IntStream.range(1, 11).forEach(System.out::print);
        IntStream.range(11, 21).forEach(x -> System.out.print(x));
        IntStream.rangeClosed(1,10).forEach(System.out::print);
    }

    @Test
    public void sumNumbers() {
        System.out.println(IntStream.range(1, 5).sum());
    }

    @Test
    public void printAlphabeticallyOrderedName() {
        System.out.println(Stream.of("Apurve","Apoorva","Apurva","Apoorv").sorted().findFirst());

        Stream.of("Apurve","Apoorva","Apurva","Apoorv").sorted().findFirst().ifPresent(System.out::println);

        // filter, sort, print first
        Stream.of("Apurve","Apoorva","Apurva","Apoorv").filter(s->s.endsWith("a")).sorted().findFirst().ifPresent(System.out::println);
    }

    @Test
    public void printAverageOfSquares() {
        IntStream.rangeClosed(1,5).map(x->x*2).forEach(System.out::print);

        IntStream.rangeClosed(1,5).map(x->x*2).average().ifPresent(System.out::print);
    }

    @Test
    public void sortAndFilterString(){
        List<String> l= Arrays.asList("Anjli", "Aprrove" , "Apurve", "Sss");
        l.stream().filter(a-> a.startsWith("A")).map(String::toLowerCase).forEach(System.out::print);
    }

    @Test
    public void readFromFileSortAndFilter() throws IOException {
        Files.lines(Paths.get("C:\\Users\\Apurve Gupta\\Desktop\\application.log")).filter(str -> str.startsWith("Caused by")).forEach(System.out::println);
    }

    List<String> dataSet = null;

    @Before
    public void initializeDataSet() {
        dataSet = Arrays.asList("A,12,3.7", "B,17,2.8", "C,14,1.9", "D,23,2.7", "E", "F,18,3.4");
    }

    @Test
    public void collectDataSetToMap() {
        Stream<String> rows = dataSet.stream();
        Map<String, String> map = rows.map(row -> row.split(","))
                .filter(row -> row.length==3)
                .collect(Collectors.toMap(row -> row[0], row -> row[1]+row[2]));

        for(Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    @Test
    public void sumOfDoubleValues() {
        double sum = Stream.of(13.2,123.23,21.544).reduce(0.0, (Double a, Double b) -> {return a+b;});
        System.out.println(sum);
    }

    @Test
    public void testSummaryStatistics() {
        DoubleSummaryStatistics statistics = DoubleStream.of(13.2, 123.23, 21.544).summaryStatistics();
        System.out.println(statistics);
    }
}
