/**
 * Angular js javascript application
 * 
 * @author Heithem Limame
 */

var pdfGenApp = angular.module('pdfGenApp', []);

pdfGenApp
		.controller(
				'loginController',
				[
						'$scope',
						'$http',
						function($scope, $http) {
							$scope.error = false;
							$scope.releveImprime = false;
							$scope.releveTrouve = false;
							$scope.connexionValide = false;
							$scope.connectionStatus = 'Se Connecter';
							$scope.connect = function() {
								// call ajax to servlet and pass login and pass
								$http
										.post(
												'http://localhost:8080/pdfgen_municipalite/LoginServlet?login='
														+ $scope.login
														+ '&pass='
														+ $scope.pass, {
													login : $scope.login,
													pass : $scope.pass
												})
										.success(
												function(data) {
													$scope.connected = data;
													console
															.log('OK ! connected = '
																	+ data.connected);

													if (data.connected) {
														$scope.message = "";
														$scope.connexionValide = true;
														$scope.connectionStatus = 'Se déconnecter';
													} else {
														$scope.message = "Veuiller vérifier votre login et mot de passe";
														$scope.error = true;
													}
												}).error(function(status) {
											console.log('ERROR connection');
										});
							}
							$scope.recherche = function() {
								console.log($scope.date.getTime());

								// call ajax to servlet and pass login and pass
								$http
										.post(
												'http://localhost:8080/pdfgen_municipalite/SearchServlet?nom='
														+ $scope.nom
														+ '&prenom='
														+ $scope.prenom
														+ '&date='
														+ $scope.date.getTime())
										.success(
												function(data) {

													if (data.error == 0) {
														$scope.message = "";
														$scope.releveTrouve = true;
													} else {
														$scope.message = "Relevé introuvable";
														$scope.error = true;
													}
												}).error(function(status) {
											console.log('ERROR connection');
										});
							}

							$scope.imprimer = function() {
								// call ajax to servlet and pass id
								$http
										.post(
												'http://localhost:8080/pdfgen_municipalite/PrintServlet?id='
														+ $scope.id)
										.success(
												function(data) {
													if (data.status == 'OK') {
														$scope.message = "";
														$scope.releveImprime = true;
													} else {
														$scope.message = "Impossible d'imprimer le relevé";
														$scope.error = true;
													}
												}).error(function(status) {
											console.log('ERROR connection');
										});

							}
						}]);