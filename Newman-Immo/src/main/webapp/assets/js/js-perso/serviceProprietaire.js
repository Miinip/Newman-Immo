monApp.factory('proprietaireProvider', function($http) {
	var restUrl = $location.protocol() +'://'+ $location.host()+':'+ $location.port() + '/Newman-Immo/rest';

	function findAllProprietaire(callback) {
		$http({method : 'GET',url : restUrl + '/proprietaire/all'}).then(
		function successCallback(response) {
			console.log("action : findAllProprietaire, status : "+ response.status + "-" + response.statusText);
			callback(response.data);
		}, 
		function errorCallback(response) {
			console.log("action : findAllProprietaire, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
		});
	}
	
	function findOneProprietaire(idToFind,callback){
		$http({method: 'GET',url: restUrl + '/proprietaire/one/' + idToFind})
		.then(function successCallback(response){
			console.log("action = findOneProprietaire, status : "+ response.status + "-" + response.statusText);
	        callback(response.data)
	    },
	    function errorCallback(response){
	    	console.log("action : findOneProprietaire, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    });
	}
	
	function addProprietaire(proprietaireToAdd,callback){
		$http({	method:'POST',
				data:angular.toJson(proprietaireToAdd),
				headers:{'content-Type':'application/json'},
				url:restUrl + '/proprietaire/add'})
		.then(function successCallback(response){
			console.log("action : addProprietaire, status : "+ response.status + "-" + response.statusText);
	        callback(response.statusText);
	    },
	    function errorCallback(response){
	        console.log("action : addProprietaire, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    });
	}
	
	function updateProprietaire(proprietaireToUpdate,callback){
		$http({	method:'PUT',
				data:angular.toJson(proprietaireToUpdate),
				headers:{'content-Type':'application/json'},
				url:restUrl + '/proprietaire/update'})
		.then(function successCallback(response){
			console.log("action : updateProprietaire, status : "+ response.status + "-" + response.statusText);
	    	callback(response.statusText)
	     },
	     function errorCallback(response){
	    	console.log("action : updateProprietaire, status : "+ response.status + "-" + response.statusText+ " (errorCallback)");
	     });
	}
	
	function deleteProprietaire(idProprietaireToDelete,callback){
		$http({	method:'DELETE',url:restUrl + '/proprietaire/delete/'+ idProprietaireToDelete})
		.then(function successCallback(response){
			console.log("action : deleteProprietaire, status : "+ response.status + "-" + response.statusText);
	        callback(response.statusText)
	    },
	    function errorCallback(response){
	    	console.log("action : deleteProprietaire, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    	console.log(response.data);
	    });
	}
	
	return {
		getAllProprietaire : findAllProprietaire,
		getOneProprietaire : findOneProprietaire,
		doAddProprietaire : addProprietaire,
		doUpdateProprietaire : updateProprietaire,
		doDeleteProprietaire : deleteProprietaire
	}

});