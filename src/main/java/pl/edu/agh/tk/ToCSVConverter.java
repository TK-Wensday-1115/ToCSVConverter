package pl.edu.agh.tk;

import pl.edu.agh.tk.converters.POJOToCSVConverter;

import java.io.IOException;
import java.util.List;


public class ToCSVConverter
{
    public static void writeToFile(String fileName, List<? extends Number> dataList, String columnName) throws IOException {
        POJOToCSVConverter.writeToFile(fileName, dataList, columnName);
    }

    public static void writeToFile(String fileName, List<List<? extends Number>> listOfDataRows, List<String> columnNames) throws IOException {
        POJOToCSVConverter.writeToFile(fileName , listOfDataRows, columnNames);
    }

    public static void writeToFileWithTimeStamp(String fileName, List<? extends Number> dataList, String columnName) throws IOException {
        POJOToCSVConverter.writeToFileWithTimeStamp(fileName, dataList, columnName);
    }

    public static void writeToFileWithTimeStamp(String fileName, List<List<? extends Number>> listOfDataRows, List<String> columnNames) throws IOException {
        POJOToCSVConverter.writeToFileWithTimeStamp(fileName , listOfDataRows, columnNames);
    }
}