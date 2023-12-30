import React, { Component } from 'react'
import AngleRadiansService from '../services/AngleRadiansService';

class UpdateAngleRadiansComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
                multiplier: '',
                unit: ''
        }
        this.updateAngleRadians = this.updateAngleRadians.bind(this);

        this.changeMultiplierHandler = this.changeMultiplierHandler.bind(this);
        this.changeUnitHandler = this.changeUnitHandler.bind(this);
    }

    componentDidMount(){
        AngleRadiansService.getAngleRadiansById(this.state.id).then( (res) =>{
            let angleRadians = res.data;
            this.setState({
                multiplier: angleRadians.multiplier,
                unit: angleRadians.unit
            });
        });
    }

    updateAngleRadians = (e) => {
        e.preventDefault();
        let angleRadians = {
            angleRadiansId: this.state.id,
            multiplier: this.state.multiplier,
            unit: this.state.unit
        };
        console.log('angleRadians => ' + JSON.stringify(angleRadians));
        console.log('id => ' + JSON.stringify(this.state.id));
        AngleRadiansService.updateAngleRadians(angleRadians).then( res => {
            this.props.history.push('/angleRadianss');
        });
    }

    changeMultiplierHandler= (event) => {
        this.setState({multiplier: event.target.value});
    }
    changeUnitHandler= (event) => {
        this.setState({unit: event.target.value});
    }

    cancel(){
        this.props.history.push('/angleRadianss');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update AngleRadians</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Multiplier: </label>
                                            #formFields( $attribute, 'update')
                                            <label> Unit: </label>
                                            #formFields( $attribute, 'update')
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateAngleRadians}>Save</button>
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

export default UpdateAngleRadiansComponent
