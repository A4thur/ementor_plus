/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ementor.plus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class Conexoes {
    /*Secão de atributos/variaveis iniciais */
    private final String caminho = "localhost"; //Indica que usaremos o server na máquina
    private final String porta = "3306"; //Porta padrão de Conexão do MySQL Server
    private final String nome = "ementor_plus"; //Nome da nossa base de dados
    private final String usuario = "root"; //Usuario padrão do MySQL
    private final String senha = "123456"; // Senha definida no momento da instalação do MySQL
    private final String FusoHorario = "?useTimezone=true&serverTimezone=UTC";
    private final String URL ="jdbc:mysql://"+caminho+":"+porta+"/"+nome+FusoHorario; //Ajusta o fuso horário em relação a sede da Oracle 
    
    public Connection realizaConexaoMySQL(){
        try{
            return DriverManager.getConnection(URL,usuario,senha); //Estabelece a conexão via conector j
            
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);
          return null;
        }        
    }
    
    /////////////////////////////////////////////////////////////////////
    public void desconectaMySQL(Connection conexao){
        try{
           if (conexao != null) 
             conexao.close();
            
        }catch(SQLException e){
          JOptionPane.showMessageDialog(null,"Algum imprevisto ocorreu: "+e+"","ERRO",JOptionPane.ERROR_MESSAGE);
          
        }   
    }
    //////////////////////////////////////////////////////////////////////
    public void insereSQL(Dados info){
        Connection conexao = null;
        PreparedStatement Atuador = null;
        ArrayList<String> Names = info.getNames();
        String dados = "";
        String values = "";
        for(int i = 0; i<info.length();i++){
            if(i>0){
                dados = dados.concat(", ");
                values = values.concat(", ");
            }
            dados = dados.concat(Names.get(i));
            values = values.concat("?");
        }
        String sql = "insert into ementor_plus." + info.getTabela() + " (" + dados + ") values (" + values + ")";
        try{
            conexao = realizaConexaoMySQL();
            conexao.setAutoCommit(false);
            Atuador = conexao.prepareStatement(sql);
            for(int i = 0; i<info.length(); i++){
                if(info.getTypes().get(i).equals("String")){
                    Atuador.setString(i+1, info.getVarchar(i));
                }
                if(info.getTypes().get(i).equals("int")){
                    Atuador.setInt(i+1, info.getInt(i));
                }
                if(info.getTypes().get(i).equals("float")){
                    Atuador.setFloat(i+1, info.getFloat(i));
                }
                if(info.getTypes().get(i).equals("boolean")){
                    Atuador.setBoolean(i+1, info.getBool(i));
                }
            }
            
            Atuador.execute();
            
            conexao.commit();
            
            
        }catch(SQLException e){
            if (conexao != null) {
                try {
                    conexao.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }finally {
            // Fechamento dos recursos
            if (Atuador != null) {
                try {
                    Atuador.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexao != null) {
                try {
                    conexao.setAutoCommit(true); // Restaura o modo de auto-commit
                    desconectaMySQL(conexao); // Fecha a conexão do Banco de Dados
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void atualizaSQL(Dados info, Dados busca){
        Connection conexao = null;
        PreparedStatement Atuador = null;
        ArrayList<String> Names = info.getNames();
        ArrayList<String> NamesBusca = busca.getNames();
        String sql = "UPDATE ementor_plus." + info.getTabela() + " SET ";
        for(int i = 0; i<info.length();i++){
            sql = sql.concat(Names.get(i) + " = ?");
            if(i<(info.length()-1)){
                sql = sql.concat(", ");
            }
        }
        
        sql = sql.concat(" WHERE ");
        
        for(int i = 0; i<busca.length();i++){
            sql = sql.concat(NamesBusca.get(i) + " = ?");
            if(i<(busca.length()-1)){
                sql = sql.concat(" AND ");
            }
        }
        
        try{
            conexao = realizaConexaoMySQL();
            conexao.setAutoCommit(false);
            Atuador = conexao.prepareStatement(sql);
            int j = 1;
            for(int i = 0; i<info.length(); i++){
                if(info.getTypes().get(i).equals("String")){
                    Atuador.setString(j, info.getVarchar(i));
                }
                if(info.getTypes().get(i).equals("int")){
                    Atuador.setInt(j, info.getInt(i));
                }
                if(info.getTypes().get(i).equals("float")){
                    Atuador.setFloat(j, info.getFloat(i));
                }
                if(info.getTypes().get(i).equals("boolean")){
                    Atuador.setBoolean(j, info.getBool(i));
                }
                j++;
            }
            
            for(int i = 0; i<busca.length();i++){
                if(busca.getTypes().get(i).equals("String")){
                    Atuador.setString(j, busca.getVarchar(i));
                }
                if(busca.getTypes().get(i).equals("int")){
                    Atuador.setInt(j, busca.getInt(i));
                }
                if(busca.getTypes().get(i).equals("float")){
                    Atuador.setFloat(j, busca.getFloat(i));
                }
                if(busca.getTypes().get(i).equals("boolean")){
                    Atuador.setBoolean(j, busca.getBool(i));
                }
                j++;
            }
            
            Atuador.execute();
            
            conexao.commit();
            
            
        }catch(SQLException e){
            if (conexao != null) {
                try {
                    conexao.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }finally {
            // Fechamento dos recursos
            if (Atuador != null) {
                try {
                    Atuador.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexao != null) {
                try {
                    conexao.setAutoCommit(true); // Restaura o modo de auto-commit
                    desconectaMySQL(conexao); // Fecha a conexão do Banco de Dados
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public void exclusaoSQL(Dados busca) {
        Connection conexao = null;
        PreparedStatement Atuador = null;
        ArrayList<String> NamesBusca = busca.getNames();
        String sql = "DELETE FROM ementor_plus." + busca.getTabela() + " WHERE ";
        
        
        for(int i = 0; i<busca.length();i++){
            sql = sql.concat(NamesBusca.get(i) + " = ?");
            if(i<(busca.length()-1)){
                sql = sql.concat(" AND ");
            }
        }
        
        try {
            conexao = realizaConexaoMySQL(); // Estabelece conexão

            // Desativar auto-commit para gerenciar a transação manualmente
            conexao.setAutoCommit(false);
            
            

            Atuador = conexao.prepareStatement(sql);
            
            for(int i = 0; i<busca.length();i++){
                if(busca.getTypes().get(i).equals("String")){
                    Atuador.setString(i+1, busca.getVarchar(i));
                }
                if(busca.getTypes().get(i).equals("int")){
                    Atuador.setInt(i+1, busca.getInt(i));
                }
                if(busca.getTypes().get(i).equals("float")){
                    Atuador.setFloat(i+1, busca.getFloat(i));
                }
                if(busca.getTypes().get(i).equals("boolean")){
                    Atuador.setBoolean(i+1, busca.getBool(i));
                }
            }
            
            int linhasAfetadas = Atuador.executeUpdate();
            System.out.println("Linhas afetadas na tabela " + busca.getTabela() + ": " + linhasAfetadas);
            
            // Confirmar a transação
            conexao.commit();
            
        

        }catch(SQLException e){
            if (conexao != null) {
                try {
                    conexao.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }finally {
            // Fechamento dos recursos
            if (Atuador != null) {
                try {
                    Atuador.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexao != null) {
                try {
                    conexao.setAutoCommit(true); // Restaura o modo de auto-commit
                    desconectaMySQL(conexao); // Fecha a conexão do Banco de Dados
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public ArrayList<Dados> mostrarSQL(Dados busca){
        Connection conexao = null;
        PreparedStatement Atuador = null;
        PreparedStatement AtuadorTabela = null;
        ArrayList<Dados> Resposta = new ArrayList<Dados>();
        ArrayList<String> NamesBusca = busca.getNames();
        String sql = "SELECT * FROM ementor_plus." + busca.getTabela() + " WHERE ";
        String sqlTabela = "select COLUMN_NAME, DATA_TYPE from INFORMATION_SCHEMA.columns where TABLE_NAME = ? and TABLE_SCHEMA = ?";
        ArrayList<String> columns_name = new ArrayList<String>();
        ArrayList<String> data_types = new ArrayList<String>();
        
        
        for(int i = 0; i<busca.length();i++){
            sql = sql.concat(NamesBusca.get(i) + " = ?");
            if(i<(busca.length()-1)){
                sql = sql.concat(" AND ");
            }
        }
        
        try {
            conexao = realizaConexaoMySQL(); // Estabelece conexão

            // Desativar auto-commit para gerenciar a transação manualmente
            conexao.setAutoCommit(false);
            
            AtuadorTabela = conexao.prepareStatement(sqlTabela);
            
            AtuadorTabela.setString(1, busca.getTabela());
            AtuadorTabela.setString(2, "ementor_plus");
            
            ResultSet RespostaTabela = AtuadorTabela.executeQuery();
            
            int cont = 0;
            
            while(RespostaTabela.next()){
                columns_name.add(RespostaTabela.getString("COLUMN_NAME"));
                data_types.add(RespostaTabela.getString("DATA_TYPE"));
                cont++;
            }

            Atuador = conexao.prepareStatement(sql);
            
            for(int i = 0; i<busca.length();i++){
                if(busca.getTypes().get(i).equals("String")){
                    Atuador.setString(i+1, busca.getVarchar(i));
                }
                if(busca.getTypes().get(i).equals("int")){
                    Atuador.setInt(i+1, busca.getInt(i));
                }
                if(busca.getTypes().get(i).equals("float")){
                    Atuador.setFloat(i+1, busca.getFloat(i));
                }
                if(busca.getTypes().get(i).equals("boolean")){
                    Atuador.setBoolean(i+1, busca.getBool(i));
                }
            }
            ResultSet Resultado = Atuador.executeQuery();
            
            while(Resultado.next()){
                Dados Item = new Dados(busca.getTabela());
                for(int i = 0; i<cont; i++){
                    if(data_types.get(i).equals("varchar")){
                        Item.addItem(columns_name.get(i), Resultado.getString(columns_name.get(i)));
                    }
                    if(data_types.get(i).equals("int")){
                        Item.addItem(columns_name.get(i), Resultado.getInt(columns_name.get(i)));
                    }
                    if(data_types.get(i).equals("float")){
                        Item.addItem(columns_name.get(i), Resultado.getFloat(columns_name.get(i)));
                    }
                    if(data_types.get(i).equals("tinyint")){
                        Item.addItem(columns_name.get(i), Resultado.getBoolean(columns_name.get(i)));
                    }
                }
                Resposta.add(Item);
            }
            
            // Confirmar a transação
            conexao.commit();
            
            

        }catch(SQLException e){
            if (conexao != null) {
                try {
                    conexao.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }finally {
            // Fechamento dos recursos
            if (Atuador != null) {
                try {
                    Atuador.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (AtuadorTabela != null) {
                try {
                    AtuadorTabela.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexao != null) {
                try {
                    conexao.setAutoCommit(true); // Restaura o modo de auto-commit
                    desconectaMySQL(conexao); // Fecha a conexão do Banco de Dados
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return Resposta;
    }
    
    public ArrayList<Dados> mostrarSQL(String Tabela){
        Connection conexao = null;
        PreparedStatement Atuador = null;
        PreparedStatement AtuadorTabela = null;
        ArrayList<Dados> Resposta = new ArrayList<Dados>();
        String sql = "SELECT * FROM ementor_plus." + Tabela;
        String sqlTabela = "select COLUMN_NAME, DATA_TYPE from INFORMATION_SCHEMA.columns where TABLE_NAME = ? and TABLE_SCHEMA = ?";
        ArrayList<String> columns_name = new ArrayList<String>();
        ArrayList<String> data_types = new ArrayList<String>();
        try {
            conexao = realizaConexaoMySQL(); // Estabelece conexão

            // Desativar auto-commit para gerenciar a transação manualmente
            conexao.setAutoCommit(false);
            
            AtuadorTabela = conexao.prepareStatement(sqlTabela);
            
            AtuadorTabela.setString(1, Tabela);
            AtuadorTabela.setString(2, "ementor_plus");
            
            ResultSet RespostaTabela = AtuadorTabela.executeQuery();
            
            int cont = 0;
            
            while(RespostaTabela.next()){
                columns_name.add(RespostaTabela.getString("COLUMN_NAME"));
                data_types.add(RespostaTabela.getString("DATA_TYPE"));
                cont++;
            }
            
            Atuador = conexao.prepareStatement(sql);
            
            ResultSet Resultado = Atuador.executeQuery();
            
            while(Resultado.next()){
                Dados Item = new Dados(Tabela);
                for(int i = 0; i<cont; i++){
                    if(data_types.get(i).equals("varchar")){
                        Item.addItem(columns_name.get(i), Resultado.getString(columns_name.get(i)));
                    }
                    if(data_types.get(i).equals("int")){
                        Item.addItem(columns_name.get(i), Resultado.getInt(columns_name.get(i)));
                    }
                    if(data_types.get(i).equals("float")){
                        Item.addItem(columns_name.get(i), Resultado.getFloat(columns_name.get(i)));
                    }
                    if(data_types.get(i).equals("tinyint")){
                        Item.addItem(columns_name.get(i), Resultado.getBoolean(columns_name.get(i)));
                    }
                }
                Resposta.add(Item);
            }
            
            // Confirmar a transação
            conexao.commit();
            
           

        }catch(SQLException e){
            if (conexao != null) {
                try {
                    conexao.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }finally {
            // Fechamento dos recursos
            if (Atuador != null) {
                try {
                    Atuador.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexao != null) {
                try {
                    conexao.setAutoCommit(true); // Restaura o modo de auto-commit
                    desconectaMySQL(conexao); // Fecha a conexão do Banco de Dados
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return Resposta;
    }
    
    public int mostrarSQLId(Dados busca){
        Connection conexao = null;
        PreparedStatement Atuador = null;
        ArrayList<String> NamesBusca = busca.getNames();
        String sql = "SELECT id FROM " + busca.getTabela() + " WHERE ";
        
        int resposta = 0;
        
        
        for(int i = 0; i<busca.length();i++){
            sql = sql.concat(NamesBusca.get(i) + " = ?");
            if(i<(busca.length()-1)){
                sql = sql.concat(" AND ");
            }
        }
        
        try {
            conexao = realizaConexaoMySQL(); // Estabelece conexão

            // Desativar auto-commit para gerenciar a transação manualmente
            conexao.setAutoCommit(false);
            
            Atuador = conexao.prepareStatement(sql);
            
            for(int i = 0; i<busca.length();i++){
                if(busca.getTypes().get(i).equals("String")){
                    Atuador.setString(i+1, busca.getVarchar(i));
                }
                if(busca.getTypes().get(i).equals("int")){
                    Atuador.setInt(i+1, busca.getInt(i));
                }
                if(busca.getTypes().get(i).equals("float")){
                    Atuador.setFloat(i+1, busca.getFloat(i));
                }
                if(busca.getTypes().get(i).equals("boolean")){
                    Atuador.setBoolean(i+1, busca.getBool(i));
                }
            }
            
            ResultSet Resultado = Atuador.executeQuery();
            
            if(Resultado.next()){
                resposta = Resultado.getInt("id");
            }
            
            // Confirmar a transação
            conexao.commit();
            
            

        }catch(SQLException e){
            if (conexao != null) {
                try {
                    conexao.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }finally {
            // Fechamento dos recursos
            if (Atuador != null) {
                try {
                    Atuador.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexao != null) {
                try {
                    conexao.setAutoCommit(true); // Restaura o modo de auto-commit
                    desconectaMySQL(conexao); // Fecha a conexão do Banco de Dados
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resposta;
    }
    
    public boolean verificaOcorrencia(Dados busca){
        Connection conexao = null;
        PreparedStatement Atuador = null;
        ArrayList<String> NamesBusca = busca.getNames();
        String sql = "SELECT EXISTS (SELECT 1 FROM ementor_plus." + busca.getTabela() + " WHERE ";
        
        boolean resposta = false;
        
        
        for(int i = 0; i<busca.length();i++){
            sql = sql.concat(NamesBusca.get(i) + " = ?");
            if(i<(busca.length()-1)){
                sql = sql.concat(" AND ");
            }
        }
        
        sql = sql.concat(")");
        
        try {
            conexao = realizaConexaoMySQL(); // Estabelece conexão

            // Desativar auto-commit para gerenciar a transação manualmente
            conexao.setAutoCommit(false);
            
            Atuador = conexao.prepareStatement(sql);
            
            for(int i = 0; i<busca.length();i++){
                if(busca.getTypes().get(i).equals("String")){
                    Atuador.setString(i+1, busca.getVarchar(i));
                }
                if(busca.getTypes().get(i).equals("int")){
                    Atuador.setInt(i+1, busca.getInt(i));
                }
                if(busca.getTypes().get(i).equals("float")){
                    Atuador.setFloat(i+1, busca.getFloat(i));
                }
                if(busca.getTypes().get(i).equals("boolean")){
                    Atuador.setBoolean(i+1, busca.getBool(i));
                }
            }
            
            ResultSet Resultado = Atuador.executeQuery();
            
            if(Resultado.next()){
                resposta = Resultado.getBoolean(1);
            }
            
            // Confirmar a transação
            conexao.commit();
            
            

        }catch(SQLException e){
            if (conexao != null) {
                try {
                    conexao.rollback();
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }finally {
            // Fechamento dos recursos
            if (Atuador != null) {
                try {
                    Atuador.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conexao != null) {
                try {
                    conexao.setAutoCommit(true); // Restaura o modo de auto-commit
                    desconectaMySQL(conexao); // Fecha a conexão do Banco de Dados
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return resposta;
    }
}
