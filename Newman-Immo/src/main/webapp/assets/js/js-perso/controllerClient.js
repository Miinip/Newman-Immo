monApp.controller("ctrlOneClient",function($scope,$rootScope,$location,clientProvider){
	$scope.msg = "One Client";
	$scope.idToFind =undefined;
	if($rootScope.clientViewRoot != undefined){
		$scope.idToFind = $rootScope.clientViewRoot;
		$rootScope.clientViewRoot = undefined;
		clientProvider.getOneClient($scope.idToFind,function(callback){
			$scope.client = callback;
		})
	}
	$scope.find = function(){
		clientProvider.getOneClient($scope.idToFind,function(callback){
			$scope.client = callback;
		})
	}
	
	$scope.supprimer = function(){
		clientProvider.doDeleteClient($scope.Client.id,function(callback){
			if(callback == "OK"){
				$location.path('/client/all');
			}
		})
	}
	
	$scope.modifier = function(){
		$rootScope.clientFormRoot = $scope.client;
		$location.path('/client/update');
	}
});

monApp.controller("ctrlAllClient",function($scope,$rootScope,$location,clientProvider){
	$scope.msg = "List of Client";
	clientProvider.getAllClient(function(callback){
		$scope.listeClients = callback;
	})
	
	$scope.supprimer = function(idToDelete){
		clientProvider.doDeleteClient(idToDelete,function(callback){
			if(callback == "OK"){
				clientProvider.getAllClient(function(callback){
					$scope.listeClients = callback;
				})
			}
		})
	}
	
	$scope.modifier = function(clientToUpdate){
		$rootScope.clientFormRoot = clientToUpdate;
		$location.path('/client/update');
	}
	
	$scope.vue = function(clientToView){
		$rootScope.clientViewRoot = clientToView;
		$location.path('/client/one');
	}
	
	$scope.MouseOverRow = {};
	$scope.doShow = function(id) {
	    $scope.MouseOverRow[id] = true;
	}
	$scope.doHide = function(id) {
	    $scope.MouseOverRow[id] = false;
	}
});

monApp.controller("ctrlAddClient",function($scope,$location,clientProvider){
	$scope.msg = "Add Client";
	$scope.clientForm = {	id:undefined,
							nom:"",
							prenom:"",
							telPro:undefined,
							telPerso:undefined,
							adresse:{	rue:"",
										numero:"",
										codePostal:undefined,
										localite:"",
										pays:""
										},
							listeVoeux:""
			};
			
	$scope.ajouter = function(){
		clientProvider.doAddClient($scope.clientForm,function(callback){
			if(callback == "OK"){
				$location.path('/client/all');
			}
		})
	}
});

monApp.controller("ctrlUpdateClient",function($scope,$rootScope,$location,clientProvider){
	$scope.msg = "Update Client";
	$scope.clientForm = {	id:undefined,
							nom:"",
							prenom:"",
							telPro:undefined,
							telPerso:undefined,
							adresse:{	rue:"",
										numero:"",
										codePostal:undefined,
										localite:"",
										pays:""
										},
							listeVoeux:""
			};
		
		if($rootScope.clientFormRoot != null){
			$scope.clientForm = $rootScope.clientFormRoot;
			$rootScope.clientFormRoot = null;
		}


	
	$scope.modifier = function(){
		clientProvider.doUpdateClient($scope.clientForm,function(callback){
			if(callback == "OK"){
				$location.path('/client/all');
			}
		})
	}
});
