'use strict'
angular.module('demo.services', []).factory(
		'EmployeeService',
		[
				"$http",
				"CONSTANTS",
				function($http, CONSTANTS) {
					var service = {};
					service.getEmployeeById = function(empId) {
						var url = CONSTANTS.getAllEmployees + "/" + empId;
						return $http.get(url);
					}
					service.getAllEmployees = function() {
						return $http.get(CONSTANTS.getAllEmployees);
					}
					service.getEmployeeSalary = function(empId) {
						return $http.get(CONSTANTS.getAllEmployees + "/"
								+ empId + "/salary");
					}
					return service;
				} ]);