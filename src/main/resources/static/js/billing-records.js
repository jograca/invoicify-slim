$(function () {
	
	$('#create-flat-fee-billing-form').submit(e => {
		e.preventDefault();
		
		let bill = {
			amount: $('#flat-fee-bill-amount').val(),
			description: $('#flat-fee-bill-description').val(),
			client: {
				id : $('#flat-fee-client').val()
			}
		};
		let headers = {
			'X-CSRF-TOKEN': $('#flat-fee-bill-csrf').val()
		};
		let settings = {
			url: '/api/flatfees',
			headers: headers,
			data: JSON.stringify(bill),
			contentType: 'application/json'
		};
		$.post(settings)
		 .done(data => {
			 console.log(data);
		 	$('#bill-list')
		 		.append(
		 			`<tr>
						<td>${data.createdBy.username}</td>
						<td>${data.description}</td>
						<td>${data.client.name}</td>
						<td>$${data.amount}</td>
						<td>$</td>
						<td> </td>
						<td>$${data.total}</td>
					<tr>`);
		 	$('#flat-fee-bill-amount').val('');
		 	$('#flat-fee-bill-description').val('');
		 	$('#flat-fee-client').val('');	
		});
	});
}); 

$(function () {
	
	$('#create-rate-based-billing-form').submit(e => {
		e.preventDefault();
		
		let bill = {
			rate: $('#rate-based-bill-rate').val(),
			quantity: $('#rate-based-bill-quantity').val(),
			description: $('#rate-based-bill-description').val(),
			client: {
				id : $('#rate-based-client').val()
			}
		};
		let headers = {
			'X-CSRF-TOKEN': $('#rate-based-bill-csrf').val()
		};
		let settings = {
			url: '/api/ratefees',
			headers: headers,
			data: JSON.stringify(bill),
			contentType: 'application/json'
		};
		$.post(settings)
		 .done(data => {
			 console.log(data);
		 	$('#bill-list')
		 		.append(
		 			`<tr>
						<td>${data.createdBy.username}</td>
						<td>${data.description}</td>
						<td>${data.client.name}</td>
						<td>$</td>
						<td>$${data.rate}</td>
						<td>${data.quantity}</td>
						<td>$${data.total}</td>
					<tr>`);
		 	$('#rate-based-bill-rate').val('');
		 	$('#rate-based-bill-quantity').val('');
		 	$('#rate-based-bill-description').val('');
		 	$('#rate-based-client').val('');
		});
	});
}); 