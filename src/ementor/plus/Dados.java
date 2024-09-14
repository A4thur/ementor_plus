/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ementor.plus;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class Dados {
    private String Tabela;
    private ArrayList<String> Types;
    private ArrayList<String> Names;
    private ArrayList<String> Varchar;
    private ArrayList Int;
    private ArrayList Float;
    private ArrayList Bool;
    
    private ArrayList positions;
    private int positionVarchar;
    private int positionInt;
    private int positionFloat;
    private int positionBool;

    public Dados() {
        this.Tabela = null;
        this.Types = new ArrayList<String>();
        this.Names = new ArrayList<String>();
        this.Varchar = new ArrayList<String>();
        this.Int = new ArrayList();
        this.Float = new ArrayList();
        this.Bool = new ArrayList();
        this.positions = new ArrayList();
        this.positionVarchar = 0;
        this.positionInt = 0;
        this.positionFloat = 0;
        this.positionBool = 0;
    }
    
    public Dados(String Tabela) {
        this.Tabela = Tabela;
        this.Types = new ArrayList<String>();
        this.Names = new ArrayList<String>();
        this.Varchar = new ArrayList<String>();
        this.Int = new ArrayList();
        this.Float = new ArrayList();
        this.Bool = new ArrayList();
        this.positions = new ArrayList();
        this.positionVarchar = 0;
        this.positionInt = 0;
        this.positionFloat = 0;
        this.positionBool = 0;
    }
    
    public String getTabela(){
        return Tabela;
    }

    public ArrayList<String> getTypes() {
        return Types;
    }
    
    public int length(){
        return Types.size();
    }
    
    public ArrayList<String> getNames() {
        return Names;
    }
    
    public String getVarchar(int i) {
        String value = this.Varchar.get((int) this.positions.get(i));
        return value;
    }

    public int getInt(int i) {
        int value = (int) this.Int.get((int) this.positions.get(i));
        return value;
    }

    public float getFloat(int i) {
        float value = (float) this.Float.get((int) this.positions.get(i));
        return value;
    }

    public boolean getBool(int i) {
        boolean value = (boolean) this.Bool.get((int) this.positions.get(i));
        return value;
    }
    
    public String getVarchar(String name) {
        int i = this.Names.indexOf(name);
        String value = this.Varchar.get((int) this.positions.get(i));
        return value;
    }

    public int getInt(String name) {
        int i = this.Names.indexOf(name);
        int value = (int) this.Int.get((int) this.positions.get(i));
        return value;
    }

    public float getFloat(String name) {
        int i = this.Names.indexOf(name);
        float value = (float) this.Float.get((int) this.positions.get(i));
        return value;
    }

    public boolean getBool(String name) {
        int i = this.Names.indexOf(name);
        boolean value = (boolean) this.Bool.get((int) this.positions.get(i));
        return value;
    }
    
    public void addItem(String Name, String value){
        this.Varchar.add(value);
        this.Names.add(Name);
        this.Types.add("String");
        this.positions.add(positionVarchar);
        positionVarchar++;
    }
    
    public void addItem(String Name, int value){
        this.Int.add(value);
        this.Names.add(Name);
        this.Types.add("int");
        this.positions.add(positionInt);
        positionInt++;
    }
    
    public void addItem(String Name, float value){
        this.Float.add(value);
        this.Names.add(Name);
        this.Types.add("float");
        this.positions.add(positionFloat);
        positionFloat++;
    }
    
    public void addItem(String Name, boolean value){
        this.Bool.add(value);
        this.Names.add(Name);
        this.Types.add("boolean");
        this.positions.add(positionBool);
        positionBool++;
    }
    
    public void addNameItem(String Name, String Type){
        this.Names.add(Name);
        this.Types.add(Type);
    }
}
