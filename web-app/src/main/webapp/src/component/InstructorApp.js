import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
// import LoginComponent from './LoginComponent';
// import LogoutComponent from './LogoutComponent';
// import AuthenticatedRoute from './AuthenticatedRoute';

class InstructorApp extends Component {

    render() {
        return (
            <>
                <Router>
                    <>
                        {/*<MenuComponent />*/}
                        {/*<Switch>*/}
                        {/*    <Route path="/" exact component={LoginComponent} />*/}
                        {/*    <Route path="/login" exact component={LoginComponent} />*/}
                        {/*    <AuthenticatedRoute path="/logout" exact component={LogoutComponent} />*/}
                        {/*    /!*<AuthenticatedRoute path="/courses" exact component={ListCoursesComponent} />*!/*/}
                        {/*</Switch>*/}
                    </>
                </Router>
            </>
        )
    }
}

export default InstructorApp