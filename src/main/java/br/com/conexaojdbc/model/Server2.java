package br.com.conexaojdbc.model;

import br.com.conexaojdbc.model.entity.Company;
import br.com.conexaojdbc.model.entity.Individual;
import br.com.conexaojdbc.model.entity.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Server2 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        List<TaxPayer> taxPayerList = new ArrayList<>();

        System.out.print("Enter the number of Taxpayers: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < n; i++) {

            System.out.printf("Taxpayer #%d data: ", i + 1);
            System.out.println();
            System.out.print("Individual or Company (i/c)?: ");
            char resp = scanner.next().charAt(0);

            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("Annual Income: ");
            double annulIncome = scanner.nextDouble();

            if (resp == 'i') {
                System.out.print("Health Expenditures: ");
                Double healthExpenditures = scanner.nextDouble();
                taxPayerList.add(new Individual(name, annulIncome, healthExpenditures));

            } else if (resp == 'c') {
                System.out.print("Number of Employees: ");
                int numberOfEmployees = scanner.nextInt();
                taxPayerList.add(new Company(name, annulIncome, numberOfEmployees));
            }else{
                System.out.println("Invalid!");
            }

        }

        System.out.println("--- LIST OF TAXPAYERS ---");
        for(TaxPayer taxPayer : taxPayerList){
            System.out.println(String.format(taxPayer.getName()) + " - Tax: $ " + taxPayer.tax());
        }
    }

}
