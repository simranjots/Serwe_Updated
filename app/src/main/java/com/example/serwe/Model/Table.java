package com.example.serwe.Model;

public class Table {
    public String menuId ;
    public int noTable ;

    public Table(String menuId, int  noTable) {
        this.menuId = menuId;
        this.noTable = noTable;
    }

    public Table() {
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public int getNoTable() {
        return noTable;
    }

    public void setNoTable(int noTable) {
        this.noTable = noTable;
    }
}
