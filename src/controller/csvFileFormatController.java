/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Data;
import repository.csvFileFormatRepository;
import view.Menu;

/**
 *
 * @author GoldCandy
 */
public class csvFileFormatController extends Menu{
    protected static String[] mc = {"Import CSV", "Format Address"
                                    ,"Format Name", "Export CSV", "Exit"};
    protected Data data;
    protected csvFileFormatRepository repo;
    
    public csvFileFormatController(){
        super("======= Format CSV Program =======", mc);
        data = new Data();
        repo = new csvFileFormatRepository();
    }

    @Override
    public void execute(int choice) {
        switch(choice){
            case 1:{
                System.out.println("--------- Import CSV -------");
                repo.importCSV(data);
                break;
            }
            case 2:{
                System.out.println("--------- Format Address -------");
                repo.formatAddress(data.getDatas());
                break;
            }
            case 3:{
                System.out.println("--------- Format Name -------");
                repo.formatName(data.getDatas());
                break;
            }
            case 4:{
                System.out.println("--------- Export CSV ------");
                repo.exportCSV(data.getDatas());
                break;
            }
            case 5:{
                System.out.println("EXIT...");
                System.exit(0);
            }
            default:{
                System.out.println("No such choice!");
            }
        }
    }
}
