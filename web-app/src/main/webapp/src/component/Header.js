import React, {Component} from "react"
import {Link} from "react-router-dom";
import {Collapse, Nav, Navbar, NavbarBrand, NavbarToggler, NavItem} from 'reactstrap';

export default class Header extends Component {

    constructor(props) {
        super(props);
        this.state = {isOpen: false};
        this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    render() {
        return <Navbar color="dark" dark expand="md">
            <NavbarBrand tag={Link} to="/">Главная</NavbarBrand>
            <NavbarToggler onClick={this.toggle}/>
            <Collapse isOpen={this.state.isOpen} navbar>
                <Nav className="ml-auto" navbar>
                    <NavItem><Link to='/categories'>Меню</Link></NavItem>
                    <NavItem><Link to='/items'>Пицца</Link></NavItem>
                    <NavItem><Link to='/items'>Напитки</Link></NavItem>
                    <NavItem><Link to='/items'>Салаты</Link></NavItem>
                </Nav>
            </Collapse>
        </Navbar>;
    }
}