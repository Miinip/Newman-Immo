var monApp = angular.module("monApp",['ngRoute','naif.base64']);
monApp.run(function($rootScope) {
	$rootScope.authentification=false;
});