import React, { Component } from 'react'
import OperationalLimitTypeService from '../services/OperationalLimitTypeService';

class CreateOperationalLimitTypeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
                direction: '',
                limitType: ''
        }
        this.changeDirectionHandler = this.changeDirectionHandler.bind(this);
        this.changeLimitTypeHandler = this.changeLimitTypeHandler.bind(this);
    }

    // step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            OperationalLimitTypeService.getOperationalLimitTypeById(this.state.id).then( (res) =>{
                let operationalLimitType = res.data;
                this.setState({
                    direction: operationalLimitType.direction,
                    limitType: operationalLimitType.limitType
                });
            });
        }        
    }
    saveOrUpdateOperationalLimitType = (e) => {
        e.preventDefault();
        let operationalLimitType = {
                operationalLimitTypeId: this.state.id,
                direction: this.state.direction,
                limitType: this.state.limitType
            };
        console.log('operationalLimitType => ' + JSON.stringify(operationalLimitType));

        // step 5
        if(this.state.id === '_add'){
            operationalLimitType.operationalLimitTypeId=''
            OperationalLimitTypeService.createOperationalLimitType(operationalLimitType).then(res =>{
                this.props.history.push('/operationalLimitTypes');
            });
        }else{
            OperationalLimitTypeService.updateOperationalLimitType(operationalLimitType).then( res => {
                this.props.history.push('/operationalLimitTypes');
            });
        }
    }
    
    changeDirectionHandler= (event) => {
        this.setState({direction: event.target.value});
    }
    changeLimitTypeHandler= (event) => {
        this.setState({limitType: event.target.value});
    }

    cancel(){
        this.props.history.push('/operationalLimitTypes');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add OperationalLimitType</h3>
        }else{
            return <h3 className="text-center">Update OperationalLimitType</h3>
        }
    }
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> Direction: </label>
                                            #formFields( $attribute, 'create')
                                            <label> LimitType: </label>
                                            #formFields( $attribute, 'create')
                                        </div>

                                        <button className="btn btn-success" onClick={this.saveOrUpdateOperationalLimitType}>Save</button>
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

export default CreateOperationalLimitTypeComponent
