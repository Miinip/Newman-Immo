monApp.factory('classeStandardProvider', function($http,$location) {
	var restUrl = $location.protocol() +'://'+ $location.host()+':'+ $location.port() + '/Newman-Immo/rest';

	function findAllClasseStandard(callback) {
		$http({method : 'GET',url : restUrl + '/classeStandard/all'}).then(
		function successCallback(response) {
			console.log("action : findAllClasseStandard, status : "+ response.status + "-" + response.statusText);
			callback(response.data);
		}, 
		function errorCallback(response) {
			console.log("action : findAllClasseStandard, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
		});
	}
	
	function findOneClasseStandard(idToFind,callback){
		$http({method: 'GET',url: restUrl + '/classeStandard/one/' + idToFind})
		.then(function successCallback(response){
			console.log("action = findOneClasseStandard, status : "+ response.status + "-" + response.statusText);
	        callback(response.data)
	    },
	    function errorCallback(response){
	    	console.log("action : findOneClasseStandard, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    });
	}
	
	function addClasseStandard(classeStandardToAdd,callback){
		$http({	method:'POST',
				data:angular.toJson(classeStandardToAdd),
				headers:{'content-Type':'application/json'},
				url:restUrl + '/classeStandard/add'})
		.then(function successCallback(response){
			console.log("action : addClasseStandard, status : "+ response.status + "-" + response.statusText);
	        callback(response.statusText);
	    },
	    function errorCallback(response){
	        console.log("action : addClasseStandard, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    });
	}
	
	function updateClasseStandard(classeStandardToUpdate,callback){
		$http({	method:'PUT',
				data:angular.toJson(classeStandardToUpdate),
				headers:{'content-Type':'application/json'},
				url:restUrl + '/classeStandard/update'})
		.then(function successCallback(response){
			console.log("action : updateClasseStandard, status : "+ response.status + "-" + response.statusText);
	    	callback(response.statusText)
	     },
	     function errorCallback(response){
	    	console.log("action : updateClasseStandard, status : "+ response.status + "-" + response.statusText+ " (errorCallback)");
	     });
	}
	
	function deleteClasseStandard(idClasseStandardToDelete,callback){
		$http({	method:'DELETE',url:restUrl + '/classeStandard/delete/'+ idClasseStandardToDelete})
		.then(function successCallback(response){
			console.log("action : deleteClasseStandard, status : "+ response.status + "-" + response.statusText);
	        callback(response.statusText)
	    },
	    function errorCallback(response){
	    	console.log("action : deleteClasseStandard, status : "+ response.status + "-" + response.statusText + " (errorCallback)");
	    	console.log(response.data);
	    });
	}
	
	return {
		getAllClasseStandard : findAllClasseStandard,
		getOneClasseStandard : findOneClasseStandard,
		doAddClasseStandard : addClasseStandard,
		doUpdateClasseStandard : updateClasseStandard,
		doDeleteClasseStandard : deleteClasseStandard
	}

});