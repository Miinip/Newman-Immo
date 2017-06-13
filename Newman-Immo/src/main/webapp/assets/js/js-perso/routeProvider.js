monApp.config(function($routeProvider){
   $routeProvider.when('/home',{controller:'ctrlHome',templateUrl:'assets/templates/home.html'})
                 .when('/conseiller/one',{controller:'ctrlOneConseiller',templateUrl:'assets/templates/conseiller/getone.html'})
                 .when('/conseiller/all',{controller:'ctrlAllConseiller',templateUrl:'assets/templates/conseiller/getall.html'})
                 .when('/conseiller/add',{controller:'ctrlAddConseiller',templateUrl:'assets/templates/conseiller/add.html'})
                 .when('/conseiller/update',{controller:'ctrlUpdateConseiller',templateUrl:'assets/templates/conseiller/update.html'})
                 .otherwise({redirectTo:'/home'});
	});
