import React, {Component} from 'react';
import './App.css';

class Employee extends Component {

    state = {
        isLoading: true,
        employees: []
    };

    async componentDidMount() {
        const response = await fetch('/web-app/employees');
        const body = await response.json();
        this.setState({employees: body, isLoading: false});
    }

    render() {
        const {employees, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <div className="App-intro">
                        <h2>Employees</h2>
                        {employees.map(employee =>
                            <div key={employee.id}>
                                {employee.firstName + "_"}
                                {employee.lastName}
                            </div>
                        )}
                    </div>
                </header>
            </div>
        );
    }
}

export default Employee;
