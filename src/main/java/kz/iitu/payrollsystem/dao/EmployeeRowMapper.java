package kz.iitu.payrollsystem.dao;

import kz.iitu.payrollsystem.model.Employee;
import kz.iitu.payrollsystem.model.EmployeeType;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

        Employee empl = new Employee();

        empl.setId(resultSet.getInt("id"));
        empl.setName(resultSet.getString("name"));
        empl.setSalary(resultSet.getDouble("salary"));
        empl.setType(EmployeeType.valueOf(resultSet.getString("type")));

        return empl;
    }

    @Override
    public int[] getRowsForPaths(TreePath[] path) {
        return new int[0];
    }
}
