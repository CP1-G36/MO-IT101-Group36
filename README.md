# MotorPH Payroll System

## Team Details
 
**Group36**  

| Member                  | Contribution                                                                           |
|-------------------------|---------------------------------------------------------------------------------------|
| John Vincent Valladores | Main programmer; responsible for integrating modules and finalizing the system        |
| Jose Mari Malapira      | Assisted in programming and system integration                                        |
| Josue Elijah Lanon      | Contributed to README documentation and code comments                                 |
| Jovy Ambongan           | Contributed to README documentation and code comments                                 |
| All Members             | Participated in program logic and system design discussions and conducted unit testing |

The system was developed through a collaborative process among the group members. At the early stage of the project, all members participated in **program logic and system design discussions** to determine the structure, workflow, and overall approach of the system.

After establishing the design, each member developed individual code components. These components were later consolidated into a single working system.

John Vincent Valladores served as the **main programmer**, responsible for integrating the different modules and finalizing the overall system. Jose Mari Malapira assisted in the programming process and supported the system integration.

Josue Elijah Lanon and Jovy Ambongan contributed to improving the project's documentation and readability by preparing the **README file** and adding **code comments** throughout the program.

Finally, **unit testing** was conducted collaboratively by all group members to verify the correctness and reliability of the system.

---

## Program Details

### Overview

The **MotorPH Payroll System** is a Java console-based application that simulates the payroll processing of MotorPH employees. The system authenticates users, retrieves employee and attendance data from CSV files, and computes payroll including government deductions.

The system supports two types of users:  

- **Employee**  
- **Payroll Staff**  

Payroll is processed for the months **June to December**, with two payroll cutoffs per month.

---

### System Credentials

| User Type     | Username      | Password |
|---------------|---------------|----------|
| Employee      | employee      | 12345    |
| Payroll Staff | payroll_staff | 12345    |

---

### Login System

When the program starts, the user is prompted to enter a username and password.

#### Login Validation

- If the credentials match the **Employee account**, the system proceeds to the **Employee System**.  
- If the credentials match the **Payroll Staff account**, the system proceeds to the **Payroll System**.  
- If the credentials are incorrect, the system displays: `"Incorrect username and/or password."` The program then terminates.

---

## Employee System

The **Employee System** allows employees to view their personal information stored in the system.

### Menu

- Enter your Employee Number  
- Type `exit` to Exit the Program  

### Process

The system reads employee records from **data.csv.**  

- If the employee number exists, the system displays:  
  - Employee Number  
  - Employee Name  
  - Birthday  

- If the employee number does not exist, the system displays: `"Employee number does not exist."`  
- Typing `exit` terminates the Employee System.

---

## Payroll System

The Payroll System is accessible to payroll staff and allows payroll processing.

### Main Menu

1. Process Payroll  
2. Exit the Program  

*Invalid input:* `"Invalid option. Please try again."`

#### Process Payroll Menu

1. One Employee  
2. All Employees  
3. Exit the Program  

*Invalid input:* `"Invalid option. Please try again."`

---

## One Employee Payroll

This option calculates payroll for a **single employee.**

### Input

- Enter Employee Number  
- Type `exit` to Exit the Program  

- If the employee number does not exist, the system displays: `"Employee number does not exist."`  
- If the employee number is valid, the system displays the employee's:  
  - Employee Number  
  - Employee Name  
  - Birthday  

The system then calculates payroll for each month from **June to December.**

### Payroll Cutoff Periods

Each month contains two payroll cutoff periods.

#### First Cutoff - 1st to 15th day of the month

Displayed information:  

- Cutoff Date  
- Total Hours Worked  
- Gross Salary  
- Net Salary  

*No deductions are applied during the first cutoff.*

#### Second Cutoff - 16th to the last day of the month

Displayed information:  

- Cutoff Date  
- Total Hours Worked  
- Gross Salary  
- SSS Contribution  
- PhilHealth Contribution  
- PAG-IBIG Contribution  
- Tax  
- Total Deductions  
- Net Salary  

*Government deductions are applied during the second cutoff.*

---

## Attendance Processing

Employee attendance records are retrieved from **attendance.csv.**

| Rule                     | Description                                  |
|---------------------------|----------------------------------------------|
| Work hours counted        | 8:00 AM – 5:00 PM                            |
| Maximum daily hours       | 8 hours                                      |
| Overtime                  | Not included                                 |
| Late rule                 | Login at **8:11 AM or later** is considered late |
| Break deduction           | 1 hour lunch break                           |

The system calculates the total worked hours for each cutoff period.

---

## Salary Computation

### Gross Salary

Gross Salary = Total Hours Worked × Hourly Rate


The hourly rate is retrieved from **data.csv.**

### Net Salary

For the second cutoff, the net salary is computed as:


Net Salary = Gross Salary − Total Deductions


### Government Contributions

The system calculates the following mandatory deductions:  

- **SSS** – retrieved from the sss.csv contribution table  
- **PhilHealth** – calculated based on the employee's monthly basic salary  
- **PAG-IBIG** – calculated based on the employee's salary with a maximum contribution cap of 100  
- **Withholding Tax** – computed using the Philippine withholding tax brackets after deductions  

These deductions are included in the **second cutoff payroll computation.**

---

## All Employees Payroll

Selecting **All Employees** processes payroll for **all employees listed in data.csv.**

For each employee, the system displays the following information:  

- Employee Number  
- Employee Name  
- Birthday  

The system then generates payroll records for each month from **June to December**, with **two payroll cutoffs per month.**

### First Cutoff (1–15)

- Cutoff Date  
- Total Hours Worked  
- Gross Salary  
- Net Salary  

### Second Cutoff (16–end of month)

- Cutoff Date  
- Total Hours Worked  
- Gross Salary  
- SSS Contribution  
- PhilHealth Contribution  
- PAG-IBIG Contribution  
- Withholding Tax  
- Total Deductions  
- Net Salary  

This process repeats for every month from **June to December** for each employee in the system.

---

## Files Used

| File           | Purpose                                              |
|----------------|------------------------------------------------------|
| data.csv       | Employee information, salary, and hourly rate       |
| attendance.csv | Employee login and logout records                   |
| sss.csv        | SSS contribution table                              |

---

## Technologies Used

- Java  
- CSV File Processing  
- Java File I/O (BufferedReader / FileReader)  
- Console-based user interface

  ---

## Project Plan Link

https://github.com/CP1-G36/MO-IT101-Group36.git
