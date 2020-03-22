package com.company;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.*;

public class Serialazer
{
    static public void Serialaze( ArrayList<FinalTest> allData, String eunloadFilePath) throws IOException
    {
        FileOutputStream outputStream = new FileOutputStream(eunloadFilePath);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(allData);
        objectOutputStream.close();
    }

    static public ArrayList<FinalTest> Deserialize(String downloadFilePath) throws IOException, ClassNotFoundException
    {
        FileInputStream fileInputStream = new FileInputStream(downloadFilePath);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        return (ArrayList<FinalTest>) objectInputStream.readObject();
    }
}
