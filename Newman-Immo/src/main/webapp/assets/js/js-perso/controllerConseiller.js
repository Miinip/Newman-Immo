monApp.controller("ctrlOneConseiller",function($scope,$rootScope,$location,conseillerProvider){
	$scope.msg = "One Conseiller";
	$scope.idToFind =undefined;
	if($rootScope.conseillerViewRoot != undefined){
		$scope.idToFind = $rootScope.conseillerViewRoot;
		$rootScope.conseillerViewRoot = undefined;
		conseillerProvider.getOneConseiller($scope.idToFind,function(callback){
			$scope.conseiller = callback;
		})
	}
	$scope.find = function(){
		conseillerProvider.getOneConseiller($scope.idToFind,function(callback){
			$scope.conseiller = callback;
		})
	}
	
	$scope.suprimer = function(){
		conseillerProvider.doDeleteConseiller($scope.Conseiller.id,function(callback){
			if(callback == "OK"){
				$location.path('/conseiller/all');
			}
		})
	}
	
	$scope.modifier = function(){
		$rootScope.conseillerFormRoot = $scope.conseiller;
		$location.path('/conseiller/update');
	}
});

monApp.controller("ctrlAllConseiller",function($scope,$rootScope,$location,conseillerProvider){
	$scope.msg = "List of Conseiller";
	conseillerProvider.getAllConseiller(function(callback){
		$scope.listeConseillers = callback;
	})
	
	$scope.suprimer = function(idToDelete){
		conseillerProvider.doDeleteConseiller(idToDelete,function(callback){
			if(callback == "OK"){
				conseillerProvider.getAllConseiller(function(callback){
					$scope.listeConseillers = callback;
				})
			}
		})
	}
	
	$scope.modifier = function(conseillerToUpdate){
		$rootScope.conseillerFormRoot = conseillerToUpdate;
		$location.path('/conseiller/update');
	}
	
	$scope.vue = function(conseillerToView){
		$rootScope.conseillerViewRoot = conseillerToView;
		$location.path('/conseiller/one');
	}
	
	$scope.MouseOverRow = {};
	$scope.doShow = function(id) {
	    $scope.MouseOverRow[id] = true;
	}
	$scope.doHide = function(id) {
	    $scope.MouseOverRow[id] = false;
	}
});

monApp.controller("ctrlAddConseiller",function($scope,$location,conseillerProvider){
	$scope.msg = "Add Conseiller";
	$scope.conseillerForm = {	id:undefined,
			nom:"",
			prenom:"",
			login:"",
			password:"",
			adresse:{	rue:"",
						numero:"",
						codePostal:undefined,
						localite:"",
						pays:""
						}
			};
			
	$scope.ajouter = function(){
		conseillerProvider.doAddConseiller($scope.conseillerForm,function(callback){
			if(callback == "OK"){
				$location.path('/conseiller/all');
			}
		})
	}
});

monApp.controller("ctrlUpdateConseiller",function($scope,$rootScope,$location,conseillerProvider){
	$scope.msg = "Update Conseiller";
	$scope.conseillerForm = {	id:undefined,
			nom:"",
			prenom:"",
			login:"",
			password:"",
			adresse:{	rue:"",
						numero:"",
						codePostal:undefined,
						localite:"",
						pays:""
						}
			};
		
		if($rootScope.conseillerFormRoot != null){
			$scope.conseillerForm = $rootScope.conseillerFormRoot;
			$rootScope.conseillerFormRoot = null;
		}


	
	$scope.modifier = function(){
		conseillerProvider.doUpdateConseiller($scope.conseillerForm,function(callback){
			if(callback == "OK"){
				$location.path('/conseiller/all');
			}
		})
	}
});
