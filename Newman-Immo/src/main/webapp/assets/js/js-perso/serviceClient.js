monApp.factory('clientProvider', function($http) {
	var restUrl = $location.protocol() +'://'+ $location.host()+':'+ $location.port() + '/Newman-Immo/rest';

	function findAllClient(callback) {
		$http({method : 'GET',url : restUrl + '/client/all'}).then(
		function successCallback(response) {
			console.log("action : findAllClient, status : "+ response.status + "-" + response.statusText);
			callback(response.data);
		}, 
		function errorCallback(response) {
			console.log("action : findAllClient, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
		});
	}
	
	function findOneClient(idToFind,callback){
		$http({method: 'GET',url: restUrl + '/client/one/' + idToFind})
		.then(function successCallback(response){
			console.log("action = findOneClient, status : "+ response.status + "-" + response.statusText);
	        callback(response.data)
	    },
	    function errorCallback(response){
	    	console.log("action : findOneClient, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    });
	}
	
	function addClient(clientToAdd,callback){
		$http({	method:'POST',
				data:angular.toJson(clientToAdd),
				headers:{'content-Type':'application/json'},
				url:restUrl + '/client/add'})
		.then(function successCallback(response){
			console.log("action : addClient, status : "+ response.status + "-" + response.statusText);
	        callback(response.statusText);
	    },
	    function errorCallback(response){
	        console.log("action : addClient, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    });
	}
	
	function updateClient(clientToUpdate,callback){
		$http({	method:'PUT',
				data:angular.toJson(clientToUpdate),
				headers:{'content-Type':'application/json'},
				url:restUrl + '/client/update'})
		.then(function successCallback(response){
			console.log("action : updateClient, status : "+ response.status + "-" + response.statusText);
	    	callback(response.statusText)
	     },
	     function errorCallback(response){
	    	console.log("action : updateClient, status : "+ response.status + "-" + response.statusText+ " (errorCallback)");
	     });
	}
	
	function deleteClient(idClientToDelete,callback){
		$http({	method:'DELETE',url:restUrl + '/client/delete/'+ idClientToDelete})
		.then(function successCallback(response){
			console.log("action : deleteClient, status : "+ response.status + "-" + response.statusText);
	        callback(response.statusText)
	    },
	    function errorCallback(response){
	    	console.log("action : deleteClient, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    	console.log(response.data);
	    });
	}
	
	return {
		getAllClient : findAllClient,
		getOneClient : findOneClient,
		doAddClient : addClient,
		doUpdateClient : updateClient,
		doDeleteClient : deleteClient
	}

});