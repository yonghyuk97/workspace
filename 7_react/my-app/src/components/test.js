import React, { useState, useContext } from 'react';
import UserContext from '../contexts/UserContext';


const User = ()=> {

    const {user} = useContext(UserContext);


    return(
        <ul>
            <li>{user.name}</li>
            <li>{user.email}</li>
        </ul>
    );
}





const Profile = ()=>{
    
    const [user, setUser] = useState(null);
    
    const print = () => {
        
        setUser({name: '최용혁', email : 'yonghyuk97@gmail.com'});
        
    }
    
    const hide =()=> {
        setUser(null);
    };
        
    return(
        <UserContext.Provider value={ {user} }>
            <div>
                {user != null ? (
                    <>
                        <User/>
                        <button onClick={hide}>개인 정보 숨기기</button>
                    </>

                ) : (

                    <button onClick={print}>개인 정보 출력</button>
                )}
            </div>
        </UserContext.Provider>
    );


};

export default Profile;
