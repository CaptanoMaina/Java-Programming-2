/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import repositories.Repository;

/**
 *
 * @author Shinzuu
 */
public class DAOObjImpl implements DAOInterface{
     @Override
     public Repository load(String filename){
       Repository repo = new Repository();
       try{
            FileInputStream fappy = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fappy);
            List<Customer> items = (List<Customer>)ois.readObject();
            repo.setItems(items);
        }catch(IOException | ClassNotFoundException ex){
            System.out.println(ex);
            System.exit(0);
        } 
       return repo;
     }
   
     @Override
   public void store(String filename, Repository repository){
       ObjectOutputStream output = null;
        try{
            output = new ObjectOutputStream(new FileOutputStream(filename));
            output.writeObject(repository.getItems());
             output.close();
        } catch (IOException ex){
            System.out.println(ex);
        }
   }
}
