import React, { Component } from 'react'
import IdentifiedObjectService from '../services/IdentifiedObjectService';

class UpdateIdentifiedObjectComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateIdentifiedObject = this.updateIdentifiedObject.bind(this);

    }

    componentDidMount(){
        IdentifiedObjectService.getIdentifiedObjectById(this.state.id).then( (res) =>{
            let identifiedObject = res.data;
            this.setState({
            });
        });
    }

    updateIdentifiedObject = (e) => {
        e.preventDefault();
        let identifiedObject = {
            identifiedObjectId: this.state.id,
        };
        console.log('identifiedObject => ' + JSON.stringify(identifiedObject));
        console.log('id => ' + JSON.stringify(this.state.id));
        IdentifiedObjectService.updateIdentifiedObject(identifiedObject).then( res => {
            this.props.history.push('/identifiedObjects');
        });
    }


    cancel(){
        this.props.history.push('/identifiedObjects');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update IdentifiedObject</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateIdentifiedObject}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateIdentifiedObjectComponent
