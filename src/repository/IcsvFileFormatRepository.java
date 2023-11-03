/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import model.Data;

/**
 *
 * @author GoldCandy
 */
public interface IcsvFileFormatRepository {

    void importCSV(Data data);

    void formatAddress(List<Data> datas);

    void formatName(List<Data> datas);

    void exportCSV(List<Data> datas);
    
}
