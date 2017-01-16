/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudin.inventoryapp.controller;

import com.sudin.inventoryapp.dao.InventoryDAO;
import com.sudin.inventoryapp.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author SUNITA
 */
@Controller
@RequestMapping("/")
public class DefaultController {
    @Autowired
    private InventoryDAO inventoryDAO;
    
    @RequestMapping(method = RequestMethod.GET)
    //@ResponseBody
    public String index(ModelMap map){
        inventoryDAO.insert(new Inventory(0, "pen", 50, 10, null));
        //map.addAttribute("title", "Hello Sudin");
        return "index";
    }
    
    @RequestMapping(value = "/about" , method = RequestMethod.GET)
     public String about(){
        return "about";
    }
    
}
