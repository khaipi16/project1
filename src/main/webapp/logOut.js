async function logOut() {
	
			/*console.log(user);*/
			let url = "/Project01/LogOutServlet";
            let response = await fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charaset=utf-8'
                },
	
            }).then((response) => {
	
			if(response.redirected){	
				alert('You have successfully logged out');
				window.location.href= response.url;				
			}		
            }).catch((error) => {
                console.error(error);
            })
        }
	