/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package motorph;

import java.io.*;
import java.util.*;

public class MotorPH {

    Scanner scanner = new Scanner(System.in);

     // =========================
     // VALID LOGIN CREDENTIALS
     // =========================

    // Employee account credentials
    String employeeUser = "employee";
    String employeePass = "12345";
    
    // Payroll staff account credentials
    String payrollUser = "payroll_staff";
    String payrollPass = "12345";

    public static void main(String[] args) {

        MotorPH system = new MotorPH(); 

        String username = system.login();
        
    // If employee account logs in, go to Employee System
        if (username.equals(system.employeeUser)) {
            system.employeeSystem();
        } 
            
    // If payroll staff logs in, go to Payroll System        
        else if (username.equals(system.payrollUser)) {
            system.payrollSystem();
        }

        system.scanner.close();
    }

    // =========================
    // LOGIN SYSTEM
    // =========================
    public String login() {

    System.out.println("========================================================");
    System.out.println("Welcome to MotorPH");
    System.out.println("========================================================\n");

    // Ask user for username
    System.out.print("Enter Username: ");
    String username = scanner.nextLine().trim();
        
    // Ask user for password
    System.out.print("Enter Password: ");
    String password = scanner.nextLine().trim();
        
    // Check if credentials match employee account
    if (username.equals(employeeUser) && password.equals(employeePass)) {
        return username;
    }
        
    // Check if credentials match payroll staff account
    if (username.equals(payrollUser) && password.equals(payrollPass)) {
        return username;
    }

    // if both are incorrect
    System.out.println("Incorrect username and/or password.");
    System.exit(0);

    return ""; 
}

    // =========================
    // EMPLOYEE SYSTEM
    // =========================
    public void employeeSystem() {

        System.out.println("\n========================================================");
        System.out.println("Welcome to MotorPH Employee System");
        System.out.println("========================================================\n");
    
        // Loop continuously until user exits
        while (true) {

            // Ask for employee number
            System.out.println("Enter your Employee Number");
            System.out.println("Type 'exit' to Exit the Program");
            System.out.print("Input: ");

            String inputId = scanner.nextLine().trim();

            // Exit condition
            if (inputId.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Employee System...");
                break;
            }

            boolean found = false;

            // Read employee data from CSV file
            try (BufferedReader br = new BufferedReader(new FileReader("src/data.csv"))) {

                String line;

                while ((line = br.readLine()) != null) {

                    String[] parts = line.split(",");

                    if (parts.length >= 4) {

                        String employeeNumber = parts[0].trim();
                        String lastName = parts[1].trim();
                        String firstName = parts[2].trim();
                        String birthday = parts[3].trim();

                        // Check if employee number matches user input
                        if (employeeNumber.equals(inputId)) {

                            System.out.println("========================================================");
                            System.out.println("Employee Number: " + employeeNumber);
                            System.out.println("Employee Name: " + lastName + ", " + firstName);
                            System.out.println("Birthday: " + birthday);
                            System.out.println("========================================================");

                            found = true;
                            break;
                        }
                    }
                }

                // If employee not found in file
                if (!found) {
                    System.out.println("Employee number does not exist.");
                }

            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

            System.out.println();
        }
    }

    // =========================
    // PAYROLL SYSTEM
    // =========================
    public void payrollSystem() {
        System.out.println("\n========================================================");
        System.out.println("Welcome to MotorPH Payroll System");
        System.out.println("========================================================\n");

        // Payroll system main menu
        while (true) {
            System.out.println("1. Process Payroll");
            System.out.println("2. Exit the program");
            System.out.print("Select Option: ");

            String input = scanner.nextLine().trim();

            //Exit payroll
            if (input.equals("2")) {
                System.out.println("Exiting Payroll System...");
                return;
                
            //Process payroll
            } else if (input.equals("1")) {

                //Payroll submenu
                while (true) {
                    System.out.println("\n========================================================");
                    System.out.println("MotorPH Payroll Menu");
                    System.out.println("========================================================");
                    System.out.println("\n" + "1. One Employee");
                    System.out.println("2. All Employees");
                    System.out.println("3. Exit the Program");
                    System.out.print("Select Option: ");

                    String option = scanner.nextLine().trim();

                    if (option.equals("1")) {
                        
                    System.out.println("\n========================================================");
                    System.out.println("One Employee");
                    System.out.println("========================================================");
                    
                        oneEmployeePayroll();
                    } else if (option.equals("2")) {

                    System.out.println("\n========================================================");
                    System.out.println("All Employees");
                    System.out.println("========================================================\n");

                        allEmployeesPayroll();
                        return;
                    } else if (option.equals("3")) {
                        System.out.println("Exiting Payroll System...");
                        return;
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }
                }
            } else {
                System.out.println("Invalid option. Please try again.\n");
            }
        }
    }

    // =========================
    // ONE EMPLOYEE PAYROLL
    // =========================
    public void oneEmployeePayroll() {

        // Loop continuously until exit
        while (true) {

            //Ask for employee number
            System.out.println("\nEnter Employee Number");
            System.out.println("Type 'exit' to Exit the Program");
            System.out.print("Input: ");

            String inputId = scanner.nextLine().trim();

            //Exit program
            if (inputId.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Program...");
                System.exit(0);
            }

            boolean found = false;

            // Read employee data file
            try (BufferedReader br = new BufferedReader(new FileReader("src/data.csv"))) {
                String line;

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length >= 4) {
                        String employeeNumber = parts[0].trim();
                        String lastName = parts[1].trim();
                        String firstName = parts[2].trim();
                        String birthday = parts[3].trim();

                        if (employeeNumber.equals(inputId)) {
                            System.out.println("\n========================================================\n");
                            System.out.println("Employee Number: " + employeeNumber);
                            System.out.println("Employee Name: " + lastName + ", " + firstName);
                            System.out.println("Birthday: " + birthday);

                        //Payroll months
                        String[] months = {"June", "July", "August", "September", "October", "November", "December"};

                        //last day of each month
                        int[] lastDays = {30, 31, 31, 30, 31, 30, 31};

                        // Loop through each payroll month
                        for (int i = 0; i < months.length; i++) {

                            // Division and Month Header
                            System.out.println("\n--------------------------------------------------------");
                            System.out.println(months[i] + " Payroll");
                            System.out.println("--------------------------------------------------------\n");
                            
                            int monthNumber = i + 6;

                            // ===================
                            // FIRST PAYOUT (1-15)
                            // ===================

                            // 1st Cutoff Total Worked Hours calculation
                            double hoursFirstHalf = calculateHours(employeeNumber, monthNumber, 1, 15);
                            
                            // Retrieve the employee's hourly rate using their employee number
                            double hourlyRate = getHourlyRate(employeeNumber);

                            // Gross salary calculation
                            double grossFirstHalf = hoursFirstHalf * hourlyRate;

                            // Display Results
                            System.out.println("Cutoff Date: " + months[i] + " 1-15");
                            System.out.println("Total Hours Worked: " + hoursFirstHalf);
                            System.out.println("Gross Salary: " + grossFirstHalf);

                            // No deductions for first cutoff
                            System.out.println("Net Salary: " + grossFirstHalf);
                     
                            // ===============================
                            // SECOND PAYOUT (16-End of month)
                            // ===============================

                            // Second Cutoff Total Worked Hours calculation
                            double hoursSecondHalf = calculateHours(employeeNumber, monthNumber, 16, lastDays[i]);

                            // Gross Salary calculation
                            double grossSecondHalf = hoursSecondHalf * hourlyRate;

                            // Retrieve the employee's basic salary using their employee number
                            double basicSalary = getBasicSalary(employeeNumber);

                            // Sum of 1st and 2nd Cutoff Gross Salary calculation
                            double monthlyGross = grossFirstHalf + grossSecondHalf;
                            
                            //Government Deductions
                            double sss = calculateSSS(monthlyGross);
                            double philhealth = calculatePhilhealth(basicSalary);
                            double pagibig = calculatePagibig(basicSalary);
                            
                            double governmentDeductions = sss + philhealth + pagibig;

                            // Tax
                            double tax = calculateTax(grossFirstHalf, grossSecondHalf, sss, philhealth, pagibig);

                            // Total deductions including tax
                            double totalDeductions = governmentDeductions + tax;

                            // Net salary calculation
                            double netSalary = grossSecondHalf - totalDeductions;

                            // Display Results
                            System.out.println("\nCutoff Date: " + months[i] + " 16-" + lastDays[i]);
                            System.out.println("Total Hours Worked: " + hoursSecondHalf);
                            System.out.println("Gross Salary: " + grossSecondHalf);
                            System.out.println("SSS Contribution: " + sss);
                            System.out.println("Philhealth Contribution: " + philhealth);
                            System.out.println("PAG-IBIG Contribution: " + pagibig);
                            System.out.println("Tax: " + tax);
                            System.out.println("Total Deductions: " + totalDeductions);
                            System.out.println("Net Salary: " + netSalary);

                            } // end month loop

                            System.out.println("\n========================================================");

                            found = true;
                            break;
                        }
                    }
                }

                if (!found) {
                    System.out.println("Employee number does not exist.");
                }

            } catch (IOException e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    // =========================
    // CALCULATE HOURS
    // =========================
    public double calculateHours(String empId, int month, int startDay, int endDay) {

        double totalHours = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("src/attendance.csv"))) {

            br.readLine(); //skip the header

            String line;

            // Read each attendance record
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                String employeeNumber = parts[0].trim();
                String date = parts[3].trim();
                String logIn = parts[4].trim();
                String logOut = parts[5].trim();

                 // Skip if this record does not belong to the requested employee
                if (!employeeNumber.equals(empId)) 
                    continue;

                // Split date into month and day
                String[] dateParts = date.split("/");
                int fileMonth = Integer.parseInt(dateParts[0]);
                int day = Integer.parseInt(dateParts[1]);

                // Skip records that are not within the requested payroll cutoff
                if (fileMonth != month || day < startDay || day > endDay) 
                    continue;

                // Convert login and logout times into minutes
                int logInMin = convertToMinutes(logIn);
                int logOutMin = convertToMinutes(logOut);

                int shiftStart = convertToMinutes("8:00");
                int shiftEnd = convertToMinutes("17:00");
                int lateThreshold = convertToMinutes("8:11"); // late if 8:11 or later

                // Apply grace period for login
                int startTime;
                if (logInMin < lateThreshold) {
                    
                // 8:00–8:10 → treat as 8:00
                    startTime = shiftStart;
                } else {
                    
                // 8:11+ → actual login time
                    startTime = logInMin;
                }
                // Cap logout to shift end (no overtime)
                int endTime = Math.min(logOutMin, shiftEnd);

                // Skip if no work done
                if (endTime <= startTime) {
                    continue;
                }
                // Compute worked minutes
                int workedMinutes = endTime - startTime;

                //Cap at 9 hours (so after break = 8 hours max)
                workedMinutes = Math.min(workedMinutes, 540);

                //Deduct 1-hour break
                workedMinutes = Math.max(workedMinutes - 60, 0);

                // Convert to hours
                double hoursWorked = workedMinutes / 60.0;
                totalHours += hoursWorked;
            }

        } catch (IOException e) {
            System.out.println("Attendance file error: " + e.getMessage());
        }

        return totalHours;
    }
    
    // =========================
    // TIME TO MINUTES
    // =========================
    public int convertToMinutes(String time) {

        // Split time into hour and minute
        String[] parts = time.split(":");

        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        // Convert time into total minutes
        return hour * 60 + minute;
    }
    
    // =========================
    // GET HOURLY RATE
    // =========================
    public double getHourlyRate(String empId) {

        double hourlyRate = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("src/data.csv"))) {

            br.readLine(); 
            String line;

            while ((line = br.readLine()) != null) {

                // List to store parsed CSV columns
                List<String> parts = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                boolean inQuotes = false;

                // Custom CSV parser that respects quoted values
                for (char c : line.toCharArray()) {
                    if (c == '"') {
                        inQuotes = !inQuotes; 
                    } else if (c == ',' && !inQuotes) {
                        parts.add(sb.toString().trim());
                        sb.setLength(0);
                    } else {
                        sb.append(c);
                    }
                }
                
                // Add final column
                parts.add(sb.toString().trim()); 

                // Skip if not enough columns
                if (parts.size() < 19) {
                    continue;
                }

                String employeeNumber = parts.get(0).replace("\"", "").trim();

                if (employeeNumber.equals(empId)) {

                    // Remove commas and quotes
                    String rate = parts.get(18).replace("\"", "").replace(",", "").trim();
                    hourlyRate = Double.parseDouble(rate);
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error reading hourly rate: " + e.getMessage());
        }

        return hourlyRate;
    }

    // =========================
    // PAG-IBIG CONTRIBUTION
    // =========================
    public double calculatePagibig(double basicSalary) {

    double employeeShare;

    // 1% contribution if salary is between 1000 and 1500
    if (basicSalary >= 1000 && basicSalary <= 1500) {
        employeeShare = basicSalary * 0.01;

    // 2% contribution if salary is above 1500
    } else if (basicSalary > 1500) {
        employeeShare = basicSalary * 0.02;
    } else {
        employeeShare = 0;
    }

    // Maximum contribution cap
    if (employeeShare > 100) {
        employeeShare = 100;
    }

    return employeeShare;
}
    // =========================
    // GET BASIC SALARY
    // =========================
    public double getBasicSalary(String empId) {

    double basicSalary = 0;

    try (BufferedReader br = new BufferedReader(new FileReader("src/data.csv"))) {

        br.readLine(); 
        String line;

        while ((line = br.readLine()) != null) {

            List<String> parts = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            boolean inQuotes = false;

            for (char c : line.toCharArray()) {
                if (c == '"') {
                    inQuotes = !inQuotes;
                } else if (c == ',' && !inQuotes) {
                    parts.add(sb.toString().trim());
                    sb.setLength(0);
                } else {
                    sb.append(c);
                }
            }
            parts.add(sb.toString().trim());

            if (parts.size() < 19) continue;

            String employeeNumber = parts.get(0).replace("\"", "").trim();

            if (employeeNumber.equals(empId)) {

                String salary = parts.get(13).replace("\"", "").replace(",", "").trim();
                basicSalary = Double.parseDouble(salary);
                break;
            }
        }

    } catch (Exception e) {
        System.out.println("Error reading salary: " + e.getMessage());
    }

    return basicSalary;
}
    // =========================
    // PHILHEALTH CONTRIBUTION
    // =========================
    public double calculatePhilhealth(double basicSalary) {

    double premium;

     // Minimum premium if salary ≤ 10,000
    if (basicSalary <= 10000) {
        premium = 300;
    } 

    // 3% premium if salary within mid range
    else if (basicSalary <= 59999.99) {

        premium = basicSalary * 0.03;

        // Minimum contribution rule
        if (premium < 300) {
            premium = 300;
        }

        // Maximum contribution rule
        if (premium > 1800) {
            premium = 1800;
        }
    } 

    // Maximum premium cap
    else {
        premium = 1800;
    }

    // employee share (50%)
    return premium / 2;
}
    // =========================
    // SSS CONTRIBUTION
    // =========================
    public double calculateSSS(double monthlyGross) {
        double contribution = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("src/sss.csv"))) {

            br.readLine(); // skip header
            String line;

            while ((line = br.readLine()) != null) {

                // Split CSV manually respecting quotes
                List<String> parts = new ArrayList<>();
                StringBuilder sb = new StringBuilder();
                boolean inQuotes = false;

                for (char c : line.toCharArray()) {
                    if (c == '"') {
                        inQuotes = !inQuotes;
                    } else if (c == ',' && !inQuotes) {
                        parts.add(sb.toString().trim());
                        sb.setLength(0);
                    } else {
                        sb.append(c);
                    }
                }
                parts.add(sb.toString().trim()); // last column

                if (parts.size() < 4) {
                    continue;
                }

                String range = parts.get(0).replace("\"", "").trim();
                String rangeEnd = parts.get(2).replace("\"", "").trim();
                String contributionStr = parts.get(3).replace("\"", "").replace(",", "").trim();

                double value = Double.parseDouble(contributionStr);

                 // Salary below minimum range
                if (range.toLowerCase().startsWith("below")) {
                    // Example: "Below 3,250"
                    String[] tokens = range.split(" ");
                    double upper = Double.parseDouble(tokens[1].replace(",", ""));
                    if (monthlyGross < upper) {
                        contribution = value;
                        break;
                    }

                // Salary above maximum range
                } else if (rangeEnd.equalsIgnoreCase("Over")) {
                    // Example: "24,750"-Over
                    double lower = Double.parseDouble(range.replace(",", ""));
                    if (monthlyGross > lower) {
                        contribution = value;
                        break;
                    }

                // Normal range: "A"-"B"
                } else {
                    double start = Double.parseDouble(range.replace(",", ""));
                    double end = Double.parseDouble(rangeEnd.replace(",", ""));
                    if (monthlyGross >= start && monthlyGross <= end) {
                        contribution = value;
                        break;
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading SSS file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error parsing number in SSS file: " + e.getMessage());
        }

        return contribution;
    }
    
    // =========================
    // WITHHOLDING TAX
    // =========================
    public double calculateTax(double grossFirstHalf, double grossSecondHalf, double sss, double philhealth, double pagibig) {
        
        // Total gross salary for the month
        double monthlyGross = grossFirstHalf + grossSecondHalf;

        // Pre-tax deductions
        double governmentDeductions = sss + philhealth + pagibig;

        // Taxable income
        double taxableIncome = monthlyGross - governmentDeductions;

        double tax = 0;

        // Withholding tax brackets
        if (taxableIncome <= 20832) {
            tax = 0;
        } else if (taxableIncome <= 33332) {
            tax = (taxableIncome - 20833) * 0.20;
        } else if (taxableIncome <= 66666) {
            tax = 2500 + (taxableIncome - 33333) * 0.25;
        } else if (taxableIncome <= 166666) {
            tax = 10833 + (taxableIncome - 66667) * 0.30;
        } else if (taxableIncome <= 666666) {
            tax = 40833.33 + (taxableIncome - 166667) * 0.32;
        } else {
            tax = 200833.33 + (taxableIncome - 666667) * 0.35;
        }

        return tax;
    }
    // =========================
    // ALL EMPLOYEES PAYROLL
    // =========================

    public void allEmployeesPayroll() {

        try (BufferedReader br = new BufferedReader(new FileReader("src/data.csv"))) {

            br.readLine(); 
            String line;

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts.length < 4) {
                    continue;
                }

                String employeeNumber = parts[0].trim();
                String lastName = parts[1].trim();
                String firstName = parts[2].trim();
                String birthday = parts[3].trim();

                System.out.println("========================================================\n");
                System.out.println("Employee Number: " + employeeNumber);
                System.out.println("Employee Name: " + lastName + ", " + firstName);
                System.out.println("Birthday: " + birthday);

                String[] months = {"June", "July", "August", "September", "October", "November", "December"};
                int[] lastDays = {30, 31, 31, 30, 31, 30, 31};

                for (int i = 0; i < months.length; i++) {

                    System.out.println("\n--------------------------------------------------------");
                    System.out.println(months[i] + " Payroll");
                    System.out.println("--------------------------------------------------------\n");

                    int monthNumber = i + 6;

                    double hourlyRate = getHourlyRate(employeeNumber);
                    double basicSalary = getBasicSalary(employeeNumber);

                    // FIRST HALF
                    double hoursFirstHalf = calculateHours(employeeNumber, monthNumber, 1, 15);
                    double grossFirstHalf = hoursFirstHalf * hourlyRate;

                    System.out.println("Cutoff Date: " + months[i] + " 1-15");
                    System.out.println("Total Hours Worked: " + hoursFirstHalf);
                    System.out.println("Gross Salary: " + grossFirstHalf);
                    System.out.println("Net Salary: " + grossFirstHalf);

                    // SECOND HALF
                    double hoursSecondHalf = calculateHours(employeeNumber, monthNumber, 16, lastDays[i]);
                    double grossSecondHalf = hoursSecondHalf * hourlyRate;

                    double monthlyGross = grossFirstHalf + grossSecondHalf;

                    double sss = calculateSSS(monthlyGross);
                    double philhealth = calculatePhilhealth(basicSalary);
                    double pagibig = calculatePagibig(basicSalary);

                    double governmentDeductions = sss + philhealth + pagibig;

                    double tax = calculateTax(grossFirstHalf, grossSecondHalf, sss, philhealth, pagibig);

                    double totalDeductions = governmentDeductions + tax;

                    double netSalary = grossSecondHalf - totalDeductions;

                    System.out.println("\nCutoff Date: " + months[i] + " 16-" + lastDays[i]);
                    System.out.println("Total Hours Worked: " + hoursSecondHalf);
                    System.out.println("Gross Salary: " + grossSecondHalf);
                    System.out.println("SSS Contribution: " + sss);
                    System.out.println("Philhealth Contribution: " + philhealth);
                    System.out.println("PAG-IBIG Contribution: " + pagibig);
                    System.out.println("Tax: " + tax);
                    System.out.println("Total Deductions: " + totalDeductions);
                    System.out.println("Net Salary: " + netSalary);
                }
                    System.out.println("\n========================================================\n");
            }

                  } catch (IOException e) {
                    System.out.println("Error reading employees file: " + e.getMessage());
        }
    }
}




