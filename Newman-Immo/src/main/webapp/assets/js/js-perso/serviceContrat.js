monApp.factory('contratProvider', function($http,$location) {
	var restUrl = $location.protocol() +'://'+ $location.host()+':'+ $location.port() + '/Newman-Immo/rest';

	function findAllContrat(callback) {
		$http({method : 'GET',url : restUrl + '/contrat/all'}).then(
		function successCallback(response) {
			console.log("action : findAllContrat, status : "+ response.status + "-" + response.statusText);
			callback(response.data);
		}, 
		function errorCallback(response) {
			console.log("action : findAllContrat, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
		});
	}
	
	function findOneContrat(idToFind,callback){
		$http({method: 'GET',url: restUrl + '/contrat/one/' + idToFind})
		.then(function successCallback(response){
			console.log("action = findOneContrat, status : "+ response.status + "-" + response.statusText);
	        callback(response.data)
	    },
	    function errorCallback(response){
	    	console.log("action : findOneContrat, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    });
	}
	
	function addContrat(ContratToAdd,callback){
		$http({	method:'POST',
				data:angular.toJson(ContratToAdd),
				headers:{'content-Type':'application/json'},
				url:restUrl + '/contrat/add'})
		.then(function successCallback(response){
			console.log("action : addContrat, status : "+ response.status + "-" + response.statusText);
	        callback(response.statusText);
	    },
	    function errorCallback(response){
	        console.log("action : addContrat, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    });
	}
	
	function updateContrat(ContratToUpdate,callback){
		$http({	method:'PUT',
				data:angular.toJson(ContratToUpdate),
				headers:{'content-Type':'application/json'},
				url:restUrl + '/contrat/update'})
		.then(function successCallback(response){
			console.log("action : updateContrat, status : "+ response.status + "-" + response.statusText);
	    	callback(response.statusText)
	     },
	     function errorCallback(response){
	    	console.log("action : updateContrat, status : "+ response.status + "-" + response.statusText+ " (errorCallback)");
	     });
	}
	
	function deleteContrat(idContratToDelete,callback){
		$http({	method:'DELETE',url:restUrl + '/contrat/delete/'+ idContratToDelete})
		.then(function successCallback(response){
			console.log("action : deleteContrat, status : "+ response.status + "-" + response.statusText);
	        callback(response.statusText)
	    },
	    function errorCallback(response){
	    	console.log("action : deleteContrat, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    	console.log(response.data);
	    });
	}
	
	return {
		getAllContrat : findAllContrat,
		getOneContrat : findOneContrat,
		doAddContrat : addContrat,
		doUpdateContrat : updateContrat,
		doDeleteContrat : deleteContrat
	}

});