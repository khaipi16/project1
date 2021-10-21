	async function createHeader(){
				var tBody = document.getElementById("tHead");
				var head = document.createElement("tr");

				var header = document.createElement("th");
	       	 	header.innerHTML = "Username";
	        	head.appendChild(header);	

				var header = document.createElement("th");
	        	header.innerHTML = "User ID";
	        	head.appendChild(header);

	        	var header = document.createElement("th");
	        	header.innerHTML = "First Name";
	        	head.appendChild(header);

	        	var header = document.createElement("th");
	        	header.innerHTML = "Last Name";
	        	head.appendChild(header);

	        	var header = document.createElement("th");
	        	header.innerHTML = "Email";
	        	head.appendChild(header);

	        	var header = document.createElement("th");
	        	header.innerHTML = "Phone Number";
	        	head.appendChild(header);

				tBody.appendChild(head);
				
			}



			async function viewAccount(){	
			console.log("inside View Account");
			let url = "/Project01/ViewAccount";
            let response = await fetch( url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charaset=utf-8'
                },
              	/*  body: JSON.stringify(user)	*/
            })
			let userInfo = await response.text();
			console.log("account info list ");
			console.log(userInfo);
	
			var accountInfo = JSON.parse(userInfo);
			console.log("JSON");
			console.log(accountInfo);
			
			if(accountInfo.length == 0){
				alert("There is no account to view.");
				
			}
			else{
				createHeader();
				var tBody = document.getElementById("tBody");
					
				var row = document.createElement("tr");

	        	var data = document.createElement("td");
	       	 	data.innerHTML = accountInfo.username;
	        	row.appendChild(data);

				var data = document.createElement("td");
	        	data.innerHTML = accountInfo.UserID;
	        	row.appendChild(data);   

	        	var data = document.createElement("td");
	        	data.innerHTML = accountInfo.firstname;
	        	row.appendChild(data);    

	        	var data = document.createElement("td");
	        	data.innerHTML = accountInfo.lastname;
	        	row.appendChild(data);

	        	var data = document.createElement("td");
	        	data.innerHTML = accountInfo.email;
	        	row.appendChild(data);

	        	var data = document.createElement("td");
	        	data.innerHTML = accountInfo.phoneNum;
	        	row.appendChild(data);

				tBody.appendChild(row);
				
				console.log("inside loop of tickets");
				
				
				
			}
		
		}