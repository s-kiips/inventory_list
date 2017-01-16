/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudin.inventoryapp.dao.impl;

import com.sudin.inventoryapp.dao.InventoryDAO;
import com.sudin.inventoryapp.entity.Inventory;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SUNITA
 */
@Repository(value = "inventoryDAO")
public class InventoryDAOImpl implements InventoryDAO {
     @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction trans;

    @Override
    public List<Inventory> getAll() {
        session=sessionFactory.openSession();
        List<Inventory> inventoryList=session.createQuery("SELECT i from Inventory i").list();
        session.close();
        return inventoryList;
    }

    @Override
    public Inventory getById(int id) {
        session=sessionFactory.openSession();
        Inventory inventory=(Inventory)session.get(Inventory.class, id);
        session.close();
        return inventory;
    }

    @Override
    public void insert(Inventory i) {
        session=sessionFactory.openSession();
        trans=session.beginTransaction();
        session.save(i);
        trans.commit();
        session.close();
    }

    @Override
    public void update(Inventory i) {
        session=sessionFactory.openSession();
        trans=session.beginTransaction();
        session.saveOrUpdate(i);
        trans.commit();
        session.close();
    }

    @Override
    public void delete(int id) {
        session=sessionFactory.openSession();
        trans=session.beginTransaction();
        Inventory inventory=(Inventory)session.get(Inventory.class, id);
        if(inventory!=null){
            session.delete(inventory);
        }
        trans.commit();
        session.close();
    }
    
}
