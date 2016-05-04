package pl.edu.agh.tk;

import pl.edu.agh.tk.converters.JSONToCSVConverter;
import pl.edu.agh.tk.converters.POJOToCSVConverter;

import java.io.IOException;
import java.util.List;


public class ToCSVConverter
{
    public static void convertFromPOJO(String id, List<? extends Number> dataList, String columnName) throws IOException {
        POJOToCSVConverter.convertSimplePOJO(id, dataList, columnName);
    }

    public static void convertFromPOJO(String id, List<List<? extends Number>> listOfDataRows, List<String> columnNames) throws IOException {
        POJOToCSVConverter.convertMultiRowPOJO(id , listOfDataRows, columnNames);
    }

    public static void convertFromJSON(String json) throws IOException {
        JSONToCSVConverter.convertJSON(json);
    }
}