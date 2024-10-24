/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.hibernate_ma1.test;

import java.util.Date;

import com.example.hibernate_ma1.entities.Machine;
import com.example.hibernate_ma1.entities.Salle;
import com.example.hibernate_ma1.services.MachineService;
import com.example.hibernate_ma1.services.SalleService;

public class Test {

    public static void main(String[] args) {
        SalleService ss = new SalleService();
        MachineService ms = new MachineService();
      

        for(Salle s : ss.findAll())
            System.out.println(s.getCode());
        ms.create(new Machine("ER34", new Date(), ss.findById(1)));
        ms.create(new Machine("ER33", new Date("2000/09/09"), ss.findById(2)));

        for(Machine m : ss.findById(2).getMachines())
            System.out.println(m.getRef());
        
        for(Machine m : ms.findBetweenDate(new Date("2010/01/01"), new Date()))
            System.out.println(m.getRef());
    }
}
