package model;

import java.sql.Date;
import javafx.beans.property.*;

public class Employee {
	 //Declare Employees Table Columns
    private IntegerProperty employeeId;
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty email;
    private StringProperty phoneNumber;
    private SimpleObjectProperty<Date> hireDate;
    private IntegerProperty salary;
    private IntegerProperty managerId;
    private IntegerProperty departmentId;

    //Constructor
    public Employee() {
        this.employeeId = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.phoneNumber = new SimpleStringProperty();
        this.hireDate = new SimpleObjectProperty<>();
        this.salary = new SimpleIntegerProperty();
        this.managerId = new SimpleIntegerProperty();
        this.departmentId = new SimpleIntegerProperty();
    }

	public final IntegerProperty employeeIdProperty() {
		return this.employeeId;
	}
	

	public final int getEmployeeId() {
		return this.employeeIdProperty().get();
	}
	

	public final void setEmployeeId(final int employeeId) {
		this.employeeIdProperty().set(employeeId);
	}
	

	public final StringProperty firstNameProperty() {
		return this.firstName;
	}
	

	public final String getFirstName() {
		return this.firstNameProperty().get();
	}
	

	public final void setFirstName(final String firstName) {
		this.firstNameProperty().set(firstName);
	}
	

	public final StringProperty lastNameProperty() {
		return this.lastName;
	}
	

	public final String getLastName() {
		return this.lastNameProperty().get();
	}
	

	public final void setLastName(final String lastName) {
		this.lastNameProperty().set(lastName);
	}
	

	public final StringProperty emailProperty() {
		return this.email;
	}
	

	public final String getEmail() {
		return this.emailProperty().get();
	}
	

	public final void setEmail(final String email) {
		this.emailProperty().set(email);
	}
	

	public final StringProperty phoneNumberProperty() {
		return this.phoneNumber;
	}
	

	public final String getPhoneNumber() {
		return this.phoneNumberProperty().get();
	}
	

	public final void setPhoneNumber(final String phoneNumber) {
		this.phoneNumberProperty().set(phoneNumber);
	}
	

	public final SimpleObjectProperty<Date> hireDateProperty() {
		return this.hireDate;
	}
	

	public final Date getHireDate() {
		return this.hireDateProperty().get();
	}
	

	public final void setHireDate(final Date hireDate) {
		this.hireDateProperty().set(hireDate);
	}
	

	public final IntegerProperty salaryProperty() {
		return this.salary;
	}
	

	public final int getSalary() {
		return this.salaryProperty().get();
	}
	

	public final void setSalary(final int salary) {
		this.salaryProperty().set(salary);
	}
	

	public final IntegerProperty managerIdProperty() {
		return this.managerId;
	}
	

	public final int getManagerId() {
		return this.managerIdProperty().get();
	}
	

	public final void setManagerId(final int managerId) {
		this.managerIdProperty().set(managerId);
	}
	

	public final IntegerProperty departmentIdProperty() {
		return this.departmentId;
	}
	

	public final int getDepartmentId() {
		return this.departmentIdProperty().get();
	}
	

	public final void setDepartmentId(final int departmentId) {
		this.departmentIdProperty().set(departmentId);
	}
	

}
