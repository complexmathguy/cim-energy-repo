import React, { Component } from 'react'
import RegularIntervalScheduleService from '../services/RegularIntervalScheduleService'

class ViewRegularIntervalScheduleComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            regularIntervalSchedule: {}
        }
    }

    componentDidMount(){
        RegularIntervalScheduleService.getRegularIntervalScheduleById(this.state.id).then( res => {
            this.setState({regularIntervalSchedule: res.data});
        })
    }

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View RegularIntervalSchedule Details</h3>
                    <div className = "card-body">
                    </div>
                </div>
            </div>
        )
    }
}

export default ViewRegularIntervalScheduleComponent
