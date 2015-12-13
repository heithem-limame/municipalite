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
													} else {
														$scope.message = "Veuiller vérifier votre login et mot de passe";
														$scope.error = true;
													}
												}).error(function(status) {
											console.log('ERROR connection');
										});
							}

						}]);