		/*asynchFunction();*/
		
      /*  async function asynchFunction() {
			let url = "/Project01/TicketServlet";
            let response = await fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charaset=utf-8'
                },
               /* body: JSON.stringify(user)*/

     /*       }).then(response => {return response.text()}

			).then(function(response){
				console.log("ticket lists: " + response)
				parseResponse(response);	
			}).catch(error => {
				window.location.href= response.url;
				console.error(error);
			})
        }   */

 		/*  const website = document.getElementById("website").value;
        const url = document.getElementById("url").value;*/

      const selectForm = document.querySelector("form");
      const selectTbody = document.querySelector("tbody");
      const selectTable = document.querySelector("table");


/*
      function createTicket(e) {
        e.preventDefault();
		const ticketID = response.TicketID;
		console.log("Ticket ID" + ticketID);
     
		console.log("ticket list is" + ticketList);
		for(let i = 0; i < ticketList.length; i++){
			  selectTbody.innerHTML += 
		`<tr>
                <td class = "data">` + ticketList[i].TicketID + '</td>
                <td>${website}</td>
                <td><button class="deleteBtn">Delete</button></td>
            </tr>`;
			
		}
      }
*/


    /*  function onDeleteRow(e) {
        if (!e.target.classList.contains("deleteBtn")) {
          return;
        }

        const btn = e.target;
        btn.closest("tr").remove();
      } */



   /*   formEl.addEventListener("submit", onAddWebsite);
      tableEl.addEventListener("click", onDeleteRow);*/
		
		
		/*    async function getTickets() {
			console.log("inside get Tickets");
			let url = "/Project01/TicketServlet";
            let response = await fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charaset=utf-8'
                },
               body: JSON.stringify(user)	
            }).then((response) => {
			var ticketList = JSON.parse(response);
			console.log(ticketList);
            }).catch((error) => {
                console.error(error);
            })
        }
*/
		async function seePending(){	
			window.location.href= "/Project01/viewPending.html";

		/*	var tBody = document.getElementById("tBody");
			alert("Testing 1");
			
				console.log("inside get Tickets");
		/*	let url = "/Project01/SendTicketsServlet";*/
            /*let response = await fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charaset=utf-8'
                },*/
              	/*  body: JSON.stringify(user)	*/
           /* }).then((response) => {							
			var tickets = JSON.parse(response);
			console.log("list of tickets: " + tickets);
			console.log("Ticket ID: " + tickets.TicketID);
            }).catch((error) => {
                console.error(error);
            } */
						
		
		/*	var ticketID = document.createElement("th");
			var node = document.createTextNode("Ticket ID");
			header.appendChild(ticketID);
			
			var author = document.createElement("th");
			var node = document.createTextNode("Author");
			header.appendChild(author);
			
			var type = document.createElement("th");
			var node = document.createTextNode("Type");
			header.appendChild(type]);
			
			var amount = document.createElement("th");
			var node = document.createTextNode("Amount");
			header.appendChild(amount);
			
			var descript = document.createElement("th");
			var node = document.createTextNode("Descripton");
			header.appendChild(descript);
			
			var submit = document.createElement("th");
			var node = document.createTextNode("Submitted");
			header.appendChild(submit);
			
			var status = document.createElement("th");
			var node = document.createTextNode("Status");
			header.appendChild(status); */
			
			}
			
			
			
		/*	var para = document.createElement("th");
			var node = document.createTextNode("Description");
			para.appendChild(node);
			var element = document.getElementById("bro");
			element.appendChild(para);

	}
*/
			
			
	





