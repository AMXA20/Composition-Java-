package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("MM/yyyy");
		System.out.print("Enter department's name: ");
		String departmentName = sc.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(level), baseSalary, new Department(departmentName));
		System.out.println("Department: "+ worker.getDepartment().getName());
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i<n;i++){
			System.out.println("Enter contract #"+(i+1)+" data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date date = sdf1.parse(sc.nextLine());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Durantion (hours): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(date, valuePerHour, hours);
			sc.nextLine();
			worker.addContract(contract);
		}
		
		System.out.print("\n\nEnter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: "+ worker.getName());
		System.out.println("Department: "+ worker.getDepartment().getName());
		System.out.print("Income for "+monthAndYear+": "+String.format("%.2f", worker.income(year, month)));
		
		/*******************************************************************************
		 * MINHA FORMA
		 * System.out.print("\n\nEnter month and year to calculate income (MM/YYYY): ");
		Date date = sdf2.parse(sc.nextLine());
		System.out.println("Name: "+ worker.getName());
		System.out.println("Department: "+ worker.getDepartment().getName());
		System.out.print("Income for "+sdf1.format(date)+": "+worker.income(date));*/
		
		sc.close();
	}

}
