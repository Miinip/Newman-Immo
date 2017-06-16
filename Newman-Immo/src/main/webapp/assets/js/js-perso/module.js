var monApp = angular.module("monApp",['ngRoute','naif.base64','ngCookies']);

monApp.run(function($rootScope,$cookies) {
	$rootScope.authentification=false;
	$rootScope.authentification= $cookies.get('authentification');
	$rootScope.myID =$cookies.get('myID');
});