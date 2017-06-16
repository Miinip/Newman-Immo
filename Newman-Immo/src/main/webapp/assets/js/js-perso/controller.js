monApp.controller("ctrlNav",function($scope,$rootScope,$location,$cookies){
	
	$scope.logout = function() {
		$rootScope.authentification=false;
		$cookies.put('authentification', false);
		$cookies.put('myID', 0);
		$location.path('/home');
	}
});

monApp.controller("ctrlHome",function($scope,$rootScope){
	$scope.msg = "Home";

});

monApp.controller("ctrlLogin",function($scope,$location,$rootScope,conseillerProvider,$cookies){
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
			 $rootScope.myID = element.id;
			 $cookies.put('authentification', true);
			 $cookies.put('myID', element.id);
			 $location.path('/home');
		 }
		});
		
	}

});