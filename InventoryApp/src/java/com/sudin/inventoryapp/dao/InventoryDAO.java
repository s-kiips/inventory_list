/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudin.inventoryapp.dao;

import com.sudin.inventoryapp.entity.Inventory;
import java.util.List;

/**
 *
 * @author SUNITA
 */
public interface InventoryDAO {
    List<Inventory> getAll();
    Inventory getById(int id);
    void insert(Inventory i);
    void update(Inventory i);
    void delete(int id);
}
