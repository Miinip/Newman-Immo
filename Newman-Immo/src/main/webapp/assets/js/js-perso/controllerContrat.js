monApp.controller("ctrlOneContrat", function($scope, $rootScope, $location,
		ContratProvider) {
	$scope.msg = "One Contrat";
	$scope.idToFind = undefined;
	$scope.find = function() {
		ContratProvider.getOneContrat($scope.idToFind, function(callback) {
			$scope.contrat = callback;
		})
	}

	$scope.supprimer = function() {
		ContratProvider.doDeleteContrat($scope.Contrat.id, function(callback) {
			if (callback == "OK") {
				$location.path('/contrat/all');
			}
		})
	}

	$scope.modifier = function() {
		$rootScope.contratFormRoot = $scope.Contrat;
		$location.path('/contrat/update');
	}
});

monApp.controller("ctrlAllContrat", function($scope, $rootScope, $location,
		ContratProvider) {
	$scope.msg = "List of Contrat";
	ContratProvider.getAllContrat(function(callback) {
		$scope.listeContrats = callback;
	})

	$scope.supprimer = function(idToDelete) {
		ContratProvider.doDeleteContrat(idToDelete, function(callback) {
			if (callback == "OK") {
				ContratProvider.getAllContrat(function(callback) {
					$scope.listeContrats = callback;
				})
			}
		})
	}

	$scope.modifier = function(ContratToUpdate) {
		$rootScope.contratFormRoot = ContratToUpdate;
		$location.path('/contrat/update');
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
		function($scope, $location, ContratProvider) {
			$scope.msg = "Add Contrat";
			$scope.contratForm = {
				id_con : undefined,
				date : undefined,
				numeroRef : undefined,
				prix : undefined,
				bien_id : undefined,
			};

			$scope.ajouter = function() {
				ContratProvider.doAddContrat($scope.contratForm, function(
						callback) {
					if (callback == "OK") {
						$location.path('/contrat/all');
					}
				})
			}
		});

monApp.controller("ctrlUpdateContrat", function($scope, $rootScope, $location,
		ContratProvider) {
	$scope.msg = "Update Contrat";
	$scope.contratForm = {
		id_con : undefined,
		date : undefined,
		numeroRef : undefined,
		prix : undefined,
		bien_id : undefined,
	};

	if ($rootScope.contratFormRoot != null) {
		$scope.contratForm = $rootScope.contratFormRoot;
		$rootScope.contratFormRoot = null;
	}

	$scope.modifier = function() {
		ContratProvider.doUpdateContrat($scope.contratForm, function(callback) {
			if (callback == "OK") {
				$location.path('/contrat/all');
			}
		})
	}
});
