package Repository;

import models.person.Dueno;
import java.io.*;
import java.util.ArrayList;

public class RepositoryManager <T>{

    public void saveDataList(ArrayList<T> list, String fileName) {
        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objOut.writeObject(list);
            objOut.close();
            System.out.println("Datos guardado exitosamente en " + fileName);
        } catch (IOException e){
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public ArrayList<T> loadDataList(String fileName) {
        try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(fileName))){
            System.out.println("Archivo cargado exitosamente");
            ArrayList<T> list = (ArrayList<T>) objIn.readObject();
            return list;
        }catch (Exception e){
            System.out.println("Error al cargar: " + e.getMessage());
            return new ArrayList<T>();
        }
    }

}