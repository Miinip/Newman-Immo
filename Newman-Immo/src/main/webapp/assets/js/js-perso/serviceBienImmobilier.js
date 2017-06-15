monApp.factory('bienImmobilierProvider', function($http, $location) {
	var restUrl = $location.protocol() +'://'+ $location.host()+':'+ $location.port() + '/Newman-Immo/rest';

	function findAllBienImmobilier(callback) {
		$http({method : 'GET',url : restUrl + '/bienImmobilier/all'}).then(
		function successCallback(response) {
			console.log("action : findAllBienImmobilier, status : "+ response.status + "-" + response.statusText);
			callback(response.data);
		}, 
		function errorCallback(response) {
			console.log("action : findAllBienImmobilier, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
		});
	}
	
	function findOneBienImmobilier(idToFind,callback){
		$http({method: 'GET',url: restUrl + '/bienImmobilier/one/' + idToFind})
		.then(function successCallback(response){
			console.log("action = findOneBienImmobilier, status : "+ response.status + "-" + response.statusText);
	        callback(response.data)
	    },
	    function errorCallback(response){
	    	console.log("action : findOneBienImmobilier, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    });
	}
	
	function addBienImmobilier(bienImmobilierToAdd,callback){
		$http({	method:'POST',
				data:angular.toJson(bienImmobilierToAdd),
				headers:{'content-Type':'application/json'},
				url:restUrl + '/bienImmobilier/add'})
		.then(function successCallback(response){
			console.log("action : addBienImmobilier, status : "+ response.status + "-" + response.statusText);
	        callback(response.statusText);
	    },
	    function errorCallback(response){
	        console.log("action : addBienImmobilier, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    });
	}
	
	function updateBienImmobilier(bienImmobilierToUpdate,callback){
		bienImmobilierToUpdate.photo = bienImmobilierToUpdate.photo.base64;
		$http({	method:'PUT',
				data:angular.toJson(bienImmobilierToUpdate),
				headers:{'content-Type':'application/json'},
				url:restUrl + '/bienImmobilier/update'})
		.then(function successCallback(response){
			console.log("action : updateBienImmobilier, status : "+ response.status + "-" + response.statusText);
	    	callback(response.statusText)
	     },
	     function errorCallback(response){
	    	console.log("action : updateBienImmobilier, status : "+ response.status + "-" + response.statusText+ " (errorCallback)");
	     });
	}
	
	function deleteBienImmobilier(idBienImmobilierToDelete,callback){
		$http({	method:'DELETE',url:restUrl + '/bienImmobilier/delete/'+ idBienImmobilierToDelete})
		.then(function successCallback(response){
			console.log("action : deleteBienImmobilier, status : "+ response.status + "-" + response.statusText);
	        callback(response.statusText)
	    },
	    function errorCallback(response){
	    	console.log("action : deleteBienImmobilier, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    	console.log(response.data);
	    });
	}
	
	return {
		getAllBienImmobilier : findAllBienImmobilier,
		getOneBienImmobilier : findOneBienImmobilier,
		doAddBienImmobilier : addBienImmobilier,
		doUpdateBienImmobilier : updateBienImmobilier,
		doDeleteBienImmobilier : deleteBienImmobilier
	}

});