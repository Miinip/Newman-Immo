	monApp.controller("ctrlNav",function($scope,$rootScope,$location,$cookies){
		
		$scope.logout = function() {
			$rootScope.authentification=false;
			$cookies.remove('authentification');
			$cookies.remove('myID');
			$location.path('/home');
		}
	});

	monApp.controller("ctrlHome",function($scope,$rootScope,$cookies,conseillerProvider,visiteProvider,bienImmobilierProvider){
		$scope.msg = "Home";
		$scope.myListeVisites=[];
		
		bienImmobilierProvider.getAllBienImmobilier(function(callback) {
			$scope.listeBienImmobiliers = callback;
		})
		
		conseillerProvider.getAllConseiller(function(callback){
			 $scope.listeConseillers = callback;
			 $scope.listeConseillers.forEach(function(element) {
				 if($cookies.get('myID') == element.id){
					 $scope.conseiller = element;
				 }
			 });
		});
		
		visiteProvider.getAllVisite(function(callback){
			$scope.listeVisites = callback;
		}) 

	});

	monApp.controller("ctrlLogin",function($scope,$location,$rootScope,conseillerProvider,$cookies){
		$scope.msg1 = "Gestion Agence Newman-Immo";
		$scope.msg2 = "Connexion";
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