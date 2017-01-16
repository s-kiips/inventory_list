/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudin.inventoryapp.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author SUNITA
 */
@Entity
@Table(name = "tbl_inventory", catalog = "inventory_list", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i"),
    @NamedQuery(name = "Inventory.findByInventoryId", query = "SELECT i FROM Inventory i WHERE i.inventoryId = :inventoryId"),
    @NamedQuery(name = "Inventory.findByInventoryName", query = "SELECT i FROM Inventory i WHERE i.inventoryName = :inventoryName"),
    @NamedQuery(name = "Inventory.findByInventoryPrice", query = "SELECT i FROM Inventory i WHERE i.inventoryPrice = :inventoryPrice"),
    @NamedQuery(name = "Inventory.findByInventoryQuantity", query = "SELECT i FROM Inventory i WHERE i.inventoryQuantity = :inventoryQuantity"),
    @NamedQuery(name = "Inventory.findByAddedDate", query = "SELECT i FROM Inventory i WHERE i.addedDate = :addedDate"),
    @NamedQuery(name = "Inventory.findByModifiedDate", query = "SELECT i FROM Inventory i WHERE i.modifiedDate = :modifiedDate")})
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inventory_id", nullable = false)
    private Integer inventoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "inventory_name", nullable = false, length = 255)
    private String inventoryName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inventory_price", nullable = false)
    private int inventoryPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inventory_quantity", nullable = false)
    private int inventoryQuantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "added_date", insertable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Column(name = "modified_date", nullable=true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public Inventory() {
    }

    public Inventory(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Inventory(Integer inventoryId, String inventoryName, int inventoryPrice, int inventoryQuantity, Date addedDate) {
        this.inventoryId = inventoryId;
        this.inventoryName = inventoryName;
        this.inventoryPrice = inventoryPrice;
        this.inventoryQuantity = inventoryQuantity;
        this.addedDate = addedDate;
    }

    public Integer getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Integer inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public int getInventoryPrice() {
        return inventoryPrice;
    }

    public void setInventoryPrice(int inventoryPrice) {
        this.inventoryPrice = inventoryPrice;
    }

    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inventoryId != null ? inventoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.inventoryId == null && other.inventoryId != null) || (this.inventoryId != null && !this.inventoryId.equals(other.inventoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sudin.inventoryapp.entity.Inventory[ inventoryId=" + inventoryId + " ]";
    }
    
}
