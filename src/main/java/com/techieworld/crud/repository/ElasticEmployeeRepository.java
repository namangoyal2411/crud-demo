package com.techieworld.crud.repository;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.DeleteRequest;
import co.elastic.clients.elasticsearch.core.DeleteResponse;
import co.elastic.clients.elasticsearch.core.GetRequest;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.UpdateRequest;
import co.elastic.clients.elasticsearch.core.UpdateResponse;
import com.techieworld.crud.dto.EmployeeTO;
import com.techieworld.crud.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class ElasticEmployeeRepository implements EmployeeCrudRepository {

    private final ElasticsearchClient elasticsearchClient;

    public ElasticEmployeeRepository(ElasticsearchClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    private Employee mapToEmployee(EmployeeTO employeeTO) {
        return Employee.builder()
                .id(employeeTO.getId())
                .empName(employeeTO.getEmpName())
                .salary(employeeTO.getSalary())
                .loction(employeeTO.getLoction())
                .build();
    }

    @Override
    public Employee getEmployee(String employeeId) {
        try {
            GetRequest getRequest = GetRequest.of(g -> g.index("employees").id(employeeId));
            GetResponse<Employee> response = elasticsearchClient.get(getRequest, Employee.class);

            if (response.found()) {
                Employee emp = response.source();
                emp.setId(response.id());
                return emp;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Employee createEmployee(EmployeeTO employeeTO) {
        Employee employee = mapToEmployee(employeeTO);
        try {
            IndexRequest<Employee> request = IndexRequest.of(i -> i
                    .index("employees")
                    .id(employee.getId())
                    .document(employee)
            );

            IndexResponse response = elasticsearchClient.index(request);
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Employee updateEmployee(EmployeeTO employeeTO) {
        Employee employee = mapToEmployee(employeeTO);
        try {
            UpdateRequest<Employee, Employee> request = UpdateRequest.of(u -> u
                    .index("employees")
                    .id(employee.getId())
                    .doc(employee)
                    .docAsUpsert(true)
            );

            UpdateResponse<Employee> response = elasticsearchClient.update(request, Employee.class);
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteEmployee(String employeeId) {
        try {
            DeleteRequest request = DeleteRequest.of(d -> d
                    .index("employees")
                    .id(employeeId)
            );

            DeleteResponse response = elasticsearchClient.delete(request);

            return response.result().name().equalsIgnoreCase("deleted");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
