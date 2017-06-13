monApp.controller("ctrlOneVisite",function($scope,$rootScope,$location,visiteProvider){
	$scope.msg = "One Visite";
	$scope.idToFind =undefined;
	
	$scope.find = function(){
		visiteProvider.getOneVisite($scope.idToFind,function(callback){
			$scope.visite = callback;
		})
	}
	
	$scope.suprimer = function(){
		visiteProvider.doDeleteVisite($scope.Visite.id,function(callback){
			if(callback == "OK"){
				$location.path('/visite/all');
			}
		})
	}
	
	$scope.modifier = function(){
		$rootScope.visiteFormRoot = $scope.Visite;
		$location.path('/visite/update');
	}
});

monApp.controller("ctrlAllVisite",function($scope,$rootScope,$location,visiteProvider){
	$scope.msg = "List of Visite";
	visiteProvider.getAllVisite(function(callback){
		$scope.listeVisites = callback;
	})
	
	$scope.supprimer = function(idToDelete){
		visiteProvider.doDeleteVisite(idToDelete,function(callback){
			if(callback == "OK"){
				visiteProvider.getAllVisite(function(callback){
					$scope.listeVisites = callback;
				})
			}
		})
	}
	
	$scope.modifier = function(visiteToUpdate){
		$rootScope.visiteFormRoot = visiteToUpdate;
		$location.path('/visite/update');
	}
	
	$scope.MouseOverRow = {};
	$scope.doShow = function(id) {
	    $scope.MouseOverRow[id] = true;
	}
	$scope.doHide = function(id) {
	    $scope.MouseOverRow[id] = false;
	}
});

monApp.controller("ctrlAddVisite",function($scope,$location,visiteProvider){
	$scope.msg = "Add Visite";
	$scope.visiteForm = {	id:undefined,
			date:"",
			heure:""
			};
			
	$scope.ajouter = function(){
		visiteProvider.doAddVisite($scope.visiteForm,function(callback){
			if(callback == "OK"){
				$location.path('/visite/all');
			}
		})
	}
});

monApp.controller("ctrlUpdateVisite",function($scope,$rootScope,$location,visiteProvider){
	$scope.msg = "Update Visite";
	$scope.visiteForm = {	id:undefined,
			date:"",
			heure:""
			};
		
		if($rootScope.visiteFormRoot != null){
			$scope.visiteForm = $rootScope.visiteFormRoot;
			$rootScope.visiteFormRoot = null;
		}


	
	$scope.modifier = function(){
		visiteProvider.doUpdateVisite($scope.visiteForm,function(callback){
			if(callback == "OK"){
				$location.path('/visite/all');
			}
		})
	}
});
