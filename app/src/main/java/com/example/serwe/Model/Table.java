package com.example.serwe.Model;

public class Table {
    public String menuId ;
    public String noTable ;

    public Table(String menuId, String  noTable) {
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

    public String getNoTable() {
        return noTable;
    }

    public void setNoTable(String noTable) {
        this.noTable = noTable;
    }
}
