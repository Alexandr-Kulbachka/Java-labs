package com.company;

import java.util.ArrayList;

public class DataParser
{
    static public ArrayList<FinalTest> Parse(ArrayList<FinalTest> allFinalTests,  ArrayList<String []> allData)
    {
        for (String[] examData:allData)
        {
            if(examData[0].contains("Exam"))
                allFinalTests.add(new Exam(examData));
            else
            if(examData[0].contains("Credit test"))
                allFinalTests.add(new CreditTest(examData));
        }
        return allFinalTests;
    }
}
