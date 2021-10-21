async function  login(){
			//alert("Hey");

	     let user = {
            username: document.getElementById('username').value,
            password: document.getElementById('password').value,
        };
		//alert("Hello");

		await asynchFunction();
		//
        async function asynchFunction() {
	
			/*console.log(user);*/
			let url = "/Project01/LoginServlet";
            let response = await fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charaset=utf-8'
                },
                body: JSON.stringify(user)

	
            }).then((response) => {
			console.log(response);	
			console.log(login.username);
			console.log(JSON.stringify(response));
	
			if(response.redirected){
				alert('Login Successful');
				window.location.href= response.url;				
			}
			else{
				alert("Incorrect username/password");
			}
			
            }).catch((error) => {
                console.error(error);
            })
        }
	
}

