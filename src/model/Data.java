/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.Validation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author GoldCandy
 */
public class Data {

    private String iD;
    private String name;
    private String Email;
    private String phone;
    private String address;
    private List<Data> datas = new ArrayList<>();

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Data> getDatas() {
        return datas;
    }

    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }

    public List<Data> readFile(String filename) {
        List<Data> arr = new ArrayList();
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNext()) {
                Data new_data = new Data();
                String str = sc.nextLine().trim();
                String[] line = str.split(", ");
                new_data.setiD(line[0]);
                new_data.setName(line[1]);
                new_data.setEmail(line[2]);
                new_data.setPhone(line[3]);
                new_data.setAddress(line[4]);
                arr.add(new_data);
            }
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
        return arr;
    }

    public boolean writeToFile(String filename, List<Data> dts) {
        Validation valid = new Validation();
        File f = new File(filename);
        if (f.exists()) {
            String choice = valid.inputStringMatch("Overwrite?(Y/N)", "[YNyn]");
            if (choice.matches("[Nn]")) {
                return true;
            }
        }
        try {
            try (FileWriter fw = new FileWriter(f)) {
                for (Data dt : dts) {
                    fw.append(dt.getiD() + ", ");
                    fw.append(dt.getName() + ", ");
                    fw.append(dt.getEmail() + ", ");
                    fw.append(dt.getPhone() + ", ");
                    fw.append(dt.getAddress());
                    fw.append("\n");
                }
            }
        } catch (IOException e) {
            return false;
        }
        return true;
    }
}
