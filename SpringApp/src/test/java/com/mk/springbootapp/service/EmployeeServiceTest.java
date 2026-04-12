package com.mk.springbootapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mk.springbootapp.model.Employee;
import com.mk.springbootapp.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	@Mock
    private EmployeeRepository employeeRepository; // ✅ mock dependency

    @InjectMocks
    private EmployeeServiceImpl employeeService;
	
	@Test
	public void myFirstTest() {
		// Arrange
        Employee employee = new Employee("Manoj", "Developer");

        when(employeeRepository.save(employee)).thenReturn(employee);

        // Act
        Employee savedEmployee = employeeService.saveEmployee(employee);
		
		assertNotNull(savedEmployee);
        assertEquals("Manoj", savedEmployee.getName());
        
        //checks how many time repo is called
        verify(employeeRepository, times(1)).save(employee);
	}
	
	@Test
	void deleteEmployee_shouldDeleteEmployee() {
		// Arrange
		Long employeeId = 1L;

		doNothing().when(employeeRepository).deleteById(employeeId);

		// Act
		employeeService.deleteEmployee(employeeId);

		// Assert
		verify(employeeRepository, times(1)).deleteById(employeeId);
	}
}
