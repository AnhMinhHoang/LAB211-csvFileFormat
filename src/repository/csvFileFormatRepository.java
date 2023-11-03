/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import data_access.csvFileFormatDAO;
import java.util.List;
import model.Data;

/**
 *
 * @author GoldCandy
 */
public class csvFileFormatRepository implements IcsvFileFormatRepository {

    @Override
    public void importCSV(Data data) {
        csvFileFormatDAO.Instance().importCSV(data);
        if(data.getDatas().isEmpty()){
            System.out.println("File not found");
            return;
        }
        System.out.println("Import: Done");
    }

    @Override
    public void formatAddress(List<Data> datas) {
        if (datas.isEmpty()){
            System.out.println("Please import file first!");
            return;
        }
        csvFileFormatDAO.Instance().formatAddress(datas);
        System.out.println("Format: Done");
    }

    @Override
    public void formatName(List<Data> datas) {
        if (datas.isEmpty()){
            System.out.println("Please import file first!");
            return;
        }
        csvFileFormatDAO.Instance().formatName(datas);
        System.out.println("Format: Done");
    }

    @Override
    public void exportCSV(List<Data> datas) {
        if (datas.isEmpty()){
            System.out.println("Please import file first!");
            return;
        }
        if(!csvFileFormatDAO.Instance().exportCSV(datas)){
            System.out.println("Path not found!");
            return;
        }
        System.out.println("Export: Done");
    }
}
