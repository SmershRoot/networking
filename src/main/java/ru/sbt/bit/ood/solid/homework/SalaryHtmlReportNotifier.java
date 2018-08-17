package ru.sbt.bit.ood.solid.homework;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class SalaryHtmlReportNotifier {

    private Connection connection;

    private final String SQL_SELECT="SELECT " +
                "emp.id as emp_id, " +
                "emp.name as emp_name, " +
                "sum(salary) as salary " +
            "FROM employee emp LEFT JOIN" +
                "salary_payments sp on emp.id = sp.employee_id where emp.department_id = ? and" +
                " sp.date >= ? and sp.date <= ? " +
            "GROUP BY emp.id, emp.name";

    public SalaryHtmlReportNotifier(Connection databaseConnection) {
        this.connection = databaseConnection;
    }

    private ResultSet getResultSetSalaryReport(String departmentId, LocalDate dateFrom, LocalDate dateTo){
        // prepare statement with sql
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(SQL_SELECT);
            ps.setString(0, departmentId);
            ps.setDate(1, new java.sql.Date(dateFrom.toEpochDay()));
            ps.setDate(2, new java.sql.Date(dateTo.toEpochDay()));
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public StringBuffer generateHtmlSalaryReport(String departmentId, LocalDate dateFrom, LocalDate dateTo) {
        try {
            ResultSet results = getResultSetSalaryReport(departmentId, dateFrom, dateTo);

            ArrayList<ArrayList<String>> arrayTrTd=new ArrayList<>();
            ArrayList<String> arrayTdValue=new ArrayList<>();
            arrayTdValue.add("Employee");
            arrayTdValue.add("Salary");
            arrayTrTd.add(arrayTdValue);
            double totals = 0;
            while (results.next()) {
                arrayTdValue=new ArrayList<>();
                arrayTdValue.add(results.getString("emp_name"));
                arrayTdValue.add(results.getString("salary"));
                arrayTrTd.add(arrayTdValue);

                totals += results.getDouble("salary");
            }
            arrayTdValue.add("Total");
            arrayTdValue.add(String.valueOf(totals));
            arrayTrTd.add(arrayTdValue);
            StringBuffer stringHtmlTbl = HtmlGeneration.createTableHtml(arrayTrTd);
            StringBuffer resultingHtml = HtmlGeneration.addToHtmlBody(stringHtmlTbl);

            return resultingHtml;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
