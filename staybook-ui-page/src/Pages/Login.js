import React from 'react'
import { Form } from "react-router-dom";
import MainLayout from '../Layout/MainLayout'



class Login extends React.Component {
    render() {
        return (<MainLayout>
            <div className='login-main'>
                <div className='login-box'>
                    <Form method="post" id="login-form">
                        <h1>Login</h1>

                    </Form>


                </div>
            </div>
        </MainLayout>);
    }
}


export default Login