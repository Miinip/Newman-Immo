monApp.controller("ctrlOneContrat", function($scope, $rootScope, $location,
		contratProvider) {
	$scope.msg = "One Contrat";
	$scope.idToFind = undefined;
	if($rootScope.contratViewRoot != undefined){
		$scope.idToFind = $rootScope.contratViewRoot;
		$rootScope.contratViewRoot = undefined;
		contratProvider.getOneContrat($scope.idToFind,function(callback){
			$scope.contrat = callback;
		})
	}
	$scope.find = function() {
		contratProvider.getOneContrat($scope.idToFind, function(callback) {
			$scope.contrat = callback;
		})
	}

	$scope.supprimer = function() {
		contratProvider.doDeleteContrat($scope.Contrat.id, function(callback) {
			if (callback == "OK") {
				$location.path('/contrat/all');
			}
		})
	}

	$scope.modifier = function() {
		$rootScope.contratFormRoot = $scope.contrat;
		$location.path('/contrat/update');
	}
});

monApp.controller("ctrlAllContrat", function($scope, $rootScope, $location,
		contratProvider) {
	$scope.msg = "List of Contrat";
	contratProvider.getAllContrat(function(callback) {
		$scope.listeContrats = callback;
	})

	$scope.supprimer = function(idToDelete) {
		contratProvider.doDeleteContrat(idToDelete, function(callback) {
			if (callback == "OK") {
				contratProvider.getAllContrat(function(callback) {
					$scope.listeContrats = callback;
				})
			}
		})
	}

	$scope.modifier = function(ContratToUpdate) {
		$rootScope.contratFormRoot = ContratToUpdate;
		$location.path('/contrat/update');
	}
	
	$scope.vue = function(contratToView){
		$rootScope.contratViewRoot = contratToView;
		$location.path('/contrat/one');
	}

	$scope.MouseOverRow = {};
	$scope.doShow = function(id) {
		$scope.MouseOverRow[id] = true;
	}
	$scope.doHide = function(id) {
		$scope.MouseOverRow[id] = false;
	}
});

monApp.controller("ctrlAddContrat",
		function($scope, $location, contratProvider,bienImmobilierProvider) {
			$scope.msg = "Add Contrat";
			$scope.contratForm = {
				id: undefined,
				date : undefined,
				numeroRef : undefined,
				prix : undefined,
				bien: undefined,
			};
			
			bienImmobilierProvider.getAllBienImmobilier(function(callback){
				$scope.listeBienImmobiliers = callback;
			})

			$scope.ajouter = function() {
				contratProvider.doAddContrat($scope.contratForm, function(
						callback) {
					if (callback == "OK") {
						$location.path('/contrat/all');
					}
				})
			}
		});

monApp.controller("ctrlUpdateContrat", function($scope, $rootScope, $location,
		contratProvider) {
	$scope.msg = "Update Contrat";
	$scope.contratForm = {
		id: undefined,
		date : undefined,
		numeroRef : undefined,
		prix : undefined,
		bien: undefined,
	};
	bienImmobilierProvider.getAllBienImmobilier(function(callback){
		$scope.listeBienImmobiliers = callback;
	})

	if ($rootScope.contratFormRoot != null) {
		$scope.contratForm = $rootScope.contratFormRoot;
		$rootScope.contratFormRoot = null;
	}

	$scope.modifier = function() {
		contratProvider.doUpdateContrat($scope.contratForm, function(callback) {
			if (callback == "OK") {
				$location.path('/contrat/all');
			}
		})
	}
});
