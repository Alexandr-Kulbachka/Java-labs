package com.company;

import java.io.IOException;
import java.util.*;
import java.util.logging.*;
import java.io.FileInputStream;

import org.javatuples.Pair;

public class Main
{

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        ArrayList<String[]> allData = FileReaderWriter.ReadFromFile("DataFile.csv");
        ArrayList<FinalTest> allFinalTests = DataParser.Parse(new ArrayList<FinalTest>(), allData);
       // Serialazer.Serialaze(allFinalTests,"SerializedData.ser");
       // ArrayList<FinalTest> deserializeData=Serialazer.Deserialize("SerializedData.ser");
        ArrayList<Pair<String, String>> dataForDatabase = new ArrayList<Pair<String, String>>();
        for (FinalTest test : allFinalTests)
        {
            test.PrintData();
            dataForDatabase.add(DatabaseDataPreparer.PrepearData(test));
        }
        DatabaseMediator databaseMediator = new DatabaseMediator();
        if (databaseMediator.Connect("postgresql", "3-lab", "postgres", "admin"))
        {
            for (int i = 0; i < allFinalTests.size(); i++)
            {
                databaseMediator.Insert(allFinalTests.get(i).TakeClassName(),
                        dataForDatabase.get(i).getValue0(),
                        dataForDatabase.get(i).getValue1());
            }

//            databaseMediator.DeleteAllFromTable("Exam");
//            databaseMediator.DeleteAllFromTable("CreditTest");

//            databaseMediator.SelectFieldsFromTable(
//                    allFinalTests.get(0).TakeClassName(),
//                    new LinkedList(Arrays.asList(dataForDatabase.get(0).getValue0().split(","))));

//            databaseMediator.SelectFieldsFromTable(
//                    allFinalTests.get(1).TakeClassName(),
//                    new LinkedList(Arrays.asList(dataForDatabase.get(1).getValue0().split(","))));

            databaseMediator.UpdateLineInTable( "Exam",
                    new LinkedList(Arrays.asList(dataForDatabase.get(0).getValue0().split(","))),
                    "teachername",
                    "Egor White");
            databaseMediator.Disconnect();
        }
    }
}
