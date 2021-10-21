		/*	window.location.href = "viewPending.html";	*/
			
			async function viewTickets(){
			window.location.href = "viewPending.html";	

	 					
			console.log("inside get Tickets");
			let url = "/Project01/SendTicketsServlet";
            let response = await fetch( url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charaset=utf-8'
                },
              	/*  body: JSON.stringify(user)	*/
            })
			let ticketsList = await response.text();
			console.log("tickets list ");
			console.log(ticketsList);
			/*then((response) => {*/
			/*window.location.href= "/Project01/viewPending.html";*/
	
			var tickets = JSON.parse(ticketsList);
			console.log("JSON");
			console.log(tickets);
			
			if(tickets.length == 0){
				alert("There are no tickets to view.");
				
			}
			else{
				createHeader();
				var tBody = document.getElementById("tBody");
			for(let i = 0; i < tickets.length; i++){
				document.getElementById("tHead").deletetHead;
				
									
				var row = document.createElement("tr");
				/*	tBody.removeChild(tBody.);		*/

	        	var data = document.createElement("td");
	       	 	data.innerHTML = tickets[i].TicketID;
	        	console.log("Printing TicketID inside loop: " + tickets[i].TicketID);
	        	row.appendChild(data);

	        	var data = document.createElement("td");
	        	data.innerHTML = tickets[i].author;
	        	row.appendChild(data);

	        	var data = document.createElement("td");
	        	data.innerHTML = tickets[i].type;
	        	row.appendChild(data);

	        	var data = document.createElement("td");
	        	data.innerHTML = "$" + tickets[i].amount;
	        	row.appendChild(data);

	        	var data = document.createElement("td");
	        	data.innerHTML = tickets[i].description;
	        	row.appendChild(data);

	        	var data = document.createElement("td");
	        	data.innerHTML = tickets[i].submitted;
	        	row.appendChild(data);


	        	var data = document.createElement("td");
	        	data.innerHTML = tickets[i].status;
	        	row.appendChild(data);

				var data = document.createElement("td");
				var approve = "Approved";
				data.innerHTML = `<button onclick= "updateStatus(`+tickets[i].TicketID+`, '`+ approve + `')">Approve</button>`;
				console.log("Ticket ID JS: " + tickets[i].TicketID );
				row.appendChild(data);
				
				var data = document.createElement("td");	
				var deny = "Denied";
				data.innerHTML = `<button onclick= "updateStatus(`+tickets[i].TicketID+`, '`+ deny + `')">Deny</button>`;
				row.appendChild(data);
		
				tBody.appendChild(row);
				
				console.log("inside loop of tickets");

						
			}
		
		}
	}
			
			
			
			
			
			
			
			async function updateStatus(TicketID, status){
				console.log("inside update status JS");
		
				let request = {
					TicketID: TicketID,
					status: status,
				};
				console.log("below is request");
				console.log(request);
				
				console.log("below is ticket ID");
				console.log(TicketID);
				
				console.log("below is status");
				console.log(status);
				
				
				let url = "/Project01/UpdateStatusServlet";
           		let response = await fetch( url, {
                method: 'POST',
                headers: {'Content-Type': 'application/json;charaset=utf-8'},
				body: (TicketID + "," + status),
				
				});
				window.location.reload();
				console.log("do we get here?");
			}
			
			//Creating the headers for Ticket Table
			async function createHeader(){
				var tBody = document.getElementById("tHead");
				var head = document.createElement("tr");

				var header = document.createElement("th");
	       	 	header.innerHTML = "Ticket ID";
	        	head.appendChild(header);	

				var header = document.createElement("th");
	        	header.innerHTML = "Author";
	        	head.appendChild(header);

	        	var header = document.createElement("th");
	        	header.innerHTML = "Type";
	        	head.appendChild(header);

	        	var header = document.createElement("th");
	        	header.innerHTML = "Amount";
	        	head.appendChild(header);

	        	var header = document.createElement("th");
	        	header.innerHTML = "Description";
	        	head.appendChild(header);

	        	var header = document.createElement("th");
	        	header.innerHTML = "Submitted";
	        	head.appendChild(header);

	        	var header = document.createElement("th");
	        	header.innerHTML = "Status";
	        	head.appendChild(header);

				var header = document.createElement("th");
	        	header.innerHTML = "Action ";
	        	head.appendChild(header);		

				tBody.appendChild(head);
				
			}
			
		
			
			async function sendUser(){
				let request = {username: document.getElementById('username').value};
				
				console.log("inside get Tickets");
				let url = "/Project01/SearchTicketServlet";
            	let response = await fetch( url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charaset=utf-8'
                },
              	body: JSON.stringify(request)	
           		})
			}
			
				/*then((response) => {*/
				/*window.location.href= "/Project01/viewPending.html";
				let ticketsList = await response.text();
				console.log("tickets list ");
				console.log(ticketsList);
				*/
	
			
			async function searchTicket(){
				console.log("inside get Tickets");
				let url = "/Project01/SendTicketsServlet";
            	let response = await fetch( url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charaset=utf-8'
                },
              	/*  body: JSON.stringify(user)	*/
           		})
				let ticketsList = await response.text();
				console.log("tickets list ");
				console.log(ticketsList);
	
				var tickets = JSON.parse(ticketsList);
				console.log("JSON");
				console.log(tickets);
				console.log("username is");
				console.log(username);
				
				var tBody = document.getElementById("tBody");
				var username = document.getElementById("username").value;

				if(username == ""){
				console.log(username);
				alert("Please enter a username");
				}
				else{
					for(let i= 0; i < tickets.length; i++){

					console.log(tickets[i].author);
					console.log("inserted username: " + username);
					if(username == (tickets[i].author)){
								createHeader();
								var row = document.createElement("tr");

	        					var data = document.createElement("td");
	       	 					data.innerHTML = tickets[i].TicketID;
	        					console.log("Printing TicketID inside loop: " + tickets[i].TicketID);
	        					row.appendChild(data);

	        					var data = document.createElement("td");
	        					data.innerHTML = tickets[i].author;
	        					row.appendChild(data);

	        					var data = document.createElement("td");
	        					data.innerHTML = tickets[i].type;
	        					row.appendChild(data);

	        					var data = document.createElement("td");
	        					data.innerHTML = "$" + tickets[i].amount;
	        					row.appendChild(data);

	        					var data = document.createElement("td");
	        					data.innerHTML = tickets[i].description;
	        					row.appendChild(data);

	        					var data = document.createElement("td");
	        					data.innerHTML = tickets[i].submitted;
	        					row.appendChild(data);

			
				        		var data = document.createElement("td");
	        					data.innerHTML = tickets[i].status;
	        					row.appendChild(data);

								var data = document.createElement("button");
								data.innerHTML = "Approve";
								data.onclick = (updateStatus(tickets[i].TicketID, "Approved" ));
								console.log("Tickes ID JS: " + tickets[i].TicketID );
								row.appendChild(data);
				
								var data = document.createElement("button");
								data.innerHTML = "Deny";
								data.onclick = (updateStatus(tickets[i].TicketID, "Denied" ));
								row.appendChild(data);
			
								tBody.appendChild(row);
								
					}
				}				
		}
		
	}
	
	
	

					
	
	
	
					


			

	
			
		
			
			
	





