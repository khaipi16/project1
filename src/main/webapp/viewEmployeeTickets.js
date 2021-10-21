async function employeeTickets(){
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
		