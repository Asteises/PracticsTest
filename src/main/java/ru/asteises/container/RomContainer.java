package ru.asteises.container;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RomContainer implements Container {
    private Map<Integer, String> romContainer;
    private static final String path = "C:\\Users\\User\\IdeaProjects\\PracticsTest\\src\\main\\resources\\";

    public RomContainer() {
        romContainer = new HashMap<>();
    }

    @Override
    public void putEmployee(int id, Employee employee) {
        String uniqueID = UUID.randomUUID().toString();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path + uniqueID + ".txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employee);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        romContainer.put(id, uniqueID);
    }

    @Override
    public Employee getEmployee(int id) {
        FileInputStream fileInputStream = null;
        Employee employee = new Employee();
        try {
            fileInputStream = new FileInputStream(path + romContainer.get(id) + ".txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            employee = (Employee) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        romContainer.remove(id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        File file = new File(path + romContainer.get(id) + ".txt");
        file.delete();
        romContainer.remove(id);
    }

    public boolean isContainsKey(int id) {
        return romContainer.containsKey(id);
    }
}
