monApp.controller("ctrlNav",function($scope,$rootScope, $location){
	
	$scope.logout = function() {
		$rootScope.authentification=false;
		$location.path('/login');
	}
});

monApp.controller("ctrlHome",function($scope,$rootScope){
	$scope.msg = "Home";

});

monApp.controller("ctrlLogin",function($scope,$location,$rootScope,conseillerProvider){
	$scope.msg = "Login";
	$scope.me = {login:"",
				 password:""
	}
	conseillerProvider.getAllConseiller(function(callback){
		$scope.listeConseillers = callback;
	})
	
	$scope.submit = function() {
		
		 $scope.listeConseillers.forEach(function(element) {
			 if($scope.me.login == element.login && $scope.me.password == element.password){
			 $rootScope.authentification=true;
			 $rootScope.me = element;
			 $location.path('/home');
		 }
		});
		
	}

});