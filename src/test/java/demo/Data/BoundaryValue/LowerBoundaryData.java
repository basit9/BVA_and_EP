package demo.Data.BoundaryValue;

import demo.Data.DataProvider;
import demo.Models.QueryParamData;
import java.util.stream.Stream;


public class LowerBoundaryData implements DataProvider {
    @Override
    public Stream<QueryParamData> getData() {
        return Stream.of(
                new QueryParamData("age", 17),
                new QueryParamData("age", 18),
                new QueryParamData("age", 19)
        );
    }
}

