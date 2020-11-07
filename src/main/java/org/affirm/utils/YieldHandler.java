package org.affirm.utils;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.affirm.domain.Yield;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class YieldHandler {
    public static void writeYields(List<Yield> yields){
        try {
            Writer writer = new FileWriter("/tmp/yields.csv");
            StatefulBeanToCsv<Yield> beanToCsv = new StatefulBeanToCsvBuilder<Yield>(writer).build();
            beanToCsv.write(yields);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }

    }
}
