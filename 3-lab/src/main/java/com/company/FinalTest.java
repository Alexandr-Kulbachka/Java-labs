package com.company;
import java.io.*;

public abstract class FinalTest implements Serializable
{
    public String typeOfTest;
    public String subjectName;
    public String teacherName;
    public int tastingDate;
    public boolean automaticRating;
    public int examinationTicketsNumber;
    public void PrintData(){};
    public void CreateFromText(String [] text){};
    public String TakeClassName(){return this.getClass().getSimpleName();};
}
