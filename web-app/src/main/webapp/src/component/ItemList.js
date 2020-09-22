import React, {Component} from 'react';
import Container from "reactstrap/es/Container";
import {Table} from "reactstrap";

class ItemList extends Component {

    state = {
        isLoading: true,
        items: []
    };

    componentDidMount() {
        this.getItemListByCategory();
    }

    componentDidUpdate(prevProps, prevState, snapshot) {
        if (this.props.categoryId !== prevProps.categoryId) {
            this.getItemListByCategory();
        }

    }

    async getItemListByCategory() {
        const {categoryId} = this.props;
        if (!categoryId) {
            return;
        }

        await fetch(`/web-app/items/byCategory/${categoryId}`, {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then(data => this.setState({items: data, isLoading: false}));
    }

    render() {
        const {items, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const itemList = items.map(item => {
            return <tr key={item.id}>
                <td style={{whiteSpace: 'nowrap'}}>{item.name}</td>
                <td>{item.unitPrice}</td>
            </tr>
        });

        return (
            <div>
                <Container>
                    <h3>Items</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="20%">Name</th>
                            <th width="20%">Price</th>
                        </tr>
                        </thead>
                        <tbody>
                        {itemList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default ItemList;
