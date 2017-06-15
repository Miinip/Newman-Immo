monApp.controller("ctrlOneProprietaire",function($scope,$rootScope,$location,proprietaireProvider){
	$scope.msg = "One Proprietaire";
	$scope.idToFind =undefined;
	if($rootScope.proprietaireViewRoot != undefined){
		$scope.idToFind = $rootScope.proprietaireViewRoot;
		$rootScope.proprietaireViewRoot = undefined;
		proprietaireProvider.getOneProprietaire($scope.idToFind,function(callback){
			$scope.proprietaire = callback;
		})
	}
	$scope.find = function(){
		proprietaireProvider.getOneProprietaire($scope.idToFind,function(callback){
			$scope.proprietaire = callback;
		})
	}
	
	$scope.supprimer = function(){
		proprietaireProvider.doDeleteProprietaire($scope.Proprietaire.id,function(callback){
			if(callback == "OK"){
				$location.path('/proprietaire/all');
			}
		})
	}
	
	$scope.modifier = function(){
		$rootScope.proprietaireFormRoot = $scope.proprietaire;
		$location.path('/proprietaire/update');
	}
});

monApp.controller("ctrlAllProprietaire",function($scope,$rootScope,$location,proprietaireProvider){
	$scope.msg = "List of Proprietaire";
	proprietaireProvider.getAllProprietaire(function(callback){
		$scope.listeProprietaires = callback;
	})
	
	$scope.supprimer = function(idToDelete){
		proprietaireProvider.doDeleteProprietaire(idToDelete,function(callback){
			if(callback == "OK"){
				proprietaireProvider.getAllProprietaire(function(callback){
					$scope.listeProprietaires = callback;
				})
			}
		})
	}
	
	$scope.modifier = function(proprietaireToUpdate){
		$rootScope.proprietaireFormRoot = proprietaireToUpdate;
		$location.path('/proprietaire/update');
	}
	
	$scope.vue = function(proprietaireToView){
		$rootScope.proprietaireViewRoot = proprietaireToView;
		$location.path('/proprietaire/one');
	}
	
	$scope.MouseOverRow = {};
	$scope.doShow = function(id) {
	    $scope.MouseOverRow[id] = true;
	}
	$scope.doHide = function(id) {
	    $scope.MouseOverRow[id] = false;
	}
});

monApp.controller("ctrlAddProprietaire",function($scope,$location,proprietaireProvider){
	$scope.msg = "Add Proprietaire";
	$scope.proprietaireForm = {	id:undefined,
								nom:"",
								prenom:"",
								telPro:undefined,
								telPerso:undefined,
								adresse:{	rue:"",
											numero:"",
											codePostal:undefined,
											localite:"",
											pays:""
											}
			};
			
	$scope.ajouter = function(){
		proprietaireProvider.doAddProprietaire($scope.proprietaireForm,function(callback){
			if(callback == "OK"){
				$location.path('/proprietaire/all');
			}
		})
	}
});

monApp.controller("ctrlUpdateProprietaire",function($scope,$rootScope,$location,proprietaireProvider){
	$scope.msg = "Update Proprietaire";
	$scope.proprietaireForm = {	id:undefined,
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
								listeBien:""
			};
		
		if($rootScope.proprietaireFormRoot != null){
			$scope.proprietaireForm = $rootScope.proprietaireFormRoot;
			$rootScope.proprietaireFormRoot = null;
		}


	
	$scope.modifier = function(){
		proprietaireProvider.doUpdateProprietaire($scope.proprietaireForm,function(callback){
			if(callback == "OK"){
				$location.path('/proprietaire/all');
			}
		})
	}
});
