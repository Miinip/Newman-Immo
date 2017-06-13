onApp.factory('conseillerProvider', function($http) {
	var restUrl = 'http://localhost:8080/angularJS_projet1/rest';

	function findAllConseiller(callback) {
		$http({method : 'GET',url : restUrl + '/conseiller/all'}).then(
		function successCallback(response) {
			console.log("action : findAllConseiller, status : "+ response.status + "-" + response.statusText);
			callback(response.data);
		}, 
		function errorCallback(response) {
			console.log("action : findAllConseiller, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
		});
	}
	
	function findOneConseiller(idToFind,callback){
		$http({method: 'GET',url: restUrl + '/conseiller/one/' + idToFind})
		.then(function successCallback(response){
			console.log("action = findOneConseiller, status : "+ response.status + "-" + response.statusText);
	        callback(response.data)
	    },
	    function errorCallback(response){
	    	console.log("action : findOneConseiller, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    });
	}
	
	function addConseiller(conseillerToAdd,callback){
		$http({	method:'POST',
				data:angular.toJson(conseillerToAdd),
				headers:{'content-Type':'application/json'},
				url:restUrl + '/conseiller/add'})
		.then(function successCallback(response){
			console.log("action : addConseiller, status : "+ response.status + "-" + response.statusText);
	        callback(response.statusText);
	    },
	    function errorCallback(response){
	        console.log("action : addConseiller, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    });
	}
	
	function updateConseiller(conseillerToUpdate,callback){
		$http({	method:'PUT',
				data:angular.toJson(conseillerToUpdate),
				headers:{'content-Type':'application/json'},
				url:restUrl + '/conseiller/update'})
		.then(function successCallback(response){
			console.log("action : updateConseiller, status : "+ response.status + "-" + response.statusText);
	    	callback(response.statusText)
	     },
	     function errorCallback(response){
	    	console.log("action : updateConseiller, status : "+ response.status + "-" + response.statusText+ " (errorCallback)");
	     });
	}
	
	function deleteConseiller(idConseillerToDelete,callback){
		$http({	method:'DELETE',url:restUrl + '/conseiller/delete/'+ idConseillerToDelete})
		.then(function successCallback(response){
			console.log("action : deleteConseiller, status : "+ response.status + "-" + response.statusText);
	        callback(response.statusText)
	    },
	    function errorCallback(response){
	    	console.log("action : deleteConseiller, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    	console.log(response.data);
	    });
	}
	
	return {
		getAllConseiller : findAllConseiller,
		getOneConseiller : findOneConseiller,
		doAddConseiller : addConseiller,
		doUpdateConseiller : updateConseiller,
		doDeleteConseiller : deleteConseiller
	}

});