package pl.edu.agh.tk;

import pl.edu.agh.tk.converters.POJOToCSVConverter;

import java.io.IOException;
import java.util.List;

/**
 * ToCSVConverter is a component which allows you to write sets of data to file in csv format.
 *
 * @author  Woźniak Paweł
 * @version 1.0
 */
public class ToCSVConverter
{
    /**
     * This method is used to write list which will contain only one type of data
     * to the specified (@fileName) CSV file.
     * @param fileName Unique file name.
     * @param dataList  List of same-type data.
     * @param columnName  Name of data list @dataList.
     */
    public static void writeToFile(String fileName, List<? extends Number> dataList, String columnName) throws IOException {
        POJOToCSVConverter.getConverter().covertToCSVFile(fileName, dataList, columnName);
    }

    /**
     * This method is used to write set of lists to CSV file, each list will contain only one type of data.
     * @param fileName Unique file name.
     * @param listsOfData  List of same-type data. Each list is a one column.
     * @param columnNames  List of column names, should be same length as @listsOfData.size().
     */
    public static void writeToFile(String fileName, List<List<? extends Number>> listsOfData, List<String> columnNames) throws IOException {
        POJOToCSVConverter.getConverter().covertToCSVFile(fileName , listsOfData, columnNames);
    }

    /**
     * This method is used to write list that will contain only one type of data
     * to the specified (@fileName) CSV file. Each row of data will be enhanced with current timestamp.
     * @param fileName Unique file name.
     * @param dataList  List of same-type data.
     * @param columnName  Name of data list @dataList.
     */
    public static void writeToFileWithTimeStamp(String fileName, List<? extends Number> dataList, String columnName) throws IOException {
        POJOToCSVConverter.getConverter().covertToCSVFileWithTimeStamp(fileName, dataList, columnName);
    }

    /**
     * This method is used to write set of lists to CSV file, each list will contain only one type of data.
     * Each row of data will be enhanced with current timestamp.
     * @param fileName Unique file name.
     * @param listsOfData  List of same-type data. Each list is a one column.
     * @param columnNames  List of column names, should be same length as @listsOfData.size().
     */
    public static void writeToFileWithTimeStamp(String fileName, List<List<? extends Number>> listsOfData, List<String> columnNames) throws IOException {
        POJOToCSVConverter.getConverter().covertToCSVFileWithTimeStamp(fileName , listsOfData, columnNames);
    }
}