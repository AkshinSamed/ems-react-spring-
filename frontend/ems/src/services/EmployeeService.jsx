import axios from 'redaxios';

const EMPLOYEE_BASE_REST_API_URL = 'http://localhost:8080/api/v1/employees';
const EMPLOYEE_ADD_REST_API_URL = 'http://localhost:8080/api/v1/employees/new';

class EmployeeService{

    getAllEmployees(){
        return axios.get(EMPLOYEE_BASE_REST_API_URL);
    }

    createEmployee(employee){
        return axios.post(EMPLOYEE_ADD_REST_API_URL, employee);
    }

    updateEmployee(employeeId, employee){
        return axios.put(EMPLOYEE_BASE_REST_API_URL + '/' + employeeId, employee);
    }

    deleteEmployee(employeeId){
        return axios.delete(EMPLOYEE_BASE_REST_API_URL + '/' + employeeId);
    }
}

export default new EmployeeService();