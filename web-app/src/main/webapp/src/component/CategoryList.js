import React, {Component} from 'react';
import {Button, ButtonGroup, Container, Table} from 'reactstrap';

class CategoryList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isLoading: false,
            categories: []
        };
        this.remove = this.remove.bind(this);
    }

    componentDidMount() {
        this.setState({isLoading: true});

        this.extractCategories();
    }

    extractCategories() {
        fetch('/web-app/categories')
            .then(response => response.json())
            .then(data => this.setState({categories: data, isLoading: false}));
    }

    async remove(id) {
        await fetch(`/web-app/category/remove/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedCategories = [...this.state.categories].filter(i => i.id !== id);
            this.setState({categories: updatedCategories});
        });
    }

    render() {
        const {categories, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }

        const categoryList = categories.map(category => {
            return <tr key={category.id}>
                <td style={{whiteSpace: 'nowrap'}}
                    onClick={() => this.props.onCategorySelected(category.id)}>
                    {category.name}
                </td>
                <td>
                    <ButtonGroup>
                        {/*<Button size="sm" color="primary" tag={Link} to={"/category/edit/" + category.id}>Edit</Button>*/}
                        <Button size="sm" color="primary">Edit</Button>
                        <Button size="sm" color="danger" onClick={() => this.remove(category.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>
        });

        return (
            <div>
                {/*<AppNavbar/>*/}
                <Container fluid>
                    <h3>Catalog</h3>
                    <Table className="mt-4">
                        <thead>
                        <tr>
                            <th width="20%">Name</th>
                        </tr>
                        </thead>
                        <tbody>
                        {categoryList}
                        </tbody>
                    </Table>
                </Container>
            </div>
        );
    }
}

export default CategoryList;