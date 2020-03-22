package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.*;
import java.io.FileInputStream;

public class Main {
    static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("log.config")){ //полный путь до файла с конфигами
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Main.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        LOGGER.log(Level.INFO,"Начало main, создание списка массивов строк и выгрузка в него данных из CSV файла");
        ArrayList<String []> allData = FileReaderWriter.ReadFromFile("DataFile.csv");
        LOGGER.log(Level.INFO,"Парсинг данных и создание на их основе объектов классов Exam и CreditTest, " +
                "которые помещаются в единое хранилище(ArrayList<FinalTest>)");
        ArrayList<FinalTest> allFinalTests =DataParser.Parse(new ArrayList<FinalTest>(), allData);
        LOGGER.log(Level.INFO,"Сериализация выгруженных из файла CSV данных");
        Serialazer.Serialaze(allFinalTests,"SerializedData.ser");
        LOGGER.log(Level.INFO,"Десериализация сериализованных данных");
        ArrayList<FinalTest> deserializeData=Serialazer.Deserialize("SerializedData.ser");
        //LOGGER.log(Level.INFO,"Запись десериализованных данных в CSV файл");
        //FileReaderWriter.CreateFile (deserializeData,"newFile.csv");
        LOGGER.log(Level.INFO,"Вывод данных обо всех созданных объектах");
        for (FinalTest test:deserializeData)
        {
            test.PrintData();
        }
        LOGGER.log(Level.INFO,"Завершение работы программы");
    }
}
