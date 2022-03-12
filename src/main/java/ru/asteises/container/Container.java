package ru.asteises.container;

public interface Container {

    void putEmployee(int id, Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);
}
