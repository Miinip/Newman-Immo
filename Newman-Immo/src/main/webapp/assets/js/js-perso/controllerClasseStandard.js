monApp.controller("ctrlOneClasseStandard", function($scope, $rootScope, $location,
		classeStandardProvider) {
	$scope.msg = "One ClasseStandard";
	$scope.idToFind = undefined;
	if ($rootScope.classeStandardViewRoot != undefined) {
		$scope.idToFind = $rootScope.classeStandardViewRoot;
		$rootScope.classeStandardViewRoot = undefined;
		classeStandardProvider.getOneClasseStandard($scope.idToFind, function(callback) {
			$scope.classeStandard = callback;
		})
	}
	$scope.find = function() {
		classeStandardProvider.getOneClasseStandard($scope.idToFind, function(callback) {
			$scope.classeStandard = callback;
		})
	}

	$scope.supprimer = function() {
		classeStandardProvider.doDeleteClasseStandard($scope.ClasseStandard.id, function(callback) {
			if (callback == "OK") {
				$location.path('/classeStandard/all');
			}
		})
	}

	$scope.modifier = function() {
		$rootScope.classeStandardFormRoot = $scope.classeStandard;
		$location.path('/classeStandard/update');
	}
});

monApp.controller("ctrlAllClasseStandard", function($scope, $rootScope, $location,
		classeStandardProvider) {
	$scope.msg = "List of ClasseStandard";
	classeStandardProvider.getAllClasseStandard(function(callback) {
		$scope.listeClasseStandards = callback;
	})

	$scope.supprimer = function(idToDelete) {
		classeStandardProvider.doDeleteClasseStandard(idToDelete, function(callback) {
			if (callback == "OK") {
				classeStandardProvider.getAllClasseStandard(function(callback) {
					$scope.listeClasseStandards = callback;
				})
			}
		})
	}

	$scope.modifier = function(classeStandardToUpdate) {
		$rootScope.classeStandardFormRoot = classeStandardToUpdate;
		$location.path('/classeStandard/update');
	}

	$scope.vue = function(classeStandardToView) {
		$rootScope.classeStandardViewRoot = classeStandardToView;
		$location.path('/classeStandard/one');
	}

	$scope.MouseOverRow = {};
	$scope.doShow = function(id) {
		$scope.MouseOverRow[id] = true;
	}
	$scope.doHide = function(id) {
		$scope.MouseOverRow[id] = false;
	}
});

monApp.controller("ctrlAddClasseStandard", function($scope, $location, classeStandardProvider) {
	$scope.msg = "Add ClasseStandard";
	$scope.classeStandardForm = {
			code : undefined,
			modeOffre : "",
			prix : undefined,
			superficie : undefined,
	};

	$scope.ajouter = function() {
		classeStandardProvider.doAddClasseStandard($scope.classeStandardForm, function(callback) {
			if (callback == "OK") {
				$location.path('/classeStandard/all');
			}
		})
	}
});

monApp.controller("ctrlUpdateClasseStandard", function($scope, $rootScope, $location,
		classeStandardProvider) {
	$scope.msg = "Update ClasseStandard";
	$scope.classeStandardForm = {
		code : undefined,
		modeOffre : "",
		prix : undefined,
		superficie : undefined,
	};

	if ($rootScope.classeStandardFormRoot != null) {
		$scope.classeStandardForm = $rootScope.classeStandardFormRoot;
		$rootScope.classeStandardFormRoot = null;
	}

	$scope.modifier = function() {
		classeStandardProvider.doUpdateClasseStandard($scope.classeStandardForm, function(callback) {
			if (callback == "OK") {
				$location.path('/classeStandard/all');
			}
		})
	}
});
