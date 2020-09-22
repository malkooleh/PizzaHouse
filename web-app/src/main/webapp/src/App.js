import React, {Component} from 'react';
import CategoryList from './component/CategoryList'
import ItemList from "./component/ItemList";

class App extends Component {

    state = {
        selectedCategory: 1,
        error: false
    };

    componentDidCatch(error, errorInfo) {
        this.state = ({
            error: true
        })
    }

    onCategorySelected = (id) => {
        this.setState({selectedCategory: id})
    };

    render() {

        if (this.state.error) {
            return <div>Something happened wrong. Please try again later</div>
        }

        return (
            <div>
                <CategoryList onCategorySelected={this.onCategorySelected}/>
                <ItemList categoryId={this.state.selectedCategory}/>
            </div>
        );
    }
}

export default App;
