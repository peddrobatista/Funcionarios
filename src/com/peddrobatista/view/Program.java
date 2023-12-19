package com.peddrobatista.view;

import com.peddrobatista.classes.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        // Parte 1: Lendo os dados

        System.out.print("Quantos funcionários serão cadastrados?");
        int n = teclado.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.println("Employee #" + i + ": ");

            System.out.print("Id: ");
            int id = teclado.nextInt();

            while (hasId(list, id)) {
                System.out.print("Id já existente, tente novamente: ");
                id = teclado.nextInt();
            }

            System.out.print("Nome: ");
            teclado.nextLine();
            String name = teclado.nextLine();
            System.out.print("Salário: ");
            double salary = teclado.nextDouble();
            list.add(new Employee(id, name, salary));
        }

        // PARTE 2 - ATUALIZAÇÃO DO SALÁRIO DE DETERMINADO FUNCIONÁRIO:

        System.out.println();
        System.out.print("Informe o CPF do funcionário que terá aumento salarial: ");
        int id = teclado.nextInt();

        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if (emp == null) {
            System.out.println("Esse id não existe! ");
        } else {
            System.out.print("Digite a porcentagem: ");
            double percentage = teclado.nextDouble();
            emp.increaseSalary(percentage);
        }

        // PARTE 3 - LISTAGEM DE FUNCIONÁRIOS:

        System.out.println();
        System.out.println("Lista de funcionários: ");
        for (Employee obj: list) {
            System.out.println(obj);
        }

        teclado.close();
    }

    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }

}
