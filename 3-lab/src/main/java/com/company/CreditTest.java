package com.company;
public class CreditTest extends FinalTest
{
    public CreditTest(String [] allParameters)
    {
        CreateFromText(allParameters);
    }

    @Override public void CreateFromText(String [] allParameters)
    {
        this.typeOfTest=allParameters[0];
        this.subjectName=allParameters[1];
        this.teacherName=allParameters[2];
        this.tastingDate=Integer.valueOf(allParameters[3]);
        this.automaticRating=Boolean.valueOf(allParameters[4]);
        this.examinationTicketsNumber=Integer.valueOf(allParameters[5]);
    }

    @Override public void PrintData()
    {
        System.out.println();
        System.out.println("Test type: " + this.typeOfTest);
        System.out.println("Subject name: " + this.subjectName);
        System.out.println("Teacher's name: " + this.teacherName);
        System.out.println("FinalTest date: " + this.tastingDate);
        System.out.println("Is there a automatic rating: "+this.automaticRating);
        System.out.println("How many tickets: " + this.examinationTicketsNumber);
        System.out.println("----------------");
    }
}
