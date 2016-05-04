package pl.edu.agh.tk.converters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class POJOToCSVConverter implements Converter {

    private static final String CSV_EXTENSION = ".csv";
    private static final String CSV_SEPARATOR = ",";
    private static final String LINE_SEPARATOR = "\n";
    private static final String TIMESTAMP_FORMAT = "yyyyMMddHHmmssSSS";
    private static final String OUTPUT_DIRECTORY_PROPERTY = "user.home";
    private static final String OUTPUT_PARENT_FOLDER = "Documents";
    private static final String OUTPUT_FOLDER = "CSVData";


    public static void convertSimplePOJO(String id, List<? extends Number> dataList, String columnName) throws IOException {

        File file = createFileInUserDir(id);
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter fileBuffWriter = new BufferedWriter(fw);

        writeHeaderToFile(fileBuffWriter, Arrays.asList(columnName));
        List<List<? extends Number>> listOfDataRows = convertSimpleListToListOfRows(dataList);
        writeDataToFile(fileBuffWriter, listOfDataRows);
        fileBuffWriter.close();
    }

    public static void convertMultiRowPOJO(String id, List<List<? extends Number>> listOfDataRows, List<String> columnNames) throws IOException {
        File file = createFileInUserDir(id);
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter fileBuffWriter = new BufferedWriter(fw);

        writeHeaderToFile(fileBuffWriter, columnNames);
        writeDataToFile(fileBuffWriter, listOfDataRows);
        fileBuffWriter.close();
    }

    private static void writeDataToFile(BufferedWriter fileBuffWriter, List<List<? extends Number>> listOfDataRows) throws IOException {
        boolean isF = true;
        for (List<? extends Number> row : listOfDataRows){
            if (isF){
                isF = false;
            } else {
                fileBuffWriter.write(LINE_SEPARATOR);
            }
            StringBuilder rowSB = new StringBuilder();
            boolean isFirst = true;
            for (Number value: row){
                if (isFirst){
                    rowSB.append(value.toString());
                    isFirst = false;
                } else {
                    rowSB.append(CSV_SEPARATOR + value.toString());
                }
            }
            fileBuffWriter.write(rowSB.toString());
        }
    }

    private static List<List<? extends Number>> convertSimpleListToListOfRows(List<? extends Number> dataList) {
        List<List<? extends Number>> listOfDataRows = new LinkedList<>();
        for (Number dataRow: dataList){
            listOfDataRows.add(Arrays.asList(dataRow));
        }
        return listOfDataRows;
    }

    private static void writeHeaderToFile(BufferedWriter bw, List<String> columnNames) throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (String columnName: columnNames){
            if (isFirst){
                sb.append(columnName);
                isFirst = false;
            } else {
                sb.append(CSV_SEPARATOR + columnName);
            }
        }
        bw.write(sb.toString());
        bw.write(LINE_SEPARATOR);
    }

    private static File createFileInUserDir(String id) throws IOException{
        String path = System.getProperty(OUTPUT_DIRECTORY_PROPERTY) + File.separator + OUTPUT_PARENT_FOLDER;
        path += File.separator + OUTPUT_FOLDER;
        File customDir = new File(path);

        if (!customDir.exists() && !customDir.mkdirs()) {
            throw new IOException("Unable to create: " + customDir.getAbsolutePath());
        }

        File file = createFileWithTimeStamp(customDir+File.separator+id);

        if (!file.exists()) {
            file.createNewFile();
        } else {
            throw new IOException("File: " + file.getAbsolutePath() + " already exist");
        }
        return file;
    }

    private static File createFileWithTimeStamp(String path) {
        DateFormat dateFormat = new SimpleDateFormat(TIMESTAMP_FORMAT);
        Date date = new Date();
        String timeStamp = dateFormat.format(date);
        String newPath = path + "_" + timeStamp+ CSV_EXTENSION;
        System.out.println(newPath);
        return new File(newPath);
    }
}
