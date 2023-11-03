/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data_access;

import common.Library;
import common.Validation;
import java.util.List;
import model.Data;

/**
 *
 * @author GoldCandy
 */
public class csvFileFormatDAO {
    private static csvFileFormatDAO instance = null;
    private final Library lib = new Library();
    private final Validation valid = new Validation();
    
    public static csvFileFormatDAO Instance(){
        if(instance == null){
            synchronized (csvFileFormatDAO.class) {
                if(instance == null){
                    instance = new csvFileFormatDAO();
                }
            }
        }
        return instance;
    }
    
    public void importCSV(Data data){
        data.setDatas(data.readFile(valid.inputString("Enter Path")));
    }
    
    public void formatAddress(List<Data> datas){
        for(Data dt: datas){
            dt.setAddress(lib.format(dt.getAddress()));
        }
    }
    
    public void formatName(List<Data> datas){
        for(Data dt: datas){
            dt.setName(lib.format(dt.getName()));
        }
    }
    
    public boolean exportCSV(List<Data> datas){
        return new Data().writeToFile(valid.inputString("Enter Path"), datas);
    }
}
