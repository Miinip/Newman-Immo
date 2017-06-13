monApp.factory('visiteProvider', function($http) {
	var restUrl = 'http://localhost:8080/Newman-Immo/rest';

	function findAllVisite(callback) {
		$http({ method : 'GET',
			    url : restUrl + '/visite/all'})
		.then(function successCallback(response) {
			console.log("action : findAllVisite, status : "+ response.status + "-" + response.statusText);
			callback(response.data);
		}, 
		function errorCallback(response) {
			console.log("action : findAllVisite, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
		});
	}
	
	function findOneVisite(idToFind,callback){
		$http({method: 'GET',
			   url: restUrl + '/visite/one/' + idToFind})
		.then(function successCallback(response){
			console.log("action = findOneVisite, status : "+ response.status + "-" + response.statusText);
	        callback(response.data)
	    },
	    function errorCallback(response){
	    	console.log("action : findOneVisite, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    });
	}
	
	function addVisite(visiteToAdd,callback){
		$http({	method:'POST',
				data:angular.toJson(visiteToAdd),
				headers:{'content-Type':'application/json'},
				url:restUrl + '/visite/add'})
		.then(function successCallback(response){
			console.log("action : addVisite, status : "+ response.status + "-" + response.statusText);
	        callback(response.statusText);
	    },
	    function errorCallback(response){
	        console.log("action : addVisite, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    });
	}
	
	function updateVisite(visiteToUpdate,callback){
		$http({	method:'PUT',
				data:angular.toJson(visiteToUpdate),
				headers:{'content-Type':'application/json'},
				url:restUrl + '/visite/update'})
		.then(function successCallback(response){
			console.log("action : updateVisite, status : "+ response.status + "-" + response.statusText);
	    	callback(response.statusText)
	     },
	     function errorCallback(response){
	    	console.log("action : updateVisite, status : "+ response.status + "-" + response.statusText+ " (errorCallback)");
	     });
	}
	
	function deleteVisite(idVisiteToDelete,callback){
		$http({	method:'DELETE',
			    url:restUrl + '/visite/delete/'+ idVisiteToDelete})
		.then(function successCallback(response){
			console.log("action : deleteVisite, status : "+ response.status + "-" + response.statusText);
	        callback(response.statusText)
	    },
	    function errorCallback(response){
	    	console.log("action : deleteVisite, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    	console.log(response.data);
	    });
	}
	
	return {
		getAllVisite : findAllVisite,
		getOneVisite : findOneVisite,
		doAddVisite : addVisite,
		doUpdateVisite : updateVisite,
		doDeleteVisite : deleteVisite
	}

});