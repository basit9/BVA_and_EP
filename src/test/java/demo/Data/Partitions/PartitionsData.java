package demo.Data.Partitions;

import demo.Data.DataProvider;
import demo.Models.QueryParamData;
import java.util.stream.Stream;

public class PartitionsData implements DataProvider {
    @Override
    public Stream<QueryParamData> getData() {
        return Stream.of(
                new QueryParamData("age", 10),
                new QueryParamData("age", 25),
                new QueryParamData("age", 60)
        );
    }
}

