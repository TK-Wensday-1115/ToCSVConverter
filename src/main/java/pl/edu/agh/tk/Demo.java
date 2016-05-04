package pl.edu.agh.tk;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Demo
{
    public static void main( String[] args )
    {
        try {

            List<String> columnNames = new LinkedList<>();
            columnNames.add("Temperature1");
            columnNames.add("Pressure");
            columnNames.add("Humidity");

            List<Integer> list = new LinkedList<>();
            list.add(2);
            list.add(3);
            list.add(9);
            List<List<? extends Number>> listOfDataRows = new LinkedList<>();
            listOfDataRows.add(list);
            listOfDataRows.add(list);
            listOfDataRows.add(list);
            ToCSVConverter.convertFromPOJO("SENSOR41", list, "Temperature");
            ToCSVConverter.convertFromPOJO("Sensor459", listOfDataRows, columnNames);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}