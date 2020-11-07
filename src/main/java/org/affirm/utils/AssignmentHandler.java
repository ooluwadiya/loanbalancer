package org.affirm.utils;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.affirm.domain.Assignment;
import org.affirm.domain.Yield;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class AssignmentHandler {
    public static void writeAssignment(List<Assignment> assignments){
        try {
            Writer writer = new FileWriter("/tmp/assignments.csv");
            StatefulBeanToCsv<Assignment> beanToCsv = new StatefulBeanToCsvBuilder<Assignment>(writer).build();
            beanToCsv.write(assignments);
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
