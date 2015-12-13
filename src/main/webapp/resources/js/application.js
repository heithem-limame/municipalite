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
			    $scope.connect = function() {
				// call ajax to servlet and pass login and pass
				$http
					.post(
						'http://localhost:8080/pdfgen_municipalite/LoginServlet',
						{
						    login : $scope.login,
						    pass : $scope.pass
						}).success(function(data) {
					    $scope.connected = data.connected;
					}).error(
						function(data, status) {
						    console.error(
							    'ERROR connection',
							    status, data);
						});
			    }

			} ]);