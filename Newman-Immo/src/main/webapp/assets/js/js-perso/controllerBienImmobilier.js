monApp.controller("ctrlOneBienImmobilier",function($scope,$rootScope,$location,bienImmobilierProvider){
	$scope.msg = "One BienImmobilier";
	$scope.idToFind =undefined;
	$scope.find = function(){
		bienImmobilierProvider.getOneBienImmobilier($scope.idToFind,function(callback){
			$scope.bienImmobilier = callback;
		})
	}
	
	$scope.supprimer = function(){
		bienImmobilierProvider.doDeleteBienImmobilier($scope.BienImmobilier.id,function(callback){
			if(callback == "OK"){
				$location.path('/bienImmobilier/all');
			}
		})
	}
	
	$scope.modifier = function(){
		$rootScope.bienImmobilierFormRoot = $scope.bienImmobilier;
		$location.path('/bienImmobilier/update');
	}
});

monApp.controller("ctrlAllBienImmobilier",function($scope,$rootScope,$location,bienImmobilierProvider){
	$scope.msg = "List of BienImmobilier";
	bienImmobilierProvider.getAllBienImmobilier(function(callback){
		$scope.listeBienImmobiliers = callback;
	})
	
	$scope.supprimer = function(idToDelete){
		bienImmobilierProvider.doDeleteBienImmobilier(idToDelete,function(callback){
			if(callback == "OK"){
				bienImmobilierProvider.getAllBienImmobilier(function(callback){
					$scope.listeBienImmobiliers = callback;
				})
			}
		})
	}
	
	$scope.modifier = function(bienImmobilierToUpdate){
		$rootScope.bienImmobilierFormRoot = bienImmobilierToUpdate;
		$location.path('/bienImmobilier/update');
	}
	
	$scope.MouseOverRow = {};
	$scope.doShow = function(id) {
	    $scope.MouseOverRow[id] = true;
	}
	$scope.doHide = function(id) {
	    $scope.MouseOverRow[id] = false;
	}
});

monApp.controller("ctrlAddBienImmobilier",function($scope,$location,bienImmobilierProvider){
	$scope.msg = "Add BienImmobilier";
	$scope.bienImmobilierForm = {	id:undefined,
									photo:undefined,
									statut:"",
									classeStandard:"",
									dateSoumission:"",
									dateMiseDispo:"",
									revenuCadastral:undefined,
									localisation:{	rue:"",
													numero:"",
													codePostal:undefined,
													localite:"",
													pays:""
												},
									proprietaire:"",
									conseiller:"",
									clientAcquereur:""
	};
			
	$scope.ajouter = function(){
		bienImmobilierProvider.doAddBienImmobilier($scope.bienImmobilierForm,function(callback){
			if(callback == "OK"){
				$location.path('/bienImmobilier/all');
			}
		})
	}
});

monApp.controller("ctrlUpdateBienImmobilier",function($scope,$rootScope,$location,bienImmobilierProvider){
	$scope.msg = "Update BienImmobilier";
	$scope.bienImmobilierForm = {	id:undefined,
									photo:undefined,
									statut:"",
									classeStandard:"",
									dateSoumission:"",
									dateMiseDispo:"",
									revenuCadastral:undefined,
									localisation:{	rue:"",
													numero:"",
													codePostal:undefined,
													localite:"",
													pays:""
												},
									proprietaire:"",
									conseiller:"",
									clientAcquereur:""
			};
		
		if($rootScope.bienImmobilierFormRoot != null){
			$scope.bienImmobilierForm = $rootScope.bienImmobilierFormRoot;
			$rootScope.bienImmobilierFormRoot = null;
		}


	
	$scope.modifier = function(){
		bienImmobilierProvider.doUpdateBienImmobilier($scope.bienImmobilierForm,function(callback){
			if(callback == "OK"){
				$location.path('/bienImmobilier/all');
			}
		})
	}
});
