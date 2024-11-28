package org.example;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    // Константа для максимального количества сотрудников
    private static final int K = 10;

    private final List<Employee> employeeList = new ArrayList<>();

    // Конструктор для добавления начальных данных (опционально)
    public EmployeeService() {
        employeeList.add(new Employee("Денис", "Дорофеев"));
        employeeList.add(new Employee("Мария", "Петрова"));
        employeeList.add(new Employee("Сергей", "Сидоров"));
        employeeList.add(new Employee("Юлия", "Шарипова"));
        employeeList.add(new Employee("Юлия", "Зубова"));
        employeeList.add(new Employee("Айсулу", "Ахметова"));
        employeeList.add(new Employee("Азамат", "Ильясов"));
        employeeList.add(new Employee("Марина", "Иванова"));
        employeeList.add(new Employee("Айнура", "Бажиева"));
        employeeList.add(new Employee("Артур", "Вайзарян"));
    }

    // Метод для получения всех сотрудников
    public List<Employee> getEmployees() {
        return employeeList;
    }

    // Обновлённый метод для добавления сотрудника
    public void addEmployee(Employee employee) {
        if (employeeList.size() >= K) {
            throw new EmployeeStorageIsFullException("Достигнуто максимальное количество сотрудников: " + K);
        }
        if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Сотрудник " + employee + " уже добавлен.");
        }
        employeeList.add(employee);
    }

    // Метод для удаления сотрудника по индексу
    public void removeEmployee(int index) {
        if (index >= 0 && index < employeeList.size()) {
            employeeList.remove(index);
        } else {
            throw new IndexOutOfBoundsException("Индекс вне диапазона!");
        }
    }

    // Метод для поиска сотрудника по имени и фамилии
    public Employee findEmployeeByName(String firstName, String lastName) {
        for (Employee employee : employeeList) {
            if (employee.getFirstName().equalsIgnoreCase(firstName) &&
                    employee.getLastName().equalsIgnoreCase(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник с именем " + firstName + " " + lastName + " не найден.");
    }
}