function createTicket(){	
	let ticket = {
		type: document.getElementById('type').value,
		amount: document.getElementById('amount').value,
		description: document.getElementById('description').value
	};
		asynchFunction();
        async function asynchFunction() {
			let url = "/Project01/TicketServlet";
            let response = await fetch(url, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json;charaset=utf-8'
                },
                body: JSON.stringify(ticket)
            }).then((response) => {
                let ticketList = response.json();
				alert("Request Submitted");
				console.log(ticketList.ticketID);
				window.location.href = "employeeHome.html";
            }).catch((error) => {
                console.error(error);
            })
        }









}