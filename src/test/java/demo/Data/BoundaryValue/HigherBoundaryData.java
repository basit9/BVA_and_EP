package demo.Data.BoundaryValue;

import demo.Data.DataProvider;
import demo.Models.QueryParamData;
import java.util.stream.Stream;

public class HigherBoundaryData implements DataProvider {
    @Override
    public Stream<QueryParamData> getData() {
        return Stream.of(
                new QueryParamData("age", 49),
                new QueryParamData("age", 50),
                new QueryParamData("age", 51)
        );
    }
}
