package org.example;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Метод для добавления сотрудника
    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        employeeService.addEmployee(newEmployee); // Если коллекция переполнена или сотрудник уже существует, выбросится исключение
        return newEmployee; // Возвращаем объект в формате JSON
    }

    // Метод для удаления сотрудника
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employeeToRemove = employeeService.findEmployeeByName(firstName, lastName); // Найти сотрудника
        employeeService.removeEmployee(employeeService.getEmployees().indexOf(employeeToRemove)); // Удалить сотрудника по индексу
        return employeeToRemove; // Возвращаем объект в формате JSON
    }

    // Метод для поиска сотрудника
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.findEmployeeByName(firstName, lastName); // Найти и вернуть сотрудника
    }
}