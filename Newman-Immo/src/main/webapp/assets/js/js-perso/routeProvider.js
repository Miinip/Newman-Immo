monApp.config(function($routeProvider){

	   $routeProvider.when('/login',{controller:'ctrlLogin',templateUrl:'assets/templates/login.html'})
	   				 .when('/home',{controller:'ctrlHome',templateUrl:'assets/templates/home.html'})
	   				 .when('/bienImmobilier/one',{controller:'ctrlOneBienImmobilier',templateUrl:'assets/templates/bienImmobilier/getone.html'})
	                 .when('/bienImmobilier/all',{controller:'ctrlAllBienImmobilier',templateUrl:'assets/templates/bienImmobilier/getall.html'})
	                 .when('/bienImmobilier/add',{controller:'ctrlAddBienImmobilier',templateUrl:'assets/templates/bienImmobilier/add.html'})
	                 .when('/bienImmobilier/update',{controller:'ctrlUpdateBienImmobilier',templateUrl:'assets/templates/bienImmobilier/update.html'})
	                 .when('/conseiller/one',{controller:'ctrlOneConseiller',templateUrl:'assets/templates/conseiller/getone.html'})
	                 .when('/conseiller/all',{controller:'ctrlAllConseiller',templateUrl:'assets/templates/conseiller/getall.html'})
	                 .when('/conseiller/add',{controller:'ctrlAddConseiller',templateUrl:'assets/templates/conseiller/add.html'})
	                 .when('/conseiller/update',{controller:'ctrlUpdateConseiller',templateUrl:'assets/templates/conseiller/update.html'})
	                 .when('/client/one',{controller:'ctrlOneClient',templateUrl:'assets/templates/client/getone.html'})
	                 .when('/client/all',{controller:'ctrlAllClient',templateUrl:'assets/templates/client/getall.html'})
	                 .when('/client/add',{controller:'ctrlAddClient',templateUrl:'assets/templates/client/add.html'})
	                 .when('/client/update',{controller:'ctrlUpdateClient',templateUrl:'assets/templates/client/update.html'})
	                 .when('/proprietaire/one',{controller:'ctrlOneProprietaire',templateUrl:'assets/templates/proprietaire/getone.html'})
	                 .when('/proprietaire/all',{controller:'ctrlAllProprietaire',templateUrl:'assets/templates/proprietaire/getall.html'})
	                 .when('/proprietaire/add',{controller:'ctrlAddProprietaire',templateUrl:'assets/templates/proprietaire/add.html'})
	                 .when('/proprietaire/update',{controller:'ctrlUpdateProprietaire',templateUrl:'assets/templates/proprietaire/update.html'})
	                 .when('/visite/one',{controller:'ctrlOneVisite',templateUrl:'assets/templates/visite/getone.html'})
	                 .when('/visite/all',{controller:'ctrlAllVisite',templateUrl:'assets/templates/visite/getall.html'})
	                 .when('/visite/add',{controller:'ctrlAddVisite',templateUrl:'assets/templates/visite/add.html'})
	                 .when('/visite/update',{controller:'ctrlUpdateVisite',templateUrl:'assets/templates/visite/update.html'})
	                 .when('/contrat/one',{controller:'ctrlOneContrat',templateUrl:'assets/templates/contrat/getone.html'})
	                 .when('/contrat/all',{controller:'ctrlAllContrat',templateUrl:'assets/templates/contrat/getall.html'})
	                 .when('/contrat/add',{controller:'ctrlAddContrat',templateUrl:'assets/templates/contrat/add.html'})
	                 .when('/contrat/update',{controller:'ctrlUpdateContrat',templateUrl:'assets/templates/contrat/update.html'})
	                 .when('/classeStandard/one',{controller:'ctrlOneClasseStandard',templateUrl:'assets/templates/classeStandard/getone.html'})
	                 .when('/classeStandard/all',{controller:'ctrlAllClasseStandard',templateUrl:'assets/templates/classeStandard/getall.html'})
	                 .when('/classeStandard/add',{controller:'ctrlAddClasseStandard',templateUrl:'assets/templates/classeStandard/add.html'})
	                 .when('/classeStandard/update',{controller:'ctrlUpdateClasseStandard',templateUrl:'assets/templates/classeStandard/update.html'})
	                 .otherwise({redirectTo:'/login'});

	});
