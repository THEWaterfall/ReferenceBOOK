package model;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;


public class EmployeeDAO {
	//Insert Employee into DB
	public static void insertEmployee(String name, String lastName, String email, String phoneNumber, int salary, int managerId, int departmentId) {
		//Declare an INSERT statement
		String updateStmt = "INSERT INTO employees\n" +
							"(firstName, lastName, email, phoneNumber, hireDate, salary, managerId, departmentId)\n" +
							"VALUES\n" +
							"('"+name+"', '"+lastName+"','"+email+"','"+phoneNumber+"', CURDATE(), '"+salary+"', '"+managerId+"', '"+departmentId+"')";
		//Execute an INSERT statement
		try {
			DBUtil.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while INSERT Operation");
			e.printStackTrace();
		}
	}
	
	//Delete Employee from DB
	public static void deleteEmpWithId (String empId) {
        //Declare a DELETE statement
        String updateStmt = "DELETE FROM employees\n" +
                            "WHERE id = " + empId;

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation");
        }
    }
	
	//Update Employee
	public static void updateEmployee(String empId, String firstName, String lastName, String email, String phoneNumber, int salary, int managerId, int departmentId) {
		//Declare an UPDATE statement
		String updateStmt = "UPDATE employees\n" +
							"SET firstName = '"+firstName+"', lastName = '"+lastName+"', email = '"+email+"', phoneNumber = '"+phoneNumber+"', salary = '"+salary+"', managerId = '"+managerId+"', departmentId = '"+departmentId+"'\n" +
							"WHERE id = " + empId;
		//Execute an UPDATE statement
		try {
			DBUtil.dbExecuteUpdate(updateStmt);
		} catch (SQLException e) {
			System.out.print("Error occurred while UPDATE Operation");
			e.printStackTrace();
		}
	}
	
	//Search Employee
	  public static Employee searchEmployee (String empId) throws SQLException, ClassNotFoundException {
	        //Declare a SELECT statement
	        String selectStmt = "SELECT * FROM employees WHERE id = " + empId;

	        //Execute SELECT statement
	        try {
	            //Get ResultSet from dbExecuteQuery method
	            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

	            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
	            Employee employee = getEmployeeFromResultSet(rsEmp);

	            //Return employee object
	            return employee;
	        } catch (SQLException e) {
	            System.out.println("While searching an employee with " + empId + " id, an error occurred: " + e);
	            //Return exception
	            throw e;
	        }
	    }

	    //Use ResultSet from DB as parameter and set Employee Object's attributes and return employee object.
	    private static Employee getEmployeeFromResultSet(ResultSet rs) throws SQLException
	    {
	        Employee emp = null;
	        if (rs.next()) {
	            emp = new Employee();
	            emp.setEmployeeId(rs.getInt("id"));
	            emp.setFirstName(rs.getString("firstName"));
	            emp.setLastName(rs.getString("lastName"));
	            emp.setEmail(rs.getString("email"));
	            emp.setPhoneNumber(rs.getString("phoneNumber"));
	            emp.setHireDate(rs.getDate("hireDate"));
	            emp.setSalary(rs.getInt("salary"));
	            emp.setManagerId(rs.getInt("managerId"));
	            emp.setDepartmentId(rs.getInt("departmentId"));
	        }
	        return emp;
	    }

	    //SELECT Employees
	    public static ObservableList<Employee> searchEmployees () throws SQLException, ClassNotFoundException {
	        //Declare a SELECT statement
	        String selectStmt = "SELECT * FROM employees";

	        //Execute SELECT statement
	        try {
	            //Get ResultSet from dbExecuteQuery method
	            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

	            //Send ResultSet to the getEmployeeList method and get employee object
	            ObservableList<Employee> empList = getEmployeeList(rsEmps);

	            //Return employee object
	            return empList;
	        } catch (SQLException e) {
	            System.out.println("SQL select operation has been failed: " + e);
	            //Return exception
	            throw e;
	        }
	    }

	    //Select * from employees operation
	    private static ObservableList<Employee> getEmployeeList(ResultSet rs) throws SQLException, ClassNotFoundException {
	        //Declare a observable List which comprises of Employee objects
	        ObservableList<Employee> empList = FXCollections.observableArrayList();

	        while (rs.next()) {
	            Employee emp = new Employee();
	            emp.setEmployeeId(rs.getInt("id"));
	            emp.setFirstName(rs.getString("firstName"));
	            emp.setLastName(rs.getString("lastName"));
	            emp.setEmail(rs.getString("email"));
	            emp.setPhoneNumber(rs.getString("phoneNumber"));
	            emp.setHireDate(rs.getDate("hireDate"));
	            emp.setSalary(rs.getInt("salary"));
	            emp.setManagerId(rs.getInt("managerId"));
	            emp.setDepartmentId(rs.getInt("departmentId"));
	            //Add employee to the ObservableList
	            empList.add(emp);
	        }
	        //return empList (ObservableList of Employees)
	        return empList;
	    }
	    
	    //Update Employee
}
