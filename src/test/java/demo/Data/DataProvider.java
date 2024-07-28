package demo.Data;

import demo.Models.QueryParamData;
import java.util.stream.Stream;

public interface DataProvider {
    Stream<QueryParamData> getData();
}
