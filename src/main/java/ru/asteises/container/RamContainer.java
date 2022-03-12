package ru.asteises.container;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RamContainer implements Container {
    private RomContainer romContainer;
    private int size;
    private Map<Integer, Employee> employeeMap;

    public RamContainer(int size) {
        romContainer = new RomContainer();
        employeeMap = new LinkedHashMap<>();
        this.size = size;
    }

    @Override
    public void putEmployee(int id, Employee employee) {
        if (employeeMap.size() > size) {
            int tempKey = employeeMap.entrySet().stream().findFirst().get().getKey();
            romContainer.putEmployee(tempKey, employeeMap.get(tempKey));
            employeeMap.remove(tempKey);
            employeeMap.put(id, employee);
        } else {
            employeeMap.put(id, employee);
        }
    }

    @Override
    public Employee getEmployee(int id) {
        if (employeeMap.containsKey(id)) {
            return employeeMap.get(id);
        } else if (romContainer.isContainsKey(id)) {
            putEmployee(id, romContainer.getEmployee(id));
            romContainer.deleteEmployee(id);
            return employeeMap.get(id);
        } else {
            return null;
        }
    }

    @Override
    public void deleteEmployee(int id) {
        if (employeeMap.containsKey(id)) {
            employeeMap.remove(id);
        } else if (romContainer.isContainsKey(id)) {
            romContainer.deleteEmployee(id);
        }
    }
}
