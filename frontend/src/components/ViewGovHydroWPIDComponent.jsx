import React, { Component } from 'react'
import GovHydroWPIDService from '../services/GovHydroWPIDService'

class ViewGovHydroWPIDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            govHydroWPID: {}
        }
    }

    componentDidMount(){
        GovHydroWPIDService.getGovHydroWPIDById(this.state.id).then( res => {
            this.setState({govHydroWPID: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View GovHydroWPID Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewGovHydroWPIDComponent
