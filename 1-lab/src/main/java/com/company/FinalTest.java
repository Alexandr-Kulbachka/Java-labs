package com.company;
import java.io.*;

public abstract class FinalTest implements Serializable
{
    protected String typeOfTest;
    protected String subjectName;
    protected String teacherName;
    protected int date;
    protected boolean automaticRating;
    protected int examinationTicketsNumber;
    public void PrintData(){};
    public void CreateFromText(String [] text){};
}
