import React, { Component } from 'react'
import PFVArType1IEEEVArControllerService from '../services/PFVArType1IEEEVArControllerService';

class UpdatePFVArType1IEEEVArControllerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updatePFVArType1IEEEVArController = this.updatePFVArType1IEEEVArController.bind(this);

    }

    componentDidMount(){
        PFVArType1IEEEVArControllerService.getPFVArType1IEEEVArControllerById(this.state.id).then( (res) =>{
            let pFVArType1IEEEVArController = res.data;
            this.setState({
            });
        });
    }

    updatePFVArType1IEEEVArController = (e) => {
        e.preventDefault();
        let pFVArType1IEEEVArController = {
            pFVArType1IEEEVArControllerId: this.state.id,
        };
        console.log('pFVArType1IEEEVArController => ' + JSON.stringify(pFVArType1IEEEVArController));
        console.log('id => ' + JSON.stringify(this.state.id));
        PFVArType1IEEEVArControllerService.updatePFVArType1IEEEVArController(pFVArType1IEEEVArController).then( res => {
            this.props.history.push('/pFVArType1IEEEVArControllers');
        });
    }


    cancel(){
        this.props.history.push('/pFVArType1IEEEVArControllers');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update PFVArType1IEEEVArController</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updatePFVArType1IEEEVArController}>Save</button>
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

export default UpdatePFVArType1IEEEVArControllerComponent
