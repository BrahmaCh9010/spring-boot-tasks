import React from 'react'
import { Form} from "react-router-dom";
import MainLayout from '../Layout/MainLayout'


function Login() {

    return (
        <MainLayout>
            <div className='login-main'>
                <div className='login-box'>
                    <Form method="post" id="login-form">
                       

                    </Form>


                </div>
            </div>
        </MainLayout>
    )
}

export default Login